package org.backendlld.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketRequestDto {
    private int userId;
    private int showId;
    private List<Integer> showSeatIds;
}
