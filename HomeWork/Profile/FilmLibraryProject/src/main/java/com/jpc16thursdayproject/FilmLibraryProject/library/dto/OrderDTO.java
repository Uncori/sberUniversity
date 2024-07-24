package com.jpc16thursdayproject.FilmLibraryProject.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderDTO extends GenericDTO {
    private Long filmId;
    private Long userId;
    private LocalDateTime rentDate;
    private Integer rentPeriod;
    private LocalDateTime returnDate;
    private Boolean returned;
    private FilmDTO filmDTO;

}

