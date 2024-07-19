package sounak.springframework.spring5_recipe_app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sounak.springframework.spring5_recipe_app.model.Difficulty;
import sounak.springframework.spring5_recipe_app.model.Notes;
import sounak.springframework.spring5_recipe_app.model.Recipe;
import sounak.springframework.spring5_recipe_app.repositories.CategoryRepository;
import sounak.springframework.spring5_recipe_app.repositories.RecipeRepository;
import sounak.springframework.spring5_recipe_app.repositories.UnitOfMeasureRepository;

/**
 * Created by sounak on 19-07-2024.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long count = recipeRepository.count();

        if (count == 0) {
            System.out.println("Loading data...");
            loadData();
            System.out.println("Loaded data.");
        }
    }

    private void loadData() {
        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(10);
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setSource("Simply Recipes");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
//        guacamoleRecipe.setDirections("");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);

        /*Map<String, UnitOfMeasure> uomMap = new HashMap<>();
        unitOfMeasureRepository.findAll().forEach(uom -> uomMap.put(uom.getDescription(), uom));

        Ingredient ripeAvocado = new Ingredient();
        ripeAvocado.setDescription("Ripe avocado");
        ripeAvocado.setAmount(BigDecimal.valueOf(2));
//        ripeAvocado.setUom(uomMap.get(""));
        ripeAvocado.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(ripeAvocado);

        Ingredient kosherSalt = new Ingredient();
        kosherSalt.setDescription("Kosher salt");
        kosherSalt.setAmount(BigDecimal.valueOf(0.25));
        kosherSalt.setUom(uomMap.get("Teaspoon"));
        kosherSalt.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(kosherSalt);

        Ingredient freshLemonJuice = new Ingredient();
        freshLemonJuice.setDescription("Fresh lime or lemon juice");
        freshLemonJuice.setAmount(BigDecimal.ONE);
        freshLemonJuice.setUom(uomMap.get("Tablespoon"));
        freshLemonJuice.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(freshLemonJuice);

        Ingredient onion = new Ingredient();
        onion.setDescription("Minced red onion or thinly sliced green onion");
        onion.setAmount(BigDecimal.valueOf(4));
        onion.setUom(uomMap.get("Tablespoon"));
        onion.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(onion);

        Ingredient serranoChilli = new Ingredient();
        serranoChilli.setDescription("Serrano (or jalapeño) chilly, stems and seeds removed, minced");
        serranoChilli.setAmount(BigDecimal.valueOf(2));
//        serranoChilli.setUom(uomMap.get(""));
        serranoChilli.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(serranoChilli);

        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("Cilantro (leaves and tender stems), finely chopped");
        cilantro.setAmount(BigDecimal.valueOf(2));
//        cilantro.setUom(uomMap.get(""));
        cilantro.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(cilantro);

        Ingredient blackPepper = new Ingredient();
        blackPepper.setDescription("Freshly ground black pepper");
        blackPepper.setAmount(BigDecimal.ONE);
        blackPepper.setUom(uomMap.get("Pinch"));
        blackPepper.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(blackPepper);

        Ingredient tomato = new Ingredient();
        tomato.setDescription("Ripe tomato, chopped (optional)");
        tomato.setAmount(BigDecimal.valueOf(0.5));
//        tomato.setUom(uomMap.get(""));
        tomato.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(tomato);

        Ingredient radish = new Ingredient();
        radish.setDescription("Red radish or jicama slices for garnish (optional)");
        radish.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(radish);

        Ingredient tortillaChips = new Ingredient();
        tortillaChips.setDescription("Tortilla chips, to serve");
        tortillaChips.setRecipe(guacamoleRecipe);
        guacamoleRecipe.getIngredients().add(tortillaChips);*/


        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("Be careful handling chillis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.");
        guacamoleNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNotes);

        /*Map<String, Category> categoryMap = new HashMap<>();
        categoryRepository.findAll().forEach(category -> categoryMap.put(category.getDescription(), category));

        Category mexican = categoryMap.get("Mexican");
        mexican.getRecipes().add(guacamoleRecipe);
        guacamoleRecipe.getCategories().add(mexican);

        categoryRepository.save(mexican);*/

        recipeRepository.save(guacamoleRecipe);
    }
}
