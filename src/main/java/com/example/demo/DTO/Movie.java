package com.example.demo.DTO;

public class Movie {
    String id;
    String name;
    String type;
    boolean isFavorite;

    public Movie(String id, String name, String type, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isFavorite = isFavorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
