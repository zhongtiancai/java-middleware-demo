package com.zy.predictionio;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import io.prediction.EngineClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
* @author ruifeng.shan
* @date 2016-08-30
* @time 18:59
*/
public class EngineTest {
   public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
       EngineClient engineClient = new EngineClient("http://192.168.119.128:8000");

//       JsonObject response = engineClient.sendQuery(ImmutableMap.<String, Object>of(
//               "items", ImmutableList.of("item1"),
//               "num",  4
//       ));
       JsonObject response = engineClient.sendQuery(ImmutableMap.<String, Object>of(
               "user", "user0",
               "num",  4
       ));
       System.out.println(response);
       engineClient.close();
   }
}