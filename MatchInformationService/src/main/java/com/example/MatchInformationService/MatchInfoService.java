package com.example.MatchInformationService;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
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

}
