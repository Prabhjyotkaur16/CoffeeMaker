package com.example.demo.Repository;

import com.example.demo.Entity.Beverages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BeveragesRepository extends JpaRepository<Beverages,Integer>{
  //input beverages Save walla option
    @Query("Select b from Beverages b where b.beverageName=:beverageName")
    Beverages getBeverageByName(@RequestParam("beverageName") String beverageName);

    @Query("Select b from Beverages b")
    List<Beverages> getAllBeverages();


}
