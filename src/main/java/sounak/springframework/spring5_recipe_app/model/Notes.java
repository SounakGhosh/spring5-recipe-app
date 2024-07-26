package sounak.springframework.spring5_recipe_app.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Created by sounak on 18-07-2024.
 */
@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
