package com.jpc16thursdayproject.FilmLibraryProject.library.mapper;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.DirectorDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Director;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.GenericModel;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.FilmRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DirectorMapper
        extends GenericMapper<Director, DirectorDTO> {

    private final FilmRepository filmRepository;

    public DirectorMapper(ModelMapper modelMapper,
                          FilmRepository filmRepository) {
        super(Director.class, DirectorDTO.class, modelMapper);
        this.filmRepository = filmRepository;
    }

    @Override
    protected void mapSpecificFields(DirectorDTO source, Director destination) {
        if (!Objects.isNull(source.getFilmIds())) {
            destination.setFilms(filmRepository.findAllById(source.getFilmIds()));
        } else {
            destination.setFilms(Collections.emptyList());
        }
    }

    @Override
    protected void mapSpecificFields(Director source, DirectorDTO destination) {
        destination.setFilmIds(getIds(source));
    }

    @Override
    @PostConstruct
    protected void setupMapper() {
        modelMapper.createTypeMap(Director.class, DirectorDTO.class)
                .addMappings(mapping -> mapping.skip(DirectorDTO::setFilmIds))
                .setPostConverter(toDTOConverter());

        modelMapper.createTypeMap(DirectorDTO.class, Director.class)
                .addMappings(mapping -> mapping.skip(Director::setFilms))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected List<Long> getIds(Director source) {
        return Objects.isNull(source) || Objects.isNull(source.getFilms())
                ? Collections.emptyList()
                : source.getFilms().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }

}

