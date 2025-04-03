package sounak.springframework.spring5_recipe_app.converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sounak.springframework.spring5_recipe_app.commands.NotesCommand;
import sounak.springframework.spring5_recipe_app.model.Notes;

/**
 * Created by sounak on 28-03-2025.
 */
public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();

    }

    @Test
    public void testNullParameter() {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assertions.assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        Assertions.assertNotNull(notes);
        Assertions.assertEquals(ID_VALUE, notes.getId());
        Assertions.assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }

}
