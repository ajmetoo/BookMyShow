package org.backendlld.bookmyshow.services;

import org.backendlld.bookmyshow.dtos.BookingTicketRequestDto;
import org.backendlld.bookmyshow.models.*;
import org.backendlld.bookmyshow.repositories.BookingRepository;
import org.backendlld.bookmyshow.repositories.ShowRepository;
import org.backendlld.bookmyshow.repositories.ShowSeatRepository;
import org.backendlld.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    @Autowired
    private BookingService(BookingRepository bookingRepository, UserRepository userRepository, ShowSeatRepository showSeatRepository, ShowRepository showRepository){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking BookTicket(BookingTicketRequestDto bookingRequestDto){
        Optional<User> optionalUser = userRepository.findById(bookingRequestDto.getUserId());
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow= showRepository.findById(bookingRequestDto.getShowId());
        if (optionalShow.isEmpty()){
            throw new RuntimeException("Show not found");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(bookingRequestDto.getShowSeatIds());
        if (showSeats.size() != bookingRequestDto.getShowSeatIds().size()){
            throw new RuntimeException("Show seat not found");
        }
        for (ShowSeat showSeat : showSeats){
            if (showSeat.getStatus() != SeatState.AVAILABLE){
                throw new RuntimeException("Show seat already booked");
            }
        }

        for (ShowSeat showSeat : showSeats){
            showSeat.setStatus(SeatState.BOOKED);
            showSeat.setBlockedAt(new Date());
        }

        showSeatRepository.saveAll(showSeats);

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeats);
        booking.setBookingTime(new Date());
        booking.setAmount(1000);
        booking.setPayments(new ArrayList<>());
        return bookingRepository.save(booking);
    }

}
