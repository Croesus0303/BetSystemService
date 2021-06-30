package com.example.MatchInformationService;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDb {
    final String url="mongodb://bugra:bugra123123@betsystem-shard-00-00.36jvp.mongodb.net:27017,betsystem-shard-00-01.36jvp.mongodb.net:27017,betsystem-shard-00-02.36jvp.mongodb.net:27017/BetSystem?ssl=true&replicaSet=atlas-9104ya-shard-0&authSource=admin&retryWrites=true&w=majority" ;

    private MongoClientURI connectionString;

    private MongoClient mongoClient;

    private MongoDatabase mongoDatabase;

    public MongoDb(){

        connectionString=new MongoClientURI(url);
        mongoClient=new MongoClient(connectionString);

        mongoDatabase=mongoClient.getDatabase("BetSystemMatch");

    }


    public MongoDatabase getMongoDatabase() {

        return mongoDatabase;



    }

    public void closeClient(){

        mongoClient.close();


    }

}
