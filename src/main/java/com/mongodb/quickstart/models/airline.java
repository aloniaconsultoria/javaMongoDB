package com.mongodb.quickstart.models;

import java.util.Objects;

public class airline {

    private int id;
    private String name;
    private String alias;
    private String iata;

    

   

    public airline setId(int theId){

        this.id=theId;
        return this;
    }

    public airline setName(String theName){

        this.name=theName;
        return this;
    }

    public airline setAlias(String theAlias){

        this.alias=theAlias;
        return this;
    }

    public airline setIata(String iataCode){

        this.iata=iataCode;
        return this;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }

    public String getAlias(){

        return alias;
    }

    public String getIata(){

        return iata;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Airline{");
        sb.append("Id='").append(id).append('\'');
        sb.append(", name=").append(name);
        sb.append(", alias=").append(alias);
        sb.append(", iata=").append(iata);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        airline airline1 = (airline) o;
        return Objects.equals(id, airline1.id) && Objects.equals(iata, airline1.iata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iata);
    }
    
}
