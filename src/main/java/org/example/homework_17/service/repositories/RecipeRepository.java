package org.example.homework_17.service.repositories;

import org.example.homework_17.service.entities.IngredientEntity;
import org.example.homework_17.service.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {


}
