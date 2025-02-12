package org.example.homework_17.service;

import org.example.homework_17.service.entities.RecipeEntity;

import java.util.List;

public interface RecipeService {
    void saveRecipe(RecipeEntity recipe);

    List<RecipeEntity> getAllRecipe();

    void deleteRecipeById(Integer recipeId);

    RecipeEntity getRecipeById(int id);
}
