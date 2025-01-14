package org.backendlld.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String description;
    private String genre;
    private Double rating;
    @OneToMany
    private List<Language> language;
    @OneToMany
    private List<Actor> actors;
    @ElementCollection
    private List<Features> movieFeatures;
}
