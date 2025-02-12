package org.example.homework_17.controllers;


import org.example.homework_17.dto.RecipeFormDTO;
import org.example.homework_17.service.IngredientService;
import org.example.homework_17.service.RecipeService;
import org.example.homework_17.service.entities.IngredientEntity;
import org.example.homework_17.service.entities.RecipeEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;
    private IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/delete")
    public String deleteRecipe(@RequestParam("recipeId") Integer recipeId) {
        recipeService.deleteRecipeById(recipeId);
        return "redirect:/recipe";
    }

    @GetMapping("/edit")
    public String editRecipeForm(@RequestParam("recipeId") Integer recipeId, Model model) {
        RecipeEntity recipe = recipeService.getRecipeById(recipeId);
        List<IngredientEntity> allIngredients = ingredientService.getAllIngredients();

        model.addAttribute("recipe", recipe);
        model.addAttribute("allIngredients", allIngredients);

        return "recipe/edit_recipe";
    }

    @PostMapping("/update")
    public String updateRecipe(@RequestParam("id") Integer recipeId,
                               @RequestParam("name") String name,
                               @RequestParam(value = "selectedIngredientIds", required = false) List<Integer> ingredientIds) {

        RecipeEntity recipe = recipeService.getRecipeById(recipeId);

        recipe.setName(name);

        List<IngredientEntity> selectedIngredients = new ArrayList<>();
        if (ingredientIds != null) {
            for (Integer ingredientId : ingredientIds) {
                selectedIngredients.add(ingredientService.getIngredientById(ingredientId));
            }
        }

        recipe.setIngredients(selectedIngredients);
        recipeService.saveRecipe(recipe);

        return "redirect:/recipe";
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        List<RecipeEntity> recipes = recipeService.getAllRecipe();
        model.addAttribute("recipes", recipes);
        return "recipe/all";
    }

    @GetMapping("/new")
    public String newRecipeForm(Model model) {
        RecipeFormDTO recipeForm = new RecipeFormDTO();
        model.addAttribute("recipeForm", recipeForm);

        List<IngredientEntity> allIngredients = ingredientService.getAllIngredients();
        model.addAttribute("allIngredients", allIngredients);

        return "recipe/new";
    }

    @PostMapping("/new")
    public String createRecipe(@ModelAttribute("recipeForm") RecipeFormDTO recipeForm) {
        RecipeEntity recipe = new RecipeEntity();
        recipe.setName(recipeForm.getName());

        if (recipeForm.getSelectedIngredientIds() != null) {
            for (Integer ingredientId : recipeForm.getSelectedIngredientIds()) {
                IngredientEntity ingredient = ingredientService.getIngredientById(ingredientId);
                if (ingredient != null) {
                    recipe.getIngredients().add(ingredient);
                    ingredient.getRecipes().add(recipe);
                }
            }
        }
        recipeService.saveRecipe(recipe);

        return "redirect:/recipe";
    }

}