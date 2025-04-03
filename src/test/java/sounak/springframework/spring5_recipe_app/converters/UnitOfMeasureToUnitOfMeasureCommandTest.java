package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.UnitOfMeasureCommand;
import sounak.springframework.spring5_recipe_app.model.UnitOfMeasure;

/**
 * Created by sounak on 28-03-2025.
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() {
        Assertions.assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand uomc = converter.convert(uom);

        //then
        Assertions.assertEquals(LONG_VALUE, uomc.getId());
        Assertions.assertEquals(DESCRIPTION, uomc.getDescription());
    }

}
