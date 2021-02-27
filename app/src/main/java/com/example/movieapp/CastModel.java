package com.example.movieapp;

import java.util.Objects;

public class CastModel {
   private String name;
   private String knownFor;
   private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnownFor() {
        return knownFor;
    }

    public void setKnownFor(String knownFor) {
        this.knownFor = knownFor;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "CastModel{" +
                "name='" + name + '\'' +
                ", knownFor='" + knownFor + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CastModel)) return false;
        CastModel castModel = (CastModel) o;
        return Objects.equals(name, castModel.name) &&
                Objects.equals(knownFor, castModel.knownFor) &&
                Objects.equals(profile, castModel.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, knownFor, profile);
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
