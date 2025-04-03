package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.CategoryCommand;
import sounak.springframework.spring5_recipe_app.model.Category;

/**
 * Created by sounak on 28-03-2025.
 */
public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assertions.assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        Assertions.assertEquals(ID_VALUE, category.getId());
        Assertions.assertEquals(DESCRIPTION, category.getDescription());
    }

}
