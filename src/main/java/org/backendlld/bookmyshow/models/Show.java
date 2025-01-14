package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    private Date showTime;
    private int duration;
    @ManyToOne
    private Theater theater;
    @ManyToOne
    private Screen screen;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<SeatType> seatTypes;
}
