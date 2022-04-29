package edu.upc.dsa.models;

import edu.upc.dsa.models.Object;

import java.util.LinkedList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String surnames;
    private String email;
    private String password;
    private List<Object> o;
    private int coins;


    public User(String id, String name, String surnames, String email, String password, int coins) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.password = password;
        this.o = new LinkedList<>();
        this.coins = coins;
    }

    public List<Object> getO() {
        return o;
    }

    public void addobject(Object object) {
        o.add(object);
    }

    public void setO(List<Object> o) {
        this.o = o;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}