package com.example.movieapp;

import java.util.Objects;

public class JsonResponseCast {
    private String name;
    private String known_for_department;
    private String profile_path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonResponseCast)) return false;
        JsonResponseCast that = (JsonResponseCast) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(known_for_department, that.known_for_department) &&
                Objects.equals(profile_path, that.profile_path);
    }

    @Override
    public String toString() {
        return "JsonResponseCast{" +
                "name='" + name + '\'' +
                ", known_for_department='" + known_for_department + '\'' +
                ", profile_path='" + profile_path + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, known_for_department, profile_path);
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
