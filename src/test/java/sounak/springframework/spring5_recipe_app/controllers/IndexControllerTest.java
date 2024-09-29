package sounak.springframework.spring5_recipe_app.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import sounak.springframework.spring5_recipe_app.services.RecipeService;

/**
 * Created by sounak on 29-09-2024.
 */
class IndexControllerTest {

    IndexController controller;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            controller = new IndexController(recipeService);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getIndexPage() {
        String indexPage = controller.getIndexPage(model);
        Assertions.assertEquals("index", indexPage);

        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1))
                .addAttribute(Mockito.eq("recipes"), Mockito.anySet());
    }
}