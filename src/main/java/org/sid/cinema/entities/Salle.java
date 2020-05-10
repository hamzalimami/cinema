package org.sid.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

import java.util.Collection;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Salle  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(length = 32)
    private  String name;
    private int nombrePlaces;
    @ManyToOne
    private Cinema cinema;
    @OneToMany(mappedBy ="salle")
    private Collection<Place> places;
    @OneToMany(mappedBy = "salle")
    private Collection<ProjectionFilm> projectionFilms;


}
