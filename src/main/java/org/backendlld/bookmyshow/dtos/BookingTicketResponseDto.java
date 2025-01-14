package org.backendlld.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingTicketResponseDto {
    private int BookingId;
    private double totalAmount;
    private ResponseStatus status;
}
