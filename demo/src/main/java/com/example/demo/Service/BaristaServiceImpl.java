package com.example.demo.Service;

import com.example.demo.DTO.BeverageInput;
import com.example.demo.Entity.Beverages;
import com.example.demo.Entity.Ingredient;
import com.example.demo.Entity.IngredientRelatedToBeverages;
import com.example.demo.Exception.ValidationException;
import com.example.demo.Repository.BeveragesRepository;
import com.example.demo.Repository.IngredientRelatedToBeveragesRepository;
import com.example.demo.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BaristaServiceImpl implements BaristaService {

    @Autowired
    private BeveragesRepository beveragesRepository;

   @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientRelatedToBeveragesRepository ingredientRelatedToBeveragesRepository;

    @Override
    public Object addIngredient(String ingredientName, Integer stock) {
        Ingredient ingredient = ingredientRepository.getIngredient(stock,ingredientName);
        if(ingredient.getIngredientName().equals(ingredientName)){
            throw new ValidationException("Ingredient Is Already Present");
        }
        if (ingredient == null) {
            ingredient = new Ingredient(ingredientName,stock);
            ingredientRepository.save(ingredient);
        }

        return ingredient;
    }

    @Override
    public void addBeverage(String beverageName){
        Beverages currentBeverage = beveragesRepository.getBeverageByName(beverageName);
        if (currentBeverage == null) {
            currentBeverage = new Beverages(beverageName);
           //  System.out.println(currentBeverage);
            beveragesRepository.save(currentBeverage);
        }
    }

    @Override
    public Object addBeverageWithIngredient(BeverageInput beverageInput){
        addBeverage(beverageInput.getBeverageName());
        Beverages currentBeverage = beveragesRepository.getBeverageByName(beverageInput.getBeverageName());
        for(Ingredient ingredient:beverageInput.getIngredients()){
            Ingredient currentIngredient=ingredientRepository.getIngredientByName(ingredient.getIngredientName());
            if(currentIngredient==null){
                addIngredient(ingredient.getIngredientName(),0);
                currentIngredient=ingredientRepository.getIngredientByName(ingredient.getIngredientName());
            }

            ingredientRelatedToBeveragesRepository.save(new IngredientRelatedToBeverages(currentBeverage.getBeverageId(),currentIngredient.getIngredientId(),ingredient.getStock()));
        }
        return currentBeverage;
    }

    @Override
    public List<Beverages> getAllBeverages(){
        return beveragesRepository.getAllBeverages();
    }

    public Object updateStock(Ingredient ingredient){
        Ingredient currentIngredient=ingredientRepository.getIngredientByName(ingredient.getIngredientName());
        if(!ingredient.getIngredientName().equals(ingredient)){
            throw new ValidationException("no such Ingredient Is Present");
        }
        if(currentIngredient==null){
            ingredient = new Ingredient(ingredient.getIngredientName(),ingredient.getStock());
            ingredientRepository.save(ingredient);
        }
        currentIngredient.setStock(ingredient.getStock()+ingredient.getStock());
        ingredientRepository.save(currentIngredient);
        return currentIngredient;
    }
    @Override
    public String getBeverage(String beverageName){
        List<IngredientRelatedToBeverages> currentIrtb=ingredientRelatedToBeveragesRepository.getRelationByBeverageName(beverageName);
        for(IngredientRelatedToBeverages irtb:currentIrtb){
            Ingredient currentIngredient= ingredientRepository.getIngredientById(irtb.getIngredientRelatedToBeveragesId());
            if(currentIngredient.getStock()< irtb.getQuantityRequired() ){
                if(currentIngredient.getStock()==0)
                    return beverageName+" cannot be prepared because "+currentIngredient.getIngredientName() +" is not available";
                else
                    return beverageName+" cannot be prepared because "+currentIngredient.getIngredientName()+" is not sufficient";
            }
            currentIngredient.setStock( currentIngredient.getStock()- irtb.getQuantityRequired());
            updateStock(currentIngredient);
        }
        return beverageName +" is prepared";
    }

}
