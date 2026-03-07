package org.mymovieapp.service;


import org.mymovieapp.domain.Movie;
import org.mymovieapp.exception.ResourceNotFoundException;
import org.mymovieapp.mapper.MovieMapper;
import org.mymovieapp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    @Spy // Vi använder en riktig mapper men injicerar den i servicen
    private MovieMapper mapper;

    @InjectMocks
    private MovieService service;

    @Test
    void findById_ShouldReturnMovie_WhenMovieExists() {
        // Arrange
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Test Movie");
        when(repository.findById(1L)).thenReturn(Optional.of(movie));

        // Act
        var result = service.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Test Movie", result.getTitle());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void findById_ShouldThrowException_WhenMovieDoesNotExist() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }
}