package sounak.springframework.spring5_recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;
import sounak.springframework.spring5_recipe_app.model.UnitOfMeasure;

import java.util.Optional;

/**
 * Created by sounak on 18-07-2024.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
