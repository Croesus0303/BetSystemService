package com.example.UserService;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UserService implements UserRepository {

    @Override
    public void createUser(String name, String password) {
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("User");

        Document document=new Document();
        document.append("UserName",name)
                .append("Password",password);


        collection.insertOne(document);

        dbMongo.closeClient();


    }
}
