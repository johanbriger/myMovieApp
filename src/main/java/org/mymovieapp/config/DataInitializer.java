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

    public DataInitializer(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (movieService.findAll("", PageRequest.ofSize(10)).getTotalElements() == 0) {


            CreateMovieDTO movie1 = new CreateMovieDTO();
            movie1.setTitle("Inception");
            movie1.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology.");
            movie1.setDirector("Christopher Nolan");
            movie1.setReleaseDate(LocalDate.of(2010, 7, 16));
            movie1.setDurationMinutes(148);
            movieService.create(movie1);


            CreateMovieDTO movie2 = new CreateMovieDTO();
            movie2.setTitle("The Matrix");
            movie2.setDescription("A computer hacker learns from mysterious rebels about the true nature of his reality.");
            movie2.setDirector("Lana Wachowski");
            movie2.setReleaseDate(LocalDate.of(1999, 3, 31));
            movie2.setDurationMinutes(136);
            movieService.create(movie2);


            CreateMovieDTO movie3 = new CreateMovieDTO();
            movie3.setTitle("Interstellar");
            movie3.setDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
            movie3.setDirector("Christopher Nolan");
            movie3.setReleaseDate(LocalDate.of(2014, 11, 7));
            movie3.setDurationMinutes(169);
            movieService.create(movie3);


            CreateMovieDTO movie4 = new CreateMovieDTO();
            movie4.setTitle("The Godfather");
            movie4.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
            movie4.setDirector("Francis Ford Coppola");
            movie4.setReleaseDate(LocalDate.of(1972, 3, 24));
            movie4.setDurationMinutes(175);
            movieService.create(movie4);

            CreateMovieDTO movie5 = new CreateMovieDTO();
            movie5.setTitle("Pulp Fiction");
            movie5.setDescription("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
            movie5.setDirector("Quentin Tarantino");
            movie5.setReleaseDate(LocalDate.of(1994, 10, 14));
            movie5.setDurationMinutes(154);
            movieService.create(movie5);

            CreateMovieDTO movie6 = new CreateMovieDTO();
            movie6.setTitle("The Shawshank Redemption");
            movie6.setDescription("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
            movie6.setDirector("Frank Darabont");
            movie6.setReleaseDate(LocalDate.of(1994, 9, 22));
            movie6.setDurationMinutes(142);
            movieService.create(movie6);

            System.out.println(">> Database initialized with sample movies via MovieService");
        }
    }
}
