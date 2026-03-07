package org.mymovieapp.repository;

import org.mymovieapp.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
