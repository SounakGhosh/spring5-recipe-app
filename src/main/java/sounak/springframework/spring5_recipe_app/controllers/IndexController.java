package sounak.springframework.spring5_recipe_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sounak.springframework.spring5_recipe_app.model.Category;
import sounak.springframework.spring5_recipe_app.model.UnitOfMeasure;
import sounak.springframework.spring5_recipe_app.repositories.CategoryRepository;
import sounak.springframework.spring5_recipe_app.repositories.UnitOfMeasureRepository;

import java.util.Optional;

/**
 * Created by sounak on 08-07-2024.
 */
@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index/", "/index.html"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        categoryOptional.ifPresent(category -> System.out.println("Category id: " + category.getId()));
        uomOptional.ifPresent(unitOfMeasure -> System.out.println("UnitOfMeasure id: " + uomOptional.get().getId()));

        return "index";
    }
}
