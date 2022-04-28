package com.example.demo.Controller;
import com.example.demo.DTO.BeverageInput;
import com.example.demo.Entity.Beverages;
import com.example.demo.Entity.Ingredient;
import com.example.demo.Service.BaristaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BaristaController {
    @Autowired
    private BaristaServiceImpl baristaServiceImpl;

    @RequestMapping(value="/addIngredient",method=RequestMethod.POST)
    public Object addIngredient(@RequestBody Ingredient ingredient){
        return baristaServiceImpl.addIngredient(ingredient.getIngredientName(),ingredient.getStock());
    }

    @RequestMapping(value="/addBeverageWithIngredient",method=RequestMethod.POST)
    public Object addBeverageWithIngredient(@RequestBody BeverageInput beverageInput){
        return baristaServiceImpl.addBeverageWithIngredient(beverageInput);
    }

    @RequestMapping(value="/getAllBeverages",method=RequestMethod.GET)
    public List<Beverages> getAllBeverages(){
        return baristaServiceImpl.getAllBeverages();
    }

    @RequestMapping(value="/updateStock",method=RequestMethod.POST)
    public Object updateStock(@RequestBody Ingredient ingredient){
      return   baristaServiceImpl.updateStock(ingredient);
    }

    @RequestMapping(value="/getBeverage",method=RequestMethod.GET)
    public String getBeverage(@RequestParam(value = "beverageName") String beverageName){
        return baristaServiceImpl.getBeverage(beverageName);
    }


}
