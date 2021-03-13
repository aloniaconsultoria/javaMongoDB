package com.mongodb.quickstart.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;


public class StationLocation {

    
   
    public String type;

   
    public List<Double> coordinates;

    public void StationLocation(){

        
    }

    
    public List<Double> getCoordinates() {
        return coordinates;
    }

    public StationLocation setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public void setCoordinates(Double X, Double Y){

        this.coordinates.set(0,X);
        this.coordinates.set(1,Y);
    }

 

    public void setType(String type) {
       
       this.type=type;
      
    }

    public String getType(String type) {
       
        
        return this.type;
     }
 

   

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Station Location{");
       
        sb.append(", tipo=").append(type);
        sb.append(", Coordenadas X=").append(coordinates.get(0));
        sb.append(", Y=").append(coordinates.get(1));
        sb.append('}');
        return sb.toString();
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
