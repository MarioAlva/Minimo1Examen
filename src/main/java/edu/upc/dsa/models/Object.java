package edu.upc.dsa.models;

public class Object {
    String nombre;
    String descripcion;
    int coins;

    public Object(String nombre, String descripcion, int coins) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coins = coins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}