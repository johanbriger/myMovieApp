package org.mymovieapp.controller;


import org.mymovieapp.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService service;

    @Test
    void listMovies_ShouldReturnListView() throws Exception {

        when(service.findAll(any(), any())).thenReturn(Page.empty());

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk()) // Verifiera HTTP 200
                .andExpect(view().name("movie/list")) // Verifiera att rätt HTML-vy returneras
                .andExpect(model().attributeExists("movies")) // Verifiera att "movies" finns i modellen
                .andExpect(model().attributeExists("currentPage"));
    }

    @Test
    void showCreateForm_ShouldReturnFormView() throws Exception {
        mockMvc.perform(get("/movies/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("movie/form"))
                .andExpect(model().attributeExists("movieForm"));
    }
}