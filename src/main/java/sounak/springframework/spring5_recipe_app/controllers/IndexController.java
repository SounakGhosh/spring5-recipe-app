package sounak.springframework.spring5_recipe_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sounak on 08-07-2024.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index", "/index/", "/index.html"})
    public String getIndexPage() {
        return "index";
    }
}
