package com.jpc16thursdayproject.FilmLibraryProject.library.dto;


import com.jpc16thursdayproject.FilmLibraryProject.library.model.Genre;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class FilmDTO extends GenericDTO {
    private String filmTitle;
    private LocalDate premierYear;
    private String country;
    private Genre genre;
    private List<Long> directorIds;
    private Integer amount;
}
