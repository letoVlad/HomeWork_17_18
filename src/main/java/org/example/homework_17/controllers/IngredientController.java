package org.example.homework_17.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.NoArgsConstructor;
import org.example.homework_17.service.entities.IngredientEntity;
import org.example.homework_17.service.impl.IngredientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@NoArgsConstructor
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(summary = "Вывод всех ингредиентов")
    @GetMapping()
    public String getAllIngredients(Model model) {
        List<IngredientEntity> ingredients = ingredientService.getAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "ingredient/list";
    }

    @Operation(summary = "Получить ингредиент по id")
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("ingredient", ingredientService.getIngredientById(id));
        return "ingredient/show";
    }

    @Operation(summary = "Удалить ингредиент по id")
    @GetMapping("/delete")
    public String deleteIngredientForm(Model model) {
        model.addAttribute("ingredient", new IngredientEntity());
        return "ingredient/delete";
    }

    @PostMapping("/delete")
    public String deleteIngredient(@ModelAttribute("ingredient") IngredientEntity ingredient) {
        ingredientService.deleteIngredientById(ingredient.getId());
        return "redirect:/ingredient";
    }

    @Operation(summary = "Создать ингредиент")
    @GetMapping("/new")
    public String newIngredientForm(Model model) {
        model.addAttribute("ingredient", new IngredientEntity());
        return "ingredient/new";
    }

    @PostMapping
    public String addIngredient(@ModelAttribute("ingredient") IngredientEntity ingredient) {
        ingredientService.addIngredient(ingredient.getName());
        return "redirect:/ingredient";
    }
}
