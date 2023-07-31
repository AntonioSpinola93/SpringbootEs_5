package com.example.demo.service;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.IngredientDto;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;

    }
    public List<IngredientDto> findAll(){
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        List<IngredientDto>ingredientDtoList = new ArrayList<>();
        for(Ingredient ingredient:ingredientList){
            ingredientDtoList.add(new IngredientDto(
                    ingredient.getId(),
                    ingredient.getName(),
                    ingredient.getVegetarian(),
                    ingredient.getVegan(),
                    ingredient.getGlutenFree(),
                    ingredient.getLactoseFree()));
        }
        return ingredientDtoList;
    }
    public IngredientDto addIngredientDto(IngredientDto ingredientDto){
        Ingredient ingredient=new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setVegetarian(ingredientDto.getVegetarian());
        ingredient.setVegan(ingredientDto.getVegan());
        ingredient.setGlutenFree(ingredientDto.getGlutenFree());
        ingredient.setLactoseFree(ingredientDto.getLactoseFree());
        ingredientRepository.save(ingredient);
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setVegetarian(ingredient.getVegetarian());
        ingredientDto.setVegan(ingredient.getVegan());
        ingredientDto.setGlutenFree(ingredient.getGlutenFree());
        ingredientDto.setLactoseFree(ingredient.getLactoseFree());
        return ingredientDto;
    }
    public IngredientDto findById(Long id){
        Optional<Ingredient> optionalIngredient=ingredientRepository.findById(id);
            if(optionalIngredient.isPresent()){
                Ingredient ingredient=optionalIngredient.get();
                IngredientDto ingredientDto= new IngredientDto(ingredient.getId(),
                        ingredient.getName(),
                        ingredient.getVegetarian(),
                        ingredient.getVegan(),
                        ingredient.getGlutenFree(),
                        ingredient.getLactoseFree());
                return ingredientDto;
            }else{
               throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ingrediente non trovato");
            }
        }
    public IngredientDto updateById(Long id,IngredientDto ingredientDto){
        Ingredient ingredient=new Ingredient();
        ingredient.setId(id);
        ingredient.setName(ingredientDto.getName());
        ingredient.setVegetarian(ingredientDto.getVegetarian());
        ingredient.setVegan(ingredientDto.getVegan());
        ingredient.setGlutenFree(ingredientDto.getGlutenFree());
        ingredient.setLactoseFree(ingredientDto.getLactoseFree());
        ingredientRepository.save(ingredient);
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setVegetarian(ingredient.getVegetarian());
        ingredientDto.setVegan(ingredient.getVegan());
        ingredientDto.setGlutenFree(ingredient.getGlutenFree());
        ingredientDto.setLactoseFree(ingredient.getLactoseFree());
        return ingredientDto;
    }
    public ResponseEntity<String> deleteById(Long id){
        Optional<Ingredient>optionalIngredient=ingredientRepository.findById(id);
        if (optionalIngredient.isPresent()){
            ingredientRepository.delete(optionalIngredient.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok("Ingrediente con id:  "+ id + " eliminato") ;

    }

}
