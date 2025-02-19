//package org.example.homework_17.controllers;
//
//import org.example.homework_17.service.entities.IngredientEntity;
//import org.example.homework_17.service.impl.IngredientServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(IngredientController.class)
//@ExtendWith(MockitoExtension.class)
//class IngredientControllerTest {
//
//    @Mock
//    private IngredientServiceImpl ingredientService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @InjectMocks
//    private IngredientController ingredientController;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @DisplayName("Получить все ингредиенты")
//    @Test
//    void getAllIngredientsShouldReturnIngredientListView() throws Exception {
//        when(ingredientService.getAllIngredients()).thenReturn(List.of(new IngredientEntity(1, "Sugar")));
//
//        mockMvc.perform(get("/ingredient"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("ingredient/list"))
//                .andExpect(model().attributeExists("ingredients"));
//    }
//
//    @DisplayName("Получить ингредиент по ID")
//    @Test
//    void showIngredientShouldReturnIngredientView() throws Exception {
//        when(ingredientService.getIngredientById(1)).thenReturn(new IngredientEntity(1, "Salt"));
//
//        mockMvc.perform(get("/ingredient/1"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("ingredient/show"))
//                .andExpect(model().attributeExists("ingredient"));
//    }
//
//    @DisplayName("Удаление ингредиента по ID")
//    @Test
//    void deleteIngredientShouldRedirectToIngredientList() throws Exception {
//        doNothing().when(ingredientService).deleteIngredientById(1);
//
//        mockMvc.perform(post("/ingredient/delete").flashAttr("ingredient",
//                        new IngredientEntity(1, "Pepper")))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/ingredient"));
//    }
//
//    @DisplayName("Добавить игредиент")
//    @Test
//    void addIngredientShouldRedirectToIngredientList() throws Exception {
//        doNothing().when(ingredientService).addIngredient("Flour");
//
//        mockMvc.perform(post("/ingredient").flashAttr("ingredient",
//                        new IngredientEntity(2,
//                        "Flour")))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/ingredient"));
//    }
//}
