package com.antwerkz.mongo.model;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

@Entity("users")
public class User extends MongoEntity {
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addresses;

    public User() {
    }

    public User(final String firstName, final String lastName, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(final DBObject dbObject) {
        super(dbObject);
        firstName = get(dbObject, "firstName");
        lastName = get(dbObject, "lastName");
        email = get(dbObject, "email");
        addresses = new ArrayList<>();
        BasicDBList list = get(dbObject, "products");
        for (Object o : list) {
            addresses.add(new Address((DBObject) o));
        }
    }

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        return addresses;
    }

    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("User");
        sb.append("{");
        sb.append(" id=").append(getId());
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", addresses=").append(addresses);
        sb.append('}');
        return sb.toString();
    }
}
