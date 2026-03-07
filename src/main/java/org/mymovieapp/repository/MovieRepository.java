package org.mymovieapp.repository;

import org.mymovieapp.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository ärver från ListCrudRepository och PagingAndSortingRepository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // För sökning/filtrering
    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
