package com.ladutsko.filmslibrary.facade.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmErrorResponse {

    private int status;
    private String message;
    private LocalDateTime dateTime;

}
