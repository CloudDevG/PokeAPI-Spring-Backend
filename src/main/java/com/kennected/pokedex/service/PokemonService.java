package com.kennected.pokedex.service;

import com.kennected.pokedex.dto.PokemonSpeciesDto;
import com.kennected.pokedex.entity.PokemonSpecies;
import com.kennected.pokedex.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<PokemonSpeciesDto> getAllPokemonFromPokedex() {
        return repository.getAllPokemonFromPokedexAsList()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private PokemonSpeciesDto convertEntityToDto(PokemonSpecies pokeSpecies){
        PokemonSpeciesDto pokeSpeciesDto = new PokemonSpeciesDto();
        pokeSpeciesDto.setOrderId(pokeSpecies.getOrder());
        pokeSpeciesDto.setName(pokeSpecies.getName());
        pokeSpeciesDto.setColor(pokeSpecies.getColor().getName());
        return pokeSpeciesDto;
    }

    public List<PokemonSpecies> saveSpeciesToPokedex(List<PokemonSpecies> pokeSpecies) {
        return repository.saveSpeciesToPokedex(pokeSpecies);
    }

}
