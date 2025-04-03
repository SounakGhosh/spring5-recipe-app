package sounak.springframework.spring5_recipe_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Created by sounak on 18-07-2024.
 */
@Data
@EqualsAndHashCode(exclude = {"ingredients"})
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "uom")
    private Set<Ingredient> ingredients;
}
