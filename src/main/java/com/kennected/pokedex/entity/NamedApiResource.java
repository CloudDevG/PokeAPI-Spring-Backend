package com.kennected.pokedex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)

public class NamedApiResource implements Serializable{
    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    public NamedApiResource() {
    }

    public NamedApiResource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NamedApiResource{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
