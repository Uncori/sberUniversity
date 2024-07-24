package com.jpc16thursdayproject.FilmLibraryProject.library.repository;

import com.jpc16thursdayproject.FilmLibraryProject.library.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository
        extends GenericRepository<User> {

    User findUserByLogin(String login);

    User findUserByEmail(String email);

    User findUserByChangePasswordToken(String uuid);

}
