package sounak.springframework.spring5_recipe_app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sounak.springframework.spring5_recipe_app.services.RecipeService;

/**
 * Created by sounak on 08-07-2024.
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index/", "/index.html", "/recipes", "/recipes/", "/recipes.html"})
    public String getIndexPage(Model model) {
        log.info("Getting index page in controller");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
