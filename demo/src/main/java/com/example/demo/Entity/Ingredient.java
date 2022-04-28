package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;


@Entity
@Table(name="Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ingredientId")
    private Integer ingredientId;

    @Column(name="ingredientName")
    private   String ingredientName;

    @Column(name="stock")
    private Integer stock;

    public Ingredient(String ingredientName,Integer stock) {
        this.stock=stock;
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Ingredient(){}

    public  String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public  Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
