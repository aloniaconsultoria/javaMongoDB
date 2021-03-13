package com.mongodb.quickstart;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;

import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

import com.mongodb.quickstart.models.trip;
import com.mongodb.quickstart.models.StationLocation;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ProcessTrips {
    static String uriString = "mongodb+srv://agarcia:Apq1adma64@cluster0.shrrf.mongodb.net/sample_training?retryWrites=true&w=majority";
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString(uriString);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                                                                .applyConnectionString(connectionString)
                                                                .codecRegistry(codecRegistry)
                                                                .build();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("sample_training");
           

            MongoCollection<Document> tripsCollection =db.getCollection("trips");
            MongoCursor<Document> cursor;
            FindIterable<Document> iterable = tripsCollection.find(gte("tripduration", 331));
            cursor=iterable.iterator();
            
           
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
         
            

           
        }
    }
}
