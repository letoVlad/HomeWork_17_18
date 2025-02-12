package org.example.homework_17.service;

import org.example.homework_17.service.entities.IngredientEntity;

import java.util.List;

public interface IngredientService {
    IngredientEntity addIngredient(String ingredientName);

    List<IngredientEntity> getAllIngredients();

    IngredientEntity getIngredientById(long id);

    String deleteIngredientById(long id);

}
