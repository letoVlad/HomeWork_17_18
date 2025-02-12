package org.example.homework_17;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HomeWork17Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWork17Application.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(HomeWork17Application.class);
//        RecipeDao recipeDao = context.getBean(RecipeDao.class);
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("1 - Найти рецепт");
//            System.out.println("2 - Добавить рецепт");
//            System.out.println("3 - Удалить рецепт");
//            System.out.print("Выберите действие: ");
//
//            int selection = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (selection) {
//                case 1:
//                    System.out.print("Введите имя блюда: ");
//                    String name = scanner.nextLine();
//                    List<Recipe> recipes = recipeDao.findByName(name);
//                    recipes.forEach(recipe -> System.out.println(recipe.getName()));
//                    break;
//                case 2:
//                    System.out.print("Введите имя блюда: ");
//                    String recipeName = scanner.nextLine();
//                    Recipe recipe = new Recipe();
//                    recipe.setName(recipeName);
//                    recipeDao.addRecipe(recipe);
//                    break;
//                case 3:
//                    System.out.print("Введите ID рецепта для удаления: ");
//                    Long id = scanner.nextLong();
//                    recipeDao.deleteRecipe(id);
//                    break;
//                default:
//                    System.out.println("Неверный выбор");
//            }
//        }
    }
}

