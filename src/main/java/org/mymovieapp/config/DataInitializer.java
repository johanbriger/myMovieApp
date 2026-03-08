package org.mymovieapp.config;

import org.mymovieapp.dto.CreateMovieDTO;
import org.mymovieapp.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final MovieService movieService;

    // Manuell konstruktor för Dependency Injection (istället för @RequiredArgsConstructor)
    public DataInitializer(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Kontrollera om databasen är tom innan vi lägger till dummys
        if (movieService.findAll("", PageRequest.ofSize(10)).getTotalElements() == 0) {

            // Skapa film 1: Inception
            CreateMovieDTO movie1 = new CreateMovieDTO();
            movie1.setTitle("Inception");
            movie1.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology.");
            movie1.setDirector("Christopher Nolan");
            movie1.setReleaseDate(LocalDate.of(2010, 7, 16));
            movie1.setDurationMinutes(148);
            movieService.create(movie1);

            // Skapa film 2: The Matrix
            CreateMovieDTO movie2 = new CreateMovieDTO();
            movie2.setTitle("The Matrix");
            movie2.setDescription("A computer hacker learns from mysterious rebels about the true nature of his reality.");
            movie2.setDirector("Lana Wachowski");
            movie2.setReleaseDate(LocalDate.of(1999, 3, 31));
            movie2.setDurationMinutes(136);
            movieService.create(movie2);

            // Skapa film 3: Interstellar
            CreateMovieDTO movie3 = new CreateMovieDTO();
            movie3.setTitle("Interstellar");
            movie3.setDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
            movie3.setDirector("Christopher Nolan");
            movie3.setReleaseDate(LocalDate.of(2014, 11, 7));
            movie3.setDurationMinutes(169);
            movieService.create(movie3);

            System.out.println(">> Database initialized with sample movies via MovieService");
        }
    }
}
