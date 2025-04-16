package sounak.springframework.spring5_recipe_app.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by sounak on 16-04-2025.
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);

}
