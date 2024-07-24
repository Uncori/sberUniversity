package com.jpc16thursdayproject.FilmLibraryProject.library.controller.mvc;

import com.jpc16thursdayproject.FilmLibraryProject.library.service.*;
import com.jpc16thursdayproject.FilmLibraryProject.library.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/films")
public class MVCFilmController {
    private final FilmService filmService;
    private final DirectorService directorService;

    public MVCFilmController(FilmService filmService, DirectorService directorService) {
        this.filmService = filmService;
        this.directorService = directorService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<FilmDTO> films = filmService.listAll();
        model.addAttribute("films", films);
        return "films/viewAllFilms";
    }

    @GetMapping("/add")
    public String create(Model model) {
        List<DirectorDTO> director = directorService.listAll();
        model.addAttribute("director", director);
        return "films/addFilm";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("filmForm") FilmDTO newFilm) {
        log.info(newFilm.toString());
        filmService.create(newFilm);
        return "redirect:/films";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id,
                         Model model) {
        model.addAttribute("film", filmService.getOne(id));
        FilmDTO film = filmService.getOne(id);
        model.addAttribute("director",directorService.getOne(film.getDirectorIds()));
        return "films/viewFilm";
    }

}
