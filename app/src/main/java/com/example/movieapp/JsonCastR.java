package com.example.movieapp;

import java.util.ArrayList;
import java.util.Objects;

public class JsonCastR {
     private int id;
     private ArrayList<JsonResponseCast> cast;
     private ArrayList<JsonResponseCrew> crew;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<JsonResponseCast> getCast() {
        return cast;
    }

    public ArrayList<JsonResponseCrew> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<JsonResponseCrew> crew) {
        this.crew = crew;
    }

    public JsonCastR(ArrayList<JsonResponseCrew> crew) {
        this.crew = crew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonCastR)) return false;
        JsonCastR jsonCastR = (JsonCastR) o;
        return id == jsonCastR.id &&
                Objects.equals(cast, jsonCastR.cast) &&
                Objects.equals(crew, jsonCastR.crew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cast, crew);
    }

    @Override
    public String toString() {
        return "JsonCastR{" +
                "id=" + id +
                ", cast=" + cast +
                ", crew=" + crew +
                '}';
    }

    public void setCast(ArrayList<JsonResponseCast> cast) {
        this.cast = cast;
    }
}
