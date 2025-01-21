package org.backendlld.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class SignUpResponseDto {
    private int userId;
    private ResponseStatus status;
}
