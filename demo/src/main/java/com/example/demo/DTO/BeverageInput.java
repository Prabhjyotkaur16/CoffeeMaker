package com.example.demo.DTO;

import com.example.demo.Entity.Ingredient;

import java.util.List;

public class BeverageInput {
    private String beverageName;
    private List<Ingredient> ingredients;

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
