package com.jpc16thursdayproject.FilmLibraryProject.library.mapper;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.OrderDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Order;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.FilmRepository;
import com.jpc16thursdayproject.FilmLibraryProject.library.repository.UserRepository;
import com.jpc16thursdayproject.FilmLibraryProject.library.service.FilmService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;

@Component
public class OrderMapper
        extends GenericMapper<Order, OrderDTO> {

    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    private final FilmService filmService;

    protected OrderMapper(ModelMapper mapper,
                          FilmRepository filmRepository,
                          UserRepository userRepository,
                          FilmService filmService) {
        super(Order.class, OrderDTO.class, mapper);
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
        this.filmService = filmService;
    }

    @PostConstruct
    public void setupMapper() {
        super.modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .addMappings(m -> m.skip(OrderDTO::setUserId))
                .addMappings(m -> m.skip(OrderDTO::setFilmId))
                .addMappings(m -> m.skip(OrderDTO::setFilmDTO))
                .setPostConverter(toDTOConverter());

        super.modelMapper.createTypeMap(OrderDTO.class, Order.class)
                .addMappings(m -> m.skip(Order::setUser))
                .addMappings(m -> m.skip(Order::setFilm))
                .addMappings(m -> m.skip(Order::setFilm))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(OrderDTO source, Order destination) {
        destination.setFilm(filmRepository.findById(source.getFilmId()).orElseThrow(() -> new NotFoundException("Фильм не найден")));
        destination.setUser(userRepository.findById(source.getUserId()).orElseThrow(() -> new NotFoundException("Пользователя не найдено")));
    }

    @Override
    protected void mapSpecificFields(Order source, OrderDTO destination) {
        destination.setUserId(source.getUser().getId());
        destination.setFilmId(source.getFilm().getId());
        destination.setFilmDTO(filmService.getOne(source.getFilm().getId()));
    }

    @Override
    protected List<Long> getIds(Order entity) {
        throw new UnsupportedOperationException("Метод недоступен");
    }
}
