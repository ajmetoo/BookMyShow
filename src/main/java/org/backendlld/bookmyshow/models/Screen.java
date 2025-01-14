package org.backendlld.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Screen extends BaseModel{
    private String name;
    private int totalSeats;
    private int availableSeats;
    private ScreenStatus status;
    @ManyToOne
    private Theater theater;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Features> features;
}
