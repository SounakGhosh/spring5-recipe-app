package sounak.springframework.spring5_recipe_app.converters;

import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sounak.springframework.spring5_recipe_app.commands.NotesCommand;
import sounak.springframework.spring5_recipe_app.model.Notes;

/**
 * Created by sounak on 27-03-2025.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();

        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());

        return notesCommand;
    }
}