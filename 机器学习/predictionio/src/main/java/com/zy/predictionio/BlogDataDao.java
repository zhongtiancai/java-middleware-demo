package com.zy.predictionio;
import com.google.common.collect.ImmutableList;

import com.google.common.collect.Lists;

import io.prediction.Event;

import io.prediction.EventClient;

import java.io.IOException;

import java.util.List;

import java.util.Random;

import java.util.concurrent.ExecutionException;



/**

 * @author ruifeng.shan

 * @date 2016-08-30

 * @time 16:07

 */

public class BlogDataDao {

    private static final String API_KEY = "5Gziq3RuZeulUCrCy7RPevwou4LYKK48JHF4rG1SXxY7e1JaiZnKMr-CYthI-mPu";



    private EventClient eventClient;



    public BlogDataDao() {

        this.eventClient = new EventClient(API_KEY,"http://192.168.119.128:7070");

    }



    public BlogDataDao(String accessKey) {

        this.eventClient = new EventClient(accessKey);

    }



    public void addEvents() throws InterruptedException, ExecutionException, IOException {

        addUserEvents();

        addItemEvents();

        addViewEvents();
        eventClient.close();

    }



    public void addUserEvents() throws InterruptedException, ExecutionException, IOException {

        for (int i = 0; i < 100; i++) {

            List<Event> events = Lists.newArrayList();

            events.add(new Event().entityId("user"+ i).entityType("user").event("$set"));

            List<String> result = eventClient.createEvents(events);

            System.out.println(result);

        }

    }



    public void addItemEvents() throws InterruptedException, ExecutionException, IOException {

        List<Event> events = Lists.newArrayList();

        events.add(new Event().entityId("item1").entityType("item").event("$set").property("categories", ImmutableList.of("machine-learning")));

        events.add(new Event().entityId("item2").entityType("item").event("$set").property("categories", ImmutableList.of("javascript")));

        events.add(new Event().entityId("item3").entityType("item").event("$set").property("categories", ImmutableList.of("scala")));

        events.add(new Event().entityId("item4").entityType("item").event("$set").property("categories", ImmutableList.of("artificial-intelligence")));

        events.add(new Event().entityId("item5").entityType("item").event("$set").property("categories", ImmutableList.of("statistics")));

        events.add(new Event().entityId("item6").entityType("item").event("$set").property("categories", ImmutableList.of("python")));

        events.add(new Event().entityId("item7").entityType("item").event("$set").property("categories", ImmutableList.of("web-development")));

        events.add(new Event().entityId("item8").entityType("item").event("$set").property("categories", ImmutableList.of("security")));

        events.add(new Event().entityId("item9").entityType("item").event("$set").property("categories", ImmutableList.of("ruby")));

        events.add(new Event().entityId("item10").entityType("item").event("$set").property("categories", ImmutableList.of("openshift")));



        List<String> result = eventClient.createEvents(events);

        System.out.println(result);

    }



 
        public void addViewEvents() throws InterruptedException, ExecutionException, IOException {

            for (int i = 0; i < 100; i++) {

                List<Event> events = Lists.newArrayList();

                events.add(new Event().entityId("user"+ i).entityType("user").event("view").targetEntityType("item").targetEntityId("item1"));

                events.add(new Event().entityId("user"+ i).entityType("user").event("view").targetEntityType("item").targetEntityId("item4"));

                Random random = new Random();

                int id = random.nextInt(9) + 1;

                events.add(new Event().entityId("user" + i).entityType("user").event("view").targetEntityType("item").targetEntityId("item" + id));



                List<String> result = eventClient.createEvents(events);

                System.out.println(result);

            }



    }



    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

        BlogDataDao itemDataDao = new BlogDataDao();

        itemDataDao.addEvents();

    }

}