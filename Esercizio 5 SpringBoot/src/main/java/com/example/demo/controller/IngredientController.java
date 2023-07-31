package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.IngredientDto;
import com.example.demo.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;
    @Autowired
    public IngredientController(IngredientService ingredientService){
        this.ingredientService=ingredientService;
    }
    @GetMapping("/ingredients")
    public List<IngredientDto> findIngredients(){
        return ingredientService.findAll();
    }
    @PostMapping("/add")
    public IngredientDto addIngredient(@RequestBody IngredientDto ingredientDto){
        return ingredientService.addIngredientDto(ingredientDto);
    }
    @GetMapping("/{id}")
    public IngredientDto findById(@PathVariable Long id){
        return ingredientService.findById(id);
    }
    @PutMapping("/{id}")
    public IngredientDto updateById(@PathVariable Long id , @RequestBody IngredientDto ingredientDto){
        return ingredientService.updateById(id,ingredientDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ingredientService.deleteById(id);
    }

}
