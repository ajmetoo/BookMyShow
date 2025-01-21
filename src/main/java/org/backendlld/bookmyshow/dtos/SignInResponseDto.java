package org.backendlld.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponseDto {
    private int userId;
    private ResponseStatus status;
}
