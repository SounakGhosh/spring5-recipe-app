package sounak.springframework.spring5_recipe_app.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import sounak.springframework.spring5_recipe_app.commands.RecipeCommand;
import sounak.springframework.spring5_recipe_app.converters.RecipeCommandToRecipe;
import sounak.springframework.spring5_recipe_app.converters.RecipeToRecipeCommand;
import sounak.springframework.spring5_recipe_app.model.Recipe;
import sounak.springframework.spring5_recipe_app.repositories.RecipeRepository;

/**
 * Created by sounak on 31-03-2025.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        //when
        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        //then
        Assertions.assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        Assertions.assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
        Assertions.assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
        Assertions.assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
    }
}