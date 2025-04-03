package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.CategoryCommand;
import sounak.springframework.spring5_recipe_app.model.Category;

/**
 * Created by sounak on 28-03-2025.
 */
public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryToCategoryCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assertions.assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = converter.convert(category);

        //then
        Assertions.assertEquals(ID_VALUE, categoryCommand.getId());
        Assertions.assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }

}
