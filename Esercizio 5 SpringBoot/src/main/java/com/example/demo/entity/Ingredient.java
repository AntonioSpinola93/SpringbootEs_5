package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column

    private Boolean isVegetarian;
    @Column

    private Boolean isVegan;
    @Column

    private Boolean isGlutenFree;
    @Column

    private Boolean isLactoseFree;

    public Ingredient(Long id, String name, Boolean isVegetarian, Boolean isVegan, Boolean isGlutenFree, Boolean isLactoseFree) {
        this.id=id;
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isLactoseFree = isLactoseFree;
    }
    public Ingredient(){}

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
