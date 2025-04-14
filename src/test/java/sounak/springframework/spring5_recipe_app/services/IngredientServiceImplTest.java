package sounak.springframework.spring5_recipe_app.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sounak.springframework.spring5_recipe_app.commands.IngredientCommand;
import sounak.springframework.spring5_recipe_app.converters.IngredientCommandToIngredient;
import sounak.springframework.spring5_recipe_app.converters.IngredientToIngredientCommand;
import sounak.springframework.spring5_recipe_app.converters.UnitOfMeasureCommandToUnitOfMeasure;
import sounak.springframework.spring5_recipe_app.converters.UnitOfMeasureToUnitOfMeasureCommand;
import sounak.springframework.spring5_recipe_app.model.Ingredient;
import sounak.springframework.spring5_recipe_app.model.Recipe;
import sounak.springframework.spring5_recipe_app.repositories.RecipeRepository;
import sounak.springframework.spring5_recipe_app.repositories.UnitOfMeasureRepository;

import java.util.Optional;

/**
 * Created by sounak on 13-04-2025.
 */
class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    IngredientService ingredientService;

    //init converters
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(
                new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(
                new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this);) {
            ingredientService = new IngredientServiceImpl(
                    recipeRepository, unitOfMeasureRepository,
                    ingredientToIngredientCommand, ingredientCommandToIngredient
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void findByRecipeIdAndIngredientIdTest() {
    }

    @Test
    public void findByRecipeIdAndIngredientIdHappyPathTest() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        Assertions.assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        Assertions.assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        Mockito.verify(recipeRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    public void saveIngredientCommandTest() {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);
        Mockito.when(recipeRepository.save(Mockito.any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        Assertions.assertEquals(Long.valueOf(3L), savedCommand.getId());
        Mockito.verify(recipeRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(recipeRepository, Mockito.times(1)).save(Mockito.any(Recipe.class));
    }
}