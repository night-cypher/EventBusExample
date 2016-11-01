package com.questdot.eventbusexample;

/**
 * Created by HP on 1/11/2016.
 */

public class User {
    String name;
    String phone;
    String email;

    public String getName() {
        return name;
    }

    public User(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
