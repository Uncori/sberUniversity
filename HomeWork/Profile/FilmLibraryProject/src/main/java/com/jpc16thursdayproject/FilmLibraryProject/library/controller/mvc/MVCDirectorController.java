package com.jpc16thursdayproject.FilmLibraryProject.library.controller.mvc;

import com.jpc16thursdayproject.FilmLibraryProject.library.dto.DirectorDTO;
import com.jpc16thursdayproject.FilmLibraryProject.library.exception.DeleteException;
import com.jpc16thursdayproject.FilmLibraryProject.library.service.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.List;

@Slf4j
@Controller
@RequestMapping("/director")
public class MVCDirectorController {

    private final DirectorService directorService;

    public MVCDirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<DirectorDTO> director = directorService.listAll();
        model.addAttribute("director", director);
        return "director/viewAllDirectors";
    }

    @GetMapping("/add")
    public String create() {
        return "director/addDirector";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("directorForm") DirectorDTO newDirector) {
        log.info(newDirector.toString());
        directorService.create(newDirector);
        return "redirect:/director";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         Model model) {
        model.addAttribute("director", directorService.getOne(id));
        return "director/updateDirector";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("directorForm") DirectorDTO directorDTO) {
        directorService.update(directorDTO);
        return "redirect:/director";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) throws DeleteException {
        directorService.deleteSoft(id);
        return "redirect:/director";
    }

    @PostMapping("/search")
    public String searchAuthors(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "5") int pageSize,
                                @ModelAttribute("directorSearchForm") DirectorDTO directorDTO,
                                Model model) {
        if (StringUtils.hasText(directorDTO.getDirectorsFio()) || StringUtils.hasLength(directorDTO.getDirectorsFio())) {
            PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(Sort.Direction.ASC, "DirectorFio"));
            model.addAttribute("authors", directorService.searchDirectors(directorDTO.getDirectorsFio().trim(), pageRequest));
            return "director/viewAllDirectors";
        } else {
            return "redirect:/director";
        }
    }

}
