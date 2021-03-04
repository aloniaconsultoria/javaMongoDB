package com.mongodb.quickstart.models;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import java.util.Objects;

public class route {
    private ObjectId id;
    @BsonProperty(value = "airline")
    private airline theAirline;
    private String src_airport;
    private String dst_airport;
    private String codeshare;
    private int stops;
    private String airplane;

    public void route(){}

    

    public ObjectId getId() {
        return id;
    }

    public route setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public route setAirplane(String airplane) {
        this.airplane = airplane;
        return this;
    }
    public route setSrc_airport(String src_airport) {
        this.src_airport = src_airport;
        return this;
    }

    public route setDst_airport(String dst_airport) {
        this.dst_airport = dst_airport;
        return this;
    }

    public route setTheAirline(airline theAirline) {
        this.theAirline = theAirline;
        return this;
    }

    public route setCodeshare(String codeshare) {
        this.codeshare = codeshare;
        return this;
    }

    public route setStops(int stops) {
        this.stops = stops;
        return this;
    }

    

   
    

    public String getAirplane() {
        
        return this.airplane;
    }
    public String getSrc_airport() {
        return this.src_airport;
        
    }

    public String getDst_airport() {
        return this.dst_airport;
    }

    public airline getTheAirline() {
        return this.theAirline;
    }

    public String getCodeshare() {
        return this.codeshare;
    
    }

    public int getStops() {
        return this.stops;
        
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Route{");
        sb.append("Aeropuerto Origen'").append(src_airport).append('\'');
        sb.append(", Aeorpuerto Destion=").append(dst_airport);
        sb.append(", Codigo Compartido=").append(codeshare);
        sb.append(", Paradas=").append(stops);
        sb.append(", Avion=").append(airplane);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        route route1 = (route) o;
        return Objects.equals(src_airport, route1.src_airport) && Objects.equals(dst_airport, route1.dst_airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src_airport, dst_airport);
    }
}
