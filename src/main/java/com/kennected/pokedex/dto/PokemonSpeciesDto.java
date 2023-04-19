package com.kennected.pokedex.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PokemonSpeciesDto {

    @NotNull(message = "Field 'orderId' for PokemonSpecies must not be null")
    private int orderId;
    @NotEmpty(message = "Field 'name' for PokemonSpecies must contain a String value")
    private String name;
    @NotEmpty(message = "Field 'color' for PokemonSpecies must contain a String value")
    private String color;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
