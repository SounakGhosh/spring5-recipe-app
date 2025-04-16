package sounak.springframework.spring5_recipe_app.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by sounak on 18-07-2024.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"ingredients"})
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "unitOfMeasure")
    private Set<Ingredient> ingredients;
}
