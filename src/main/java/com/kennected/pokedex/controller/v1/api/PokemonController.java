package com.kennected.pokedex.controller.v1.api;

import com.kennected.pokedex.dto.PokemonSpeciesDto;
import com.kennected.pokedex.entity.NamedApiResource;
import com.kennected.pokedex.entity.PokemonGeneration;
import com.kennected.pokedex.entity.PokemonSpecies;
import com.kennected.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private final String baseURL = "https://pokeapi.co/api/v2";

    @Autowired
    private PokemonService service;

    private final RestTemplate restTemplate;



    public PokemonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/pokedex")
    public List<PokemonSpeciesDto> findAllPokemon() {
        if(service.getAllPokemonFromPokedex().isEmpty()){
            populatePokedexByGeneration(1);
        }
        System.out.println("<++++++ RETURNING OBJECT +++++++>");
        System.out.println(service.getAllPokemonFromPokedex());
        return service.getAllPokemonFromPokedex();
    }

    private PokemonGeneration populatePokedexByGeneration(Integer genId){
        String uri = baseURL + "/generation/" + genId;

        PokemonGeneration result = restTemplate.getForObject(
                uri, PokemonGeneration.class);

        List<PokemonSpecies> newPokeList = new ArrayList<>();
        List<NamedApiResource> tempList = result.getPokemonSpecies();

        for(int i = 0; i <= 151; i++) {
            newPokeList.add(getPokemonSpeciesData(tempList.get(i).getUrl()));
        }

        service.saveSpeciesToPokedex(newPokeList);

        return result;
    }

    private PokemonSpecies getPokemonSpeciesData(String url){
        return restTemplate.getForObject(url, PokemonSpecies.class);

    }
}
