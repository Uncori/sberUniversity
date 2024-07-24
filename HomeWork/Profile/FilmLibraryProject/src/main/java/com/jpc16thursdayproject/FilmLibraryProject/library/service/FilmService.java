package com.jpc16thursdayproject.FilmLibraryProject.library.service;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.FilmDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.mapper.FilmMapper;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Director;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Film;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.DirectorRepository;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class FilmService extends GenericService<Film, FilmDTO> {

    private final DirectorRepository directorRepository;

    public FilmService(FilmRepository repository, FilmMapper mapper, DirectorRepository directorRepository) {
        super(repository, mapper);
        this.directorRepository = directorRepository;
    }

    public FilmDTO addDirector(final Long filmId,
                               final Long directorId) {
        FilmDTO film = getOne(filmId);
        Director director = directorRepository.findById(directorId)
                .orElseThrow(() -> new NotFoundException("Режиссер не найден"));
        film.getDirectorIds().add(director.getId());
        update(film);
        return film;
    }

}

