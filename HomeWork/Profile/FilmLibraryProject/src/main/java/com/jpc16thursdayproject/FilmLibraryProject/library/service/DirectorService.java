package com.jpc16thursdayproject.FilmLibraryProject.library.service;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.DirectorDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.exception.DeleteException;
import com.jpc16thursdayproject.FilmLibraryProject.library.mapper.DirectorMapper;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Director;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Film;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.DirectorRepository;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService extends GenericService<Director, DirectorDTO> {

    private final FilmRepository filmRepository;


    public DirectorService(DirectorRepository repository,
                           DirectorMapper directorMapper,
                           FilmRepository filmRepository) {
        super(repository, directorMapper);
        this.filmRepository = filmRepository;
    }


    public List<DirectorDTO> getOne(final List<Long> idList) {
        List<DirectorDTO> resultList = new ArrayList<>();
        for (Long aLong : idList) {
            resultList.add(mapper.toDTO(repository.findById(aLong)
                    .orElseThrow(() -> new NotFoundException("Данных по id: " + aLong + " не найдено"))));
        }
        return resultList;
    }

    public DirectorDTO addFilm(Long filmId, Long directorId) {

        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new NotFoundException("Фильм не найден"));

        DirectorDTO director = getOne(directorId);
        director.getFilmIds().add(film.getId());
        update(director);
        return director;
    }

    public void deleteSoft(final Long id) throws DeleteException {
        Director directorToDelete = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Объект не найден"));
        directorToDelete.setDeleted(true);
        repository.save(directorToDelete);
    }

    public Page<DirectorDTO> searchDirectors(final String fio,
                                             Pageable pageable) {
        Page<Director> directors = ((DirectorRepository) repository)
                .findAllByDirectorsFioContainsIgnoreCaseAndIsDeletedFalse(fio, pageable);
        List<DirectorDTO> result = mapper.toDTOs(directors.getContent());
        return new PageImpl<>(result, pageable, directors.getTotalElements());
    }

}

