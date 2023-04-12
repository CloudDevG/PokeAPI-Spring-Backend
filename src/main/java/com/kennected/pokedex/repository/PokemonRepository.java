package com.kennected.pokedex.repository;

import com.kennected.pokedex.entity.PokemonSpecies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonRepository {

    private List<PokemonSpecies> pokedex = new ArrayList<PokemonSpecies>();


    public List<PokemonSpecies> getAllPokemonFromPokedexAsList() {
        return pokedex;
    }

    public List<PokemonSpecies> saveSpeciesToPokedex(List<PokemonSpecies> pokeSpecies) {
        this.pokedex = pokeSpecies;
        return pokedex;
    }

}
