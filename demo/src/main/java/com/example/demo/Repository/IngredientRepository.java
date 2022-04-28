package com.example.demo.Repository;

import com.example.demo.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    @Query("Select i from Ingredient i where i.stock=:stock and i.ingredientName=:ingredientName")
     Ingredient getIngredient(@RequestParam("stock") Integer stock,@RequestParam("ingredientName") String ingredientName);

    @Query("Select i from Ingredient i where i.ingredientName=:ingredientName")
    Ingredient getIngredientByName(@RequestParam("ingredientName") String ingredientName);

    @Query("Select i from Ingredient i inner join IngredientRelatedToBeverages irtb on i.ingredientId=irtb.ingredientId " +
            "where irtb.ingredientRelatedToBeveragesId=:irtbId")
    Ingredient getIngredientById(@RequestParam("irtbId") Integer irtbId);
}
