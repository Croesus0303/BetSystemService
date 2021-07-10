package com.example.lotteryservice;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.w3c.dom.Node;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class lotteryService implements lotteryRepository {


    @Override
    public String getLotteryInfo() {
        ArrayList<Document> resultList= new ArrayList<Document>();
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("Lottery");

        FindIterable<Document> result =collection.find();

        Document document=result.first();
        dbMongo.closeClient();


        return  document.toJson();


    }
    public String playLottery(String userName){
        //UUID id = UUID.randomUUID();
        Random rnd = new Random();
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("ActiveTickets");
        String magicNumbers="";
        Document document = new Document();
        for(int i =0;i<8;i++){
            magicNumbers+=Integer.toString(rnd.nextInt(9));
        }
        document.append("Username",userName)
                .append("magicNumbers",magicNumbers);

        collection.insertOne(document);
        dbMongo.closeClient();

        return "Piyango oynandı. Oynanan bilet: "+magicNumbers;
    }
    public String checkLottery(String userName){
        //String winningNumbers="123457689";

        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("ActiveTickets");
        MongoCollection<Document> collectionResults=dbMongo.getMongoDatabase().getCollection("Lottery");
        FindIterable<Document> results = collectionResults.find();
        FindIterable<Document> lotteryCoupon = collection.find(Filters.eq("Username",userName));//Düzeltilecek
        Document document = lotteryCoupon.first();
        Document documentResult = results.first();
        String winningNumbers=(String)documentResult.get("WinnerNumbers");
        String magicNumbers = (String)document.get("magicNumbers");
        if(magicNumbers.equals(winningNumbers)){
            return "PİYANGOYU KAZANDINIZ TEBRİKLER!";
        }
        else if(magicNumbers.substring(0,2).equals(winningNumbers.substring(0,2))){
            return "AMORTİ";
        }
        else{
            return "KAYBETTİNİZ";
        }

    }

}
