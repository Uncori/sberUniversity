package com.jpc16thursdayproject.FilmLibraryProject.library.repository;

import com.jpc16thursdayproject.FilmLibraryProject.library.model.Director;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface DirectorRepository
        extends GenericRepository<Director> {

    Page<Director> findAllByDirectorsFioContainsIgnoreCaseAndIsDeletedFalse(String fio,
                                                                            Pageable pageable);
}

