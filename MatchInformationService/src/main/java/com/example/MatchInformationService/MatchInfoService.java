package com.example.MatchInformationService;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
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
import java.util.Map;
import java.util.UUID;

public class MatchInfoService implements MatchInfoRepository {


    @Override
    public String getMatchInfos() {
        ArrayList<Document> resultList= new ArrayList<Document>();
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("Match");

        FindIterable<Document> result =collection.find();

        Document document=result.first();  // İlkini aldım listedeki örnek için bunu bütün listeyi almak lazım

        dbMongo.closeClient();


        return  document.toJson();


    }

    @Override
    public String createCoupon(createCouponRequest request) {
        UUID id = UUID.randomUUID();

        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("Coupons");
        request._id=id.toString();

        List<BasicDBObject> array = new ArrayList<BasicDBObject>();
        BasicDBList dbl = new BasicDBList();
        for(int i =0 ; i<request.matches.size();i++){
            BasicDBObject temp = new BasicDBObject();
            temp.put("Match",request.matches.get(i).MatchId);
            temp.put("Result",request.matches.get(i).result);
            temp.put("Rate",request.matches.get(i).rate);
            array.add(temp);
        }

        Document document = new Document();

        document.append("_id",request._id)
                .append("Matches",array)
                .append("Amount", request.Amount);


        collection.insertOne(document);
        dbMongo.closeClient();

        return "Kupon başarıyla oluşturulmuştur";
    }

    @Override
    public String checkCoupon(Map<String,Object> json) {
        String id = (String) json.get("_id");
        boolean result = true;
        MongoDb dbMongo=new MongoDb();
        MongoCollection<Document> collection=dbMongo.getMongoDatabase().getCollection("Coupons");
        MongoCollection<Document> collectionResults=dbMongo.getMongoDatabase().getCollection("Results");
        FindIterable<Document> results = collectionResults.find();
        FindIterable<Document> coupon = collection.find(Filters.eq("_id",id));
        Document document = coupon.first();
        double Amount= (double) document.get("Amount");
        ArrayList<Map> temp = (ArrayList<Map>) document.get("Matches");
        for(Map matchs : temp){
            String matchId = (String) matchs.get("Match");
            for(Document doc : results){
                Amount *= (Double) matchs.get("Rate");
                String tempId = (String) doc.get("MatchId");
                if(tempId.equals(matchId)){
                    if(matchs.get("Result") != doc.get("Result")){
                        result = false;
                        return "Kuponunuz kaybetmiştir";
                    }
                }
        }

        }

        if(result == true){
            return "Tebrikler kuponunuz"+ Amount+" TL kazanmıştır.";
        }
        return null;

    }


}
