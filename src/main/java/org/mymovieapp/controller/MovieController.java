package org.mymovieapp.controller;

import org.mymovieapp.dto.*;
import org.mymovieapp.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public String listMovies(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<MovieDTO> moviePage = service.findAll(search, PageRequest.of(page, size, Sort.by("title")));

        model.addAttribute("movies", moviePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviePage.getTotalPages());
        model.addAttribute("search", search);

        return "movie/list";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("movieForm", new CreateMovieDTO());
        return "movie/form";
    }

    @PostMapping
    public String createMovie(@Valid @ModelAttribute("movieForm") CreateMovieDTO dto,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "movie/form";
        }
        service.create(dto);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        MovieDTO existing = service.findById(id);

        model.addAttribute("movieForm", UpdateMovieDTO.from(existing));
        model.addAttribute("id", id);
        return "movie/edit";
    }

    @PostMapping("/{id}")
    public String updateMovie(@PathVariable Long id,
                              @Valid @ModelAttribute("movieForm") UpdateMovieDTO dto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "movie/edit";
        }
        service.update(id, dto);
        return "redirect:/movies";
    }

    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/movies";
    }

    @GetMapping("/{id}")
    public String showMovieDetails(@PathVariable Long id, Model model) {
        MovieDTO movie = service.findById(id);
        model.addAttribute("movie", movie);
        return "movie/details";
    }
}

