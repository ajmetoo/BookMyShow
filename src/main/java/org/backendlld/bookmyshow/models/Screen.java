package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screens extends BaseModel{
    private String name;
    private int totalSeats;
    private int availableSeats;
    private String status;
    private String profilePic;
}
