package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.UnitOfMeasureCommand;
import sounak.springframework.spring5_recipe_app.model.UnitOfMeasure;

/**
 * Created by sounak on 28-03-2025.
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assertions.assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        Assertions.assertNotNull(uom);
        Assertions.assertEquals(LONG_VALUE, uom.getId());
        Assertions.assertEquals(DESCRIPTION, uom.getDescription());
    }

}
