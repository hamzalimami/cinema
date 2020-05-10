package org.sid.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private  String nomClient;
    private double prix;
    @Column(unique = true)
    private  int codepaiement;
    private  boolean reservee;
    @ManyToOne
    private Place place;
    @ManyToOne
    private  ProjectionFilm projectionFilm;
}
