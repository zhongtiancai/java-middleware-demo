package hello;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
 
public class Listener {
 
 

 
    /**
     * 监听kafka消息,如果有消息则消费,同步数据到新烽火的库
     * @param record 消息实体bean
     */
    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("收到信息"+message);
        }
 }
 
   
}