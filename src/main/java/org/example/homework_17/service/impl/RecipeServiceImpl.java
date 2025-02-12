package org.example.homework_17.service.impl;

import org.example.homework_17.service.RecipeService;
import org.example.homework_17.service.entities.RecipeEntity;
import org.example.homework_17.service.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveRecipe(RecipeEntity recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public List<RecipeEntity> getAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteRecipeById(Integer recipeId) {
        recipeRepository.deleteById(recipeId.longValue());
    }

    @Override
    public RecipeEntity getRecipeById(int id) {
        return recipeRepository.getReferenceById((long) id);
    }
}
