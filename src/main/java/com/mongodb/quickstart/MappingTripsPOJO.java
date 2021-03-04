package com.mongodb.quickstart;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.quickstart.models.airline;
import com.mongodb.quickstart.models.route;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MappingTripsPOJO {
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
            MongoCollection<route> routes = db.getCollection("routes", route.class);

            // create a new route.
            route newRoute = new route().setSrc_airport("CRH")
                                        .setDst_airport("STG")
                                        .setAirplane("CR2")
                                        .setCodeshare("")
                                        .setStops(1)
                                        .setTheAirline(new airline().setId(358)
                                                                    .setName("IBERIA")
                                                                    .setAlias("3B")
                                                                    .setIata("IBR"));
            routes.insertOne(newRoute);
            System.out.println("Route inserted.");

           
        }
    }
}
