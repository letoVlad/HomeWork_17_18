package org.example.homework_17.service.impl;


import org.example.homework_17.service.IngredientService;
import org.example.homework_17.service.entities.IngredientEntity;
import org.example.homework_17.service.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientEntity addIngredient(String ingredientName) {
        IngredientEntity newIngredientEntity = new IngredientEntity();
        newIngredientEntity.setName(ingredientName);
        ingredientRepository.saveAndFlush(newIngredientEntity);
        return newIngredientEntity;
    }

    @Override
    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientEntity getIngredientById(long id) {
        return ingredientRepository.getReferenceById(id);
    }

    @Override
    public String deleteIngredientById(long id) {
        ingredientRepository.deleteById(id);
        return String.valueOf(id);
    }
}
