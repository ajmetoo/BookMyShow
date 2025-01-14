package org.backendlld.bookmyshow.services;

import org.backendlld.bookmyshow.dtos.BookingTicketRequestDto;
import org.backendlld.bookmyshow.dtos.BookingTicketResponseDto;
import org.backendlld.bookmyshow.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;

    }

//    public BookingTicketResponseDto BookTicket(BookingTicketRequestDto bookingRequestDto){
//        //1.validate user
//
//        //2.validate show
//
//        //3.check all showSeats availability
//
//        //4.block showSeats
//
//        //5.insert booking and confirm it
//    }

}
