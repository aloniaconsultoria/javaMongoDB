package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;



public class Create_zip {

    

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://agarcia:Apq1adma64@cluster0.shrrf.mongodb.net/sample_training?retryWrites=true&w=majority")) {

            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
            MongoCollection<Document> zipsCollection = sampleTrainingDB.getCollection("zips");

            insertOneDocument(zipsCollection);
            
        }
    }

    private static void insertOneDocument(MongoCollection<Document> zipsCollection) {
        zipsCollection.insertOne(generateNewZip());
        System.out.println("One grade inserted for studentId 10000.");
    }

   

    private static Document generateNewZip() {

        Document loc=new Document ("y",32.641445).append("x",85.951086);
        return new Document("_id", new ObjectId()).append("city", "Madrid")
                                                  .append("zip","28027")
                                                  .append("loc", loc)
                                                  .append("pop",3450456)
                                                  .append("state","MADRID")
                                                  .append("tipo","Muy Grande");
    }
}
