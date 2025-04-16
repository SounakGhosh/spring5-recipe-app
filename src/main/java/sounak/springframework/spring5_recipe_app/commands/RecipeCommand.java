package sounak.springframework.spring5_recipe_app.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sounak.springframework.spring5_recipe_app.model.Difficulty;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sounak on 27-03-2025.
 */
@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
}
