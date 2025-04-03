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
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();

        uom.setId(source.getId());
        uom.setDescription(source.getDescription());

        return uom;
    }
}