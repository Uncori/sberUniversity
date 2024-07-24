package com.jpc16thursdayproject.FilmLibraryProject.filmLibrary.controllers.mvc;


import com.jpc16thursdayproject.FilmLibraryProject.library.dto.FilmDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.model.Genre;
import com.jpc16thursdayproject.FilmLibraryProject.library.service.FilmService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@Transactional
@Rollback(value = false)
public class MVCFilmControllerTest
        extends CommonTestMVC {

    @Autowired
    private FilmService filmService;
    private final FilmDTO filmDTO = new FilmDTO("MVC_TestFilmTitle",
            LocalDate.now(),
            "Test Country",
            Genre.DRAMA,
            new ArrayList<>(),
            5);

    @Override
    @Test
    @DisplayName("Просмотр всех фильмов через MVC контроллер")
    @Order(0)
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin")
    protected void listAll() throws Exception {
        log.info("Тест просмотра фильмов MVC начат");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/films")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("films/viewAllFilms"))
                .andExpect(model().attributeExists("films"))
                .andReturn();
    }

    @Override
    @Test
    @Order(1)
    @DisplayName("Создание фильма через MVC контроллер")
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin")
    protected void createObject() throws Exception {
        log.info("Тест по созданию фильма через MVC начат");
        mvc.perform(MockMvcRequestBuilders.post("/films/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .flashAttr("filmForm", filmDTO)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/films"))
                .andExpect(redirectedUrlTemplate("/films"))
                .andExpect(redirectedUrl("/films"));
        log.info("Тест по созданию фильма через MVC закончен");
    }

    @Override
    protected void updateObject() throws Exception {

    }

    @Override
    protected void deleteObject() throws Exception {

    }

}
