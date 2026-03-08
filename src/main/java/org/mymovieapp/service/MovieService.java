package org.mymovieapp.service;


import org.mymovieapp.entity.Movie;
import org.mymovieapp.dto.*;
import org.mymovieapp.mapper.MovieMapper;
import org.mymovieapp.repository.MovieRepository;
import org.mymovieapp.exception.ResourceNotFoundException; // Egen exception
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final MovieRepository repository;
    private final MovieMapper mapper;

    public MovieService(MovieRepository repository, MovieMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<MovieDTO> findAll(String search, Pageable pageable) {
        Page<Movie> entities;
        if (search != null && !search.isBlank()) {
            entities = repository.findByTitleContainingIgnoreCase(search, pageable);
        } else {
            entities = repository.findAll(pageable);
        }
        return entities.map(mapper::toDTO);
    }

    public MovieDTO findById(Long id) {
        Movie entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Film med id " + id + " hittades inte"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public void create(CreateMovieDTO dto) {
        Movie entity = mapper.toEntity(dto);
        repository.save(entity);
    }

    @Transactional
    public void update(Long id, UpdateMovieDTO dto) {
        Movie entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kunde inte uppdatera, id saknas"));
        mapper.updateEntityFromDTO(dto, entity);
        repository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Kan inte ta bort, id saknas");
        }
        repository.deleteById(id);
    }

}


