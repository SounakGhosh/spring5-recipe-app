package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.IngredientCommand;
import sounak.springframework.spring5_recipe_app.commands.UnitOfMeasureCommand;
import sounak.springframework.spring5_recipe_app.model.Ingredient;
import sounak.springframework.spring5_recipe_app.model.Recipe;

import java.math.BigDecimal;

/**
 * Created by sounak on 28-03-2025.
 */
public class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientCommandToIngredient converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void testNullObject() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assertions.assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUnitOfMeasure(unitOfMeasureCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        Assertions.assertNotNull(ingredient);
        Assertions.assertNotNull(ingredient.getUom());
        Assertions.assertEquals(ID_VALUE, ingredient.getId());
        Assertions.assertEquals(AMOUNT, ingredient.getAmount());
        Assertions.assertEquals(DESCRIPTION, ingredient.getDescription());
        Assertions.assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();


        //when
        Ingredient ingredient = converter.convert(command);

        //then
        Assertions.assertNotNull(ingredient);
        Assertions.assertNull(ingredient.getUom());
        Assertions.assertEquals(ID_VALUE, ingredient.getId());
        Assertions.assertEquals(AMOUNT, ingredient.getAmount());
        Assertions.assertEquals(DESCRIPTION, ingredient.getDescription());
    }

}
