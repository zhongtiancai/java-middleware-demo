package com.zhongtiancai.demo;
import com.google.gson.Gson;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.elasticsearch.bolt.EsIndexBolt;
import org.apache.storm.elasticsearch.common.DefaultEsTupleMapper;
import org.apache.storm.elasticsearch.common.EsConfig;
import org.apache.storm.elasticsearch.common.EsTupleMapper;
import org.apache.storm.kafka.spout.KafkaSpout;
import org.apache.storm.kafka.spout.KafkaSpoutConfig;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Properties;
import java.util.UUID;


/**
 * Created by 
 */
public class KafkaTopology {

    public static void main(String[] args) throws Exception{
        TopologyBuilder topologyBuilder = new TopologyBuilder(); // 定义topo构造器
        Properties properties = new Properties();
        properties.setProperty("group.id", "test-news-topic"); // kafka server的基本配置
        // 定义一个KafkaSpoutConfig
        KafkaSpoutConfig<String, String> kafkaSpoutConfig = KafkaSpoutConfig.builder("10.2.2.79:9092",
                "access-log")
                .setFirstPollOffsetStrategy(KafkaSpoutConfig.FirstPollOffsetStrategy.UNCOMMITTED_EARLIEST)
                .setProp(properties).build();
        KafkaSpout<String, String> kafkaSpout = new KafkaSpout<String, String>(kafkaSpoutConfig); // KafkaSpout实现
        topologyBuilder.setSpout("kafka-spout", kafkaSpout, 1); // 注入Spout
        topologyBuilder.setBolt("kafka-bolt", new NewsBlot(), 1).shuffleGrouping("kafka-spout"); // 通过storm获取kafka-spout数据

        EsConfig esConfig = new EsConfig(new String[]{"http://10.2.2.79:9200"}).withDefaultHeaders(new Header[] {
        		new BasicHeader("Content-Type", "application/json;charset=UTF-8")
        }); // 定义一个ES的配置信息
        EsTupleMapper esTupleMapper = new DefaultEsTupleMapper(); // 定义ES的默认映射
        EsIndexBolt indexBolt = new EsIndexBolt(esConfig, esTupleMapper); //定义一个索引Bolt
        topologyBuilder.setBolt("es-bolt", indexBolt, 1).shuffleGrouping("kafka-bolt"); // 向topology注入indexBolt以处理kafka-bolt的数据

    // 提交到storm集群
        Config config = new Config();
        config.setMessageTimeoutSecs(90);
        if (args.length > 0) { // 集群模式
            config.setDebug(false);
            StormSubmitter.submitTopology(args[0],
                    config, topologyBuilder.createTopology());
        } else { // 本地测试模式，一般测试使用这个
//            config.setDebug(true);
            config.setNumWorkers(2);
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("local-kafka-storm-topology",
                    config, topologyBuilder.createTopology());
        }
    }

    // 自定义处理一个kafka的消息映射Bolt
    static class NewsBlot extends BaseBasicBolt {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// 当有消息时执行，封装消息发送，格式与定义输出字段一一对应declarer.declare（xxx）
        public void execute(Tuple input, BasicOutputCollector collector) {
			String message = (String) input.getValue(4);
			System.out.println(message);
			String[] fileds = message.split("  ");
			String id = UUID.randomUUID().toString();
			AccessLog accessLog = new AccessLog();
			if (fileds.length < 2) {
				accessLog.setIp("localhost");
				accessLog.setUrl("www.baidu.com");
			} else {
				accessLog.setIp(fileds[0].split("- -")[0]);
				accessLog.setUrl(fileds[1]);
			}
            Gson gson = new Gson();
            String source = gson.toJson(accessLog);
            collector.emit(new Values(source, "idx_sys", "tb_access_log", id));
        }

        // 定义消息发送的字段映射，这里是EsTupleMapper所需要的字段映射逻辑，可跟踪源代码理解
        public void declareOutputFields(OutputFieldsDeclarer declarer) {
            declarer.declare(new Fields("source", "index", "type", "id"));
        }
    }
    static class AccessLog {
    	private String url;
    	private String ip;
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		
    	
    }
    
}