package org.mymovieapp.mapper;

import org.mymovieapp.entity.Movie;
import org.mymovieapp.dto.*;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie entity) {
        if (entity == null) return null;
        return new MovieDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getReleaseDate(),
                entity.getDirector(),
                entity.getDurationMinutes()
        );
    }

    public Movie toEntity(CreateMovieDTO dto) {
        if (dto == null) return null;
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setReleaseDate(dto.getReleaseDate());
        movie.setDirector(dto.getDirector());
        movie.setDurationMinutes(dto.getDurationMinutes());
        return movie;
    }

    public void updateEntityFromDTO(UpdateMovieDTO dto, Movie entity) {
        if (dto == null || entity == null) return;
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setDirector(dto.getDirector());
        entity.setDurationMinutes(dto.getDurationMinutes());
    }

}

