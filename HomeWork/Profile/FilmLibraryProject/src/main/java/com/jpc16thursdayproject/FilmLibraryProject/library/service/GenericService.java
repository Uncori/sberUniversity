package com.jpc16thursdayproject.FilmLibraryProject.library.service;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.GenericDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.mapper.GenericMapper;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.GenericModel;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public abstract class GenericService<E extends GenericModel, D extends GenericDTO> {

    protected final GenericRepository<E> repository;
    protected final GenericMapper<E, D> mapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericService(GenericRepository<E> repository, GenericMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<D> listAll() {
        return mapper.toDTOs(repository.findAll());
    }

    public D getOne(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Данных по заданному id: " + id + " не найдено!")));
    }

    public D create(D newObject) {
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }

    public D update(D updateObject) {
        return mapper.toDTO(repository.save(mapper.toEntity(updateObject)));
    }

    public void delete(final Long id) {
        repository.deleteById(id);
    }
}
