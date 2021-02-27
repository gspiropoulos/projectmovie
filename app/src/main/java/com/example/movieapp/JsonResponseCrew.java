package com.example.movieapp;

import java.util.Objects;

public class JsonResponseCrew {
    private String name;
    private String known_for_department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonResponseCrew)) return false;
        JsonResponseCrew that = (JsonResponseCrew) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(known_for_department, that.known_for_department);
    }

    @Override
    public String toString() {
        return "JsonResponseCrew{" +
                "name='" + name + '\'' +
                ", known_for_department='" + known_for_department + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, known_for_department);
    }
}
