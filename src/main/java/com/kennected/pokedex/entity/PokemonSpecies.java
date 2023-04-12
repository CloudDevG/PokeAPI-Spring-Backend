package com.kennected.pokedex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSpecies implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("order")
    private int order;

    @JsonProperty("name")
    private String name;

    @JsonProperty("color")
    private NamedApiResource color;

    public PokemonSpecies() {
    }

    public PokemonSpecies(int id, int order, String name, NamedApiResource color) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public NamedApiResource getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "PokemonSpecies{" +
                "id=" + id +
                ", order=" + order +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
