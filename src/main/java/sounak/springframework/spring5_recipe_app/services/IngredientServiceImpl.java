package sounak.springframework.spring5_recipe_app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sounak.springframework.spring5_recipe_app.commands.IngredientCommand;
import sounak.springframework.spring5_recipe_app.converters.IngredientToIngredientCommand;
import sounak.springframework.spring5_recipe_app.model.Recipe;
import sounak.springframework.spring5_recipe_app.repositories.RecipeRepository;

import java.util.Optional;

/**
 * Created by sounak on 13-04-2025.
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()){
            //todo impl error handling
            log.error("Recipe id not found: {}", recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();

        if(ingredientCommandOptional.isEmpty()){
            //todo impl error handling
            log.error("Ingredient id not found: {}", ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
