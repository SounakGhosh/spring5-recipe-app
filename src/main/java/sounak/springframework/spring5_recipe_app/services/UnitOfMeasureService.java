package sounak.springframework.spring5_recipe_app.services;

import sounak.springframework.spring5_recipe_app.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by sounak on 13-04-2025.
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUnitOfMeasures();

}
