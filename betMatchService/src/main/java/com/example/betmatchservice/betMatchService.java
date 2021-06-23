package com.example.betmatchservice;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class betMatchService implements betMatchRepository{

    @Override
    public void betMatch(String userName, String matchId, String bet, String Amount) {
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("Bets");

        Document document=new Document();
        document.append("UserName",userName)
                .append("matchId",matchId)
                .append("Bet",bet)
                .append("Amount",Amount);
        collection.insertOne(document);

        dbMongo.closeClient();


    }
}
