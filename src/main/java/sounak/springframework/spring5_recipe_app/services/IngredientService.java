package sounak.springframework.spring5_recipe_app.services;

import sounak.springframework.spring5_recipe_app.commands.IngredientCommand;

/**
 * Created by sounak on 13-04-2025.
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);
}
