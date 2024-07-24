package com.jpc16thursdayproject.FilmLibraryProject.library.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DirectorDTO extends GenericDTO {
    private String directorsFio;
    private String position;
    private List<Long> filmIds;
    private boolean isDeleted;

    public DirectorDTO(String directorsFio, String position, List<Long> filmIds) {
        this.directorsFio = directorsFio;
        this.position = position;
        this.filmIds = filmIds;
        this.isDeleted = false;
    }

}
