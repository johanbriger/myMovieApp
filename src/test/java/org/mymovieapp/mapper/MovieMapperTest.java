package org.mymovieapp.mapper;



import org.mymovieapp.entity.Movie;
import org.mymovieapp.dto.CreateMovieDTO;
import org.mymovieapp.dto.MovieDTO;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {

    private final MovieMapper mapper = new MovieMapper();

    @Test
    void shouldMapCreateDTOToEntity() {
        // Arrange
        CreateMovieDTO dto = new CreateMovieDTO();
        dto.setTitle("Inception");
        dto.setDirector("Nolan");
        dto.setReleaseDate(LocalDate.now());
        dto.setDurationMinutes(148);

        // Act
        Movie movie = mapper.toEntity(dto);

        // Assert
        assertEquals(dto.getTitle(), movie.getTitle());
        assertEquals(dto.getDirector(), movie.getDirector());
        assertNull(movie.getId()); // ID ska vara null innan det sparas i DB
    }

    @Test
    void shouldMapEntityToDTO() {
        // Arrange
        Movie movie = new Movie(1L, "The Matrix", "Cool movie", LocalDate.now(), "Wachowski", 136);

        // Act
        MovieDTO dto = mapper.toDTO(movie);

        // Assert
        assertEquals(movie.getId(), dto.getId());
        assertEquals(movie.getTitle(), dto.getTitle());
    }
}