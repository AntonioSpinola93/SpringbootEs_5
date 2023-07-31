package com.example.demo.entity;

public class IngredientDto {
    private Long id;
    private String name;

    private Boolean isVegetarian;

    private Boolean isVegan;

    private Boolean isGlutenFree;

    private Boolean isLactoseFree;

    public IngredientDto(Long id, String name, Boolean isVegetarian, Boolean isVegan, Boolean isGlutenFree, Boolean isLactoseFree) {
        this.id = id;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isLactoseFree = isLactoseFree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public Boolean getGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public Boolean getLactoseFree() {
        return isLactoseFree;
    }

    public void setLactoseFree(Boolean lactoseFree) {
        isLactoseFree = lactoseFree;
    }
}
