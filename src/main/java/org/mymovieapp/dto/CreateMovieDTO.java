package org.mymovieapp.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class CreateMovieDTO {
    @NotBlank(message = "Titeln är obligatorisk")
    private String title;

    private String description;

    @NotNull(message = "Datum saknas")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotBlank(message = "Regissör saknas")
    private String director;

    @NotNull(message = "Längd saknas")
    @Min(1)
    private Integer durationMinutes;

    public CreateMovieDTO() {
    }

    public CreateMovieDTO(String title, String description, LocalDate releaseDate, String director, Integer durationMinutes) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.director = director;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

}


