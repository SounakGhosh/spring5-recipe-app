package sounak.springframework.spring5_recipe_app.controllers;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sounak.springframework.spring5_recipe_app.commands.IngredientCommand;
import sounak.springframework.spring5_recipe_app.commands.RecipeCommand;
import sounak.springframework.spring5_recipe_app.services.IngredientService;
import sounak.springframework.spring5_recipe_app.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by sounak on 12-04-2025.
 */
public class IngredientControllerTest {

    @Mock
    IngredientService ingredientService;

    @Mock
    RecipeService recipeService;

    IngredientController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            controller = new IngredientController(recipeService, ingredientService);
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void listIngredientsTest() throws Exception {
        //given
        RecipeCommand recipeCommand = new RecipeCommand();
        Mockito.when(recipeService.findCommandById(Mockito.anyLong())).thenReturn(recipeCommand);

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/ingredients"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/ingredient/list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));

        //then
        Mockito.verify(recipeService, Mockito.times(1)).findCommandById(Mockito.anyLong());
    }

    @Test
    public void showIngredientTest() throws Exception {
        //given
        IngredientCommand ingredientCommand = new IngredientCommand();

        //when
        Mockito.when(ingredientService.findByRecipeIdAndIngredientId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(ingredientCommand);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/ingredient/2/show"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/ingredient/show"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("ingredient"));
    }

}
