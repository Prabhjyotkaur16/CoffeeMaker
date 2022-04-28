package com.example.demo.Repository;

import com.example.demo.Entity.IngredientRelatedToBeverages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IngredientRelatedToBeveragesRepository extends JpaRepository<IngredientRelatedToBeverages,Integer> {

    @Query("Select irtb from IngredientRelatedToBeverages irtb inner join Beverages b on irtb.beverageId=b.beverageId " +
            "where b.beverageName=:beverageName")
    List<IngredientRelatedToBeverages> getRelationByBeverageName(@RequestParam("beverageName") String beverageName);


}
