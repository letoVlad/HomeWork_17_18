package org.example.homework_17.dto;

import java.util.List;

public class RecipeFormDTO {
    private String name;
    private List<Integer> selectedIngredientIds;

    public RecipeFormDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getSelectedIngredientIds() {
        return selectedIngredientIds;
    }

    public void setSelectedIngredientIds(List<Integer> selectedIngredientIds) {
        this.selectedIngredientIds = selectedIngredientIds;
    }
}


