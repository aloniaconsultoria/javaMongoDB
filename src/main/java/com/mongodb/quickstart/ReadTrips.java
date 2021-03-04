package com.mongodb.quickstart;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class ReadTrips {
    static String connectionString = "mongodb+srv://agarcia:Apq1adma64@cluster0.shrrf.mongodb.net/sample_training?retryWrites=true&w=majority";
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
            MongoCollection<Document> tripsCollection = sampleTrainingDB.getCollection("trips");
            MongoCursor<Document> cursor;
            FindIterable<Document> iterable = tripsCollection.find(gte("tripduration", 331));
            cursor=iterable.iterator();
            
           
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }

           
            
        }
    }
}
