package sounak.springframework.spring5_recipe_app.services;

import org.springframework.stereotype.Service;
import sounak.springframework.spring5_recipe_app.model.Recipe;
import sounak.springframework.spring5_recipe_app.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sounak on 20-07-2024.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
