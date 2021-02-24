package com.example.movieapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonResponse {
    private int page;
    private List<JsonResultsResponse> results;
    private int total_pages;
    private int total_results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<JsonResultsResponse> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public void setResults(List<JsonResultsResponse> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonResponse)) return false;
        JsonResponse that = (JsonResponse) o;
        return results.equals(that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "results=" + results +
                '}';
    }


}
