package com.example.lotteryservice;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDb {
    final String url="mongodb://bugra:bugra123123@betsystemmatch-shard-00-00.otwt9.mongodb.net:27017,betsystemmatch-shard-00-01.otwt9.mongodb.net:27017,betsystemmatch-shard-00-02.otwt9.mongodb.net:27017/BetSystemMatch?ssl=true&replicaSet=atlas-aot3n4-shard-0&authSource=admin&retryWrites=true&w=majority" ;

    private MongoClientURI connectionString;

    private MongoClient mongoClient;

    private MongoDatabase mongoDatabase;

    public MongoDb(){

        connectionString=new MongoClientURI(url);
        mongoClient=new MongoClient(connectionString);

        mongoDatabase=mongoClient.getDatabase("betSystemLottery");

    }


    public MongoDatabase getMongoDatabase() {

        return mongoDatabase;



    }

    public void closeClient(){

        mongoClient.close();


    }

}
