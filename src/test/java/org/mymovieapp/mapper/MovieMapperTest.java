package org.mymovieapp.mapper;

import org.mymovieapp.dto.UpdateMovieDTO;
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
        assertNull(movie.getId());
    }

    @Test
    void shouldMapEntityToDTO() {

        Movie movie = new Movie(1L, "The Matrix", "Cool movie", LocalDate.now(), "Wachowski", 136);

        MovieDTO dto = mapper.toDTO(movie);

        assertEquals(movie.getId(), dto.getId());
        assertEquals(movie.getTitle(), dto.getTitle());
    }

    @Test
    void shouldUpdateExistingEntityFromUpdateDTO() {
        // Arrange
        Movie existingMovie = new Movie(10L, "Old Title", "Old Desc", LocalDate.now(), "Old Director", 100);
        UpdateMovieDTO updateDto = new UpdateMovieDTO();
        updateDto.setTitle("New Title");
        updateDto.setDirector("New Director");

        // Act
        mapper.updateEntityFromDTO(updateDto, existingMovie);

        // Assert
        assertEquals("New Title", existingMovie.getTitle());
        assertEquals("New Director", existingMovie.getDirector());
        assertEquals(10L, existingMovie.getId()); // ID får absolut inte ändras!
    }
}