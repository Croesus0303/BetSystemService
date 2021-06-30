package com.example.UserService;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Map;

public class UserService implements UserRepository {

    @Override
    public void createUser(String name, String password) {
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("User");

        Document document=new Document();
        document.append("UserName",name)
                .append("Password",password)
                .append("Balance",0.00);


        collection.insertOne(document);

        dbMongo.closeClient();


    }

    @Override
    public String loadMoney(Map<String,Object> json) {
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("User");
        FindIterable<Document> result = collection.find(Filters.eq("UserName",json.get("Username")));
        Document document=result.first();
        Double newBalance = (Double) document.get("Balance") + (Double)json.get("Amount");
        Update documentResult = new Update();
        documentResult.set("Balance", newBalance);

        collection.updateOne(Filters.eq("UserName",json.get("Username")),documentResult.getUpdateObject(),new UpdateOptions().upsert(true));
        dbMongo.closeClient();

        return "Yeni bakiye : "+ newBalance.toString();
    }

    @Override
    public String gameTransaction(Map<String,Object> json) {
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collectionUser=dbMongo.getMongoDatabase().getCollection("User");
        MongoCollection<Document> collectionBets=dbMongo.getMongoDatabase().getCollection("Bets");
        FindIterable<Document> result = collectionUser.find(Filters.eq("UserName",json.get("Username")));
        Document document=result.first();
        Double transferMoney = (Double) json.get("Amount");
        if(transferMoney> (Double)document.get("Balance")){
            return "Yeterli bakiyeniz yok";

        }
        else {

            Document resultDocument = new Document();
            resultDocument.append("_id" ,json.get("GameId"))
                    .append("Username",json.get("Username"))
                    .append("Amount",json.get("Amount"))
                    .append("GameType", json.get("GameType"));

            Double resultBalance = (Double) document.get("Balance") - transferMoney;

            Update documentResult = new Update();
            documentResult.set("Balance", resultBalance);
            collectionBets.insertOne(resultDocument);
            collectionUser.updateOne(Filters.eq("UserName",json.get("Username")),documentResult.getUpdateObject(),new UpdateOptions().upsert(true));

            return "İşleminiz başarıyla gerçekleşmiştir. Yeni bakiyeniz : " + resultBalance.toString();
        }

    }
}
