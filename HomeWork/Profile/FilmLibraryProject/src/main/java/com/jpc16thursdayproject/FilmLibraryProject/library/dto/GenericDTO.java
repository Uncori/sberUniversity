package com.jpc16thursdayproject.FilmLibraryProject.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class GenericDTO {
    private Long id;
    private LocalDateTime createdWhen;
    private String createdBy;
    private LocalDateTime deletedWhen;
    private String deletedBy;
    private boolean isDeleted;
}
