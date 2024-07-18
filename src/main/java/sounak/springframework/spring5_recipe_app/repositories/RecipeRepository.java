package sounak.springframework.spring5_recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;
import sounak.springframework.spring5_recipe_app.model.Recipe;

/**
 * Created by sounak on 18-07-2024.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
