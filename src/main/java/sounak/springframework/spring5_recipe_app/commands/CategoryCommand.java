package sounak.springframework.spring5_recipe_app.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sounak on 27-03-2025.
 */
@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    Long id;
    String description;
}
