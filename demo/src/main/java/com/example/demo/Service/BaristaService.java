package com.example.demo.Service;

import com.example.demo.DTO.BeverageInput;
import com.example.demo.Entity.Beverages;
import com.example.demo.Entity.Ingredient;

import java.util.List;

public interface BaristaService {
    public Object addIngredient(String ingredientName, Integer stock);
    public void addBeverage(String beverage_name);
    public Object addBeverageWithIngredient(BeverageInput beverageInput);
    public List<Beverages> getAllBeverages();
    public Object updateStock(Ingredient ingredient);
    public String getBeverage(String beverageName);

}
