package com.jpc16thursdayproject.FilmLibraryProject.library.repository;

import com.jpc16thursdayproject.FilmLibraryProject.library.model.Film;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository
        extends GenericRepository<Film> {
}

