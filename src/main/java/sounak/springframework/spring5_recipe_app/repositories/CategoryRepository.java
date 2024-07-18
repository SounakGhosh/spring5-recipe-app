package sounak.springframework.spring5_recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;
import sounak.springframework.spring5_recipe_app.model.Category;

/**
 * Created by sounak on 18-07-2024.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
