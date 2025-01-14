package org.backendlld.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theater extends  BaseModel{
    private String name;
    private String address;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}
