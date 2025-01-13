package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeats extends BaseModel{
    @ManyToMany
    private Show show;
}
