package com.antwerkz.mongo.model;

import com.google.code.morphia.annotations.Entity;
import com.mongodb.DBObject;

@Entity("addresses")
public class Address extends MongoEntity {
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(final String street, final String city, final String state, final String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(final DBObject o) {
        super(o);
        street = get(o, "street");
        street2 = get(o, "street2");
        city = get(o, "city");
        state = get(o, "state");
        zip = get(o, "zip");
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(final String street2) {
        this.street2 = street2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }
}