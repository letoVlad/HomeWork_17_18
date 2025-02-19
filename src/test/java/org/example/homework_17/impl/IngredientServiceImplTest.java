package org.example.homework_17.impl;

import io.qameta.allure.*;
import org.example.homework_17.service.entities.IngredientEntity;
import org.example.homework_17.service.impl.IngredientServiceImpl;
import org.example.homework_17.service.repositories.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Epic("Тестирование IngredientService")
@Feature("CRUD операции с ингредиентами")
class IngredientServiceImplTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @Test
    @Story("Добавление ингредиента")
    @Description("Проверяет, что ингредиент добавляется корректно")
    @Severity(SeverityLevel.CRITICAL)
    void addIngredient() {
        String ingredientName = "Salt";
        IngredientEntity ingredient = new IngredientEntity();
        ingredient.setName(ingredientName);

        when(ingredientRepository.saveAndFlush(any(IngredientEntity.class))).thenReturn(ingredient);

        IngredientEntity result = ingredientService.addIngredient(ingredientName);

        assertNotNull(result);
        assertEquals(ingredientName, result.getName());
        verify(ingredientRepository, times(1)).saveAndFlush(any(IngredientEntity.class));
    }

    @Test
    @Story("Получение всех ингредиентов")
    @Description("Проверяет, что список ингредиентов возвращается корректно")
    @Severity(SeverityLevel.NORMAL)
    void getAllIngredients() {
        when(ingredientRepository.findAll()).thenReturn(List.of(new IngredientEntity(), new IngredientEntity()));
        List<IngredientEntity> result = ingredientService.getAllIngredients();
        assertEquals(2, result.size());
        verify(ingredientRepository, times(1)).findAll();
    }

    @ParameterizedTest
    @MethodSource("provideIds")
    @Story("Получение ингредиента по ID")
    @Description("Проверяет, что ингредиент корректно возвращается по ID")
    @Severity(SeverityLevel.CRITICAL)
    void getIngredientById(Integer id) {
        IngredientEntity ingredient = new IngredientEntity();
        ingredient.setId(id);
        when(ingredientRepository.getReferenceById(Long.valueOf(id))).thenReturn(ingredient);

        IngredientEntity result = ingredientService.getIngredientById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(ingredientRepository, times(1)).getReferenceById(Long.valueOf(id));
    }

    @ParameterizedTest
    @MethodSource("provideIds")
    @Story("Удаление ингредиента по ID")
    @Description("Проверяет, что ингредиент корректно удаляется по ID")
    @Severity(SeverityLevel.CRITICAL)
    void deleteIngredientById(long id) {
        doNothing().when(ingredientRepository).deleteById(id);
        String result = ingredientService.deleteIngredientById(id);
        assertEquals(String.valueOf(id), result);
        verify(ingredientRepository, times(1)).deleteById(id);
    }

    static Stream<Integer> provideIds() {
        return Stream.of(1, 2, 3);
    }
}
