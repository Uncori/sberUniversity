package com.jpc16thursdayproject.FilmLibraryProject.library.repository;

import com.jpc16thursdayproject.FilmLibraryProject.library.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface OrderRepository
        extends GenericRepository<Order> {

    Page<Order> getOrderByUserId(Long id, Pageable pageRequest);
}
