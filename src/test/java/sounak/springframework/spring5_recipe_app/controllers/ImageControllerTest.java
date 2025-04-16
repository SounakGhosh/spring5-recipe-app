package sounak.springframework.spring5_recipe_app.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sounak.springframework.spring5_recipe_app.commands.RecipeCommand;
import sounak.springframework.spring5_recipe_app.services.ImageService;
import sounak.springframework.spring5_recipe_app.services.RecipeService;

/**
 * Created by sounak on 16-04-2025.
 */
public class ImageControllerTest {

    @Mock
    ImageService imageService;

    @Mock
    RecipeService recipeService;

    ImageController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            controller = new ImageController(imageService, recipeService);
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void showUploadFormTest() throws Exception {
        //given
        RecipeCommand command = new RecipeCommand();
        command.setId(1L);

        //when
        Mockito.when(recipeService.findCommandById(Mockito.anyLong())).thenReturn(command);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/image"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));

        Mockito.verify(recipeService, Mockito.times(1)).findCommandById(Mockito.anyLong());
    }

    @Test
    public void handleImagePostTest() throws Exception {
        MockMultipartFile multipartFile =
                new MockMultipartFile("imageFile", "testing.txt", "text/plain",
                        "Spring Framework Guru".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/recipe/1/image").file(multipartFile))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.header().string("Location", "/recipe/1/show"));

        Mockito.verify(imageService, Mockito.times(1)).saveImageFile(Mockito.anyLong(), Mockito.any());
    }

    @Test
    public void renderImageFromDB() throws Exception {

        //given
        RecipeCommand command = new RecipeCommand();
        command.setId(1L);

        String s = "fake image text";
        Byte[] bytesBoxed = new Byte[s.getBytes().length];

        int i = 0;

        for (byte primByte : s.getBytes()) {
            bytesBoxed[i++] = primByte;
        }

        command.setImage(bytesBoxed);

        Mockito.when(recipeService.findCommandById(Mockito.anyLong())).thenReturn(command);

        //when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/recipe/1/recipeImage"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();

        byte[] responseBytes = response.getContentAsByteArray();

        Assertions.assertEquals(s.getBytes().length, responseBytes.length);
    }

}
