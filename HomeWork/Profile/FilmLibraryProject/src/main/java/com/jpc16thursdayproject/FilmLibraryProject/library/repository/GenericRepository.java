package com.jpc16thursdayproject.FilmLibraryProject.library.repository;

import com.jpc16thursdayproject.FilmLibraryProject.library.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel>
        extends JpaRepository<T, Long> {
}
