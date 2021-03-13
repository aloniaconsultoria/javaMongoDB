package com.mongodb.quickstart.models;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import java.util.Objects;
import java.util.Date;

public class trip {
    private ObjectId id;
    private int tripduration;
    @BsonProperty(value = "start station id")
    public int Startstationid;
    @BsonProperty(value = "start station name")
    public String Startstationname;
    @BsonProperty(value = "end station id")
    public int Endstationid;
    @BsonProperty(value = "end station name")
    public String Endstationname;
    private int bikeid;
    private String usertype;
    @BsonProperty(value = "birth year")
    private int Birthyear;
    private int gender;
    @BsonProperty(value = "start station location")
    public StationLocation Startstationloc;
    @BsonProperty(value = "end station location")
    public StationLocation Endstationloc;
    @BsonProperty(value = "start time")
    private Date Starttime;
    @BsonProperty(value = "end time")
    private Date Endtime;

    public void trip(){

        Startstationloc=new StationLocation();
        Endstationloc=new StationLocation();


    }

    public ObjectId getId() {
        return id;
    }

    public trip setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public void setStartstationid(int startId) {

        this.Startstationid=startId;
        
    }

    public void setStartstationname(String name) {

        this.Startstationname=name;
        
    }

    public String getStartstationname() {

        return this.Startstationname;
        
    }

    public void setStartstationloc(String type, Double X,Double Y) {
        
        this.Startstationloc.setCoordinates( X, Y);
        this.Startstationloc.setType(type);
    
    }

    public StationLocation getStartstationloc() {
 
        return this.Startstationloc;
    }
    

    public void setEndstationid(int endId) {

        this.Endstationid=endId;
        
    }

    public void setEndstationname(String name) {

        this.Endstationname=name;
        
    }


    public String getEndstationname() {

        return this.Endstationname;
        
    }
    public void setEndstationloc(String type, Double X,Double Y) {
        this.Endstationloc.setCoordinates( X, Y);
        this.Endstationloc.setType(type);
        
    }

    public StationLocation getEndStation() {
 
        return this.Endstationloc;
    }

    public void setTripduration(int duration){
        
        this.tripduration=duration;
        
    }

    public int getTripduration(){
        
        return this.tripduration;
    
    }


    public trip setBikeid(int bikeid){
        
        this.bikeid=bikeid;
        return this;
    }

    public int getBikeid(){
        
        return this.bikeid;
    
    }
    
    public void setUsertype(String usertype){
        
        this.usertype=usertype;
        
    }

    public String getUsertype(){
        
        return this.usertype;
    
    }
    
    public void setBirthyear(int year){
        
        this.Birthyear=year;
       
    }

    public int getbBirthyear(){
        
        return this.Birthyear;
    
    }
    
    public void setGender(int gender){
        
        this.gender=gender;
       
    }

    public int getGender(){
        
        return this.gender;
    
    }
   
    public void setStarttime(Date startTime){
        
        this.Starttime=startTime;
    
    }

    public Date getStarttime(){
        
        return this.Starttime;
    
    }

    public void setEndtime(Date endTime){
        
        this.Endtime=endTime;
        
    }

    public Date getEndtime(){
        
        return this.Endtime;
    
    }
   

    

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("trip{");
        sb.append("Estacion Origen=").append(Startstationname).append('\'');
        sb.append(", Estacion Destino=").append(Endstationname).append('\'');
        sb.append("Estacion Origen Coord=").append(Startstationloc).append('\'');
        sb.append("Duracion del viaje=").append(tripduration).append('\'');
        sb.append("Identificacion bicicleta=").append(bikeid).append('\'');

        sb.append('}');
        return sb.toString();
    }

   

    @Override
    public int hashCode() {
        return Objects.hash(Startstationname, Endstationname);
    }
}
