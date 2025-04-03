package sounak.springframework.spring5_recipe_app.converters;

import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sounak.springframework.spring5_recipe_app.commands.UnitOfMeasureCommand;
import sounak.springframework.spring5_recipe_app.model.UnitOfMeasure;

/**
 * Created by sounak on 27-03-2025.
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();

        uomc.setId(source.getId());
        uomc.setDescription(source.getDescription());

        return uomc;
    }
}