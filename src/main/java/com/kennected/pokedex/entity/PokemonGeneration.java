package com.kennected.pokedex.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonGeneration implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pokemon_species")
    @JsonUnwrapped
    private List<NamedApiResource> pokemonSpecies = new ArrayList<>();

    public PokemonGeneration() {
    }

    public PokemonGeneration(int id, String name, List<NamedApiResource> pokemonSpecies) {
        this.id = id;
        this.name = name;
        this.pokemonSpecies = pokemonSpecies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<NamedApiResource> getPokemonSpecies() {
        return pokemonSpecies;
    }

    @Override
    public String toString() {
        return "PokemonGeneration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemonSpecies=" + pokemonSpecies +
                '}';
    }

}
