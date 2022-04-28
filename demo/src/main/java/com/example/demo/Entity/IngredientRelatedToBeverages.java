package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="IngredientRelatedToBeverages ")
public class IngredientRelatedToBeverages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ingredientRelatedToBeveragesId")
    private Integer ingredientRelatedToBeveragesId;

    @Column(name="beverageId")
    private   Integer beverageId;

    @Column(name="ingredientId")
    private   Integer ingredientId;

    @Column(name="quantityRequired")
    private Integer quantityRequired;

    public Integer getIngredientRelatedToBeveragesId() {
        return ingredientRelatedToBeveragesId;
    }

    public void setIngredientRelatedToBeveragesId(Integer ingredientRelatedToBeveragesId) {
        this.ingredientRelatedToBeveragesId = ingredientRelatedToBeveragesId;
    }

    public IngredientRelatedToBeverages() {
    }

    public IngredientRelatedToBeverages(Integer beverageId, Integer ingredientId, Integer quantityRequired) {
        this.beverageId = beverageId;
        this.ingredientId = ingredientId;
        this.quantityRequired = quantityRequired;
    }

    public IngredientRelatedToBeverages(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public Integer getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

}
