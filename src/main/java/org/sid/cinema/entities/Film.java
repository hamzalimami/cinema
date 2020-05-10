package org.sid.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String titre;
    private double duree;
    @Column(length = 32)
    private String realisateur;
    @Column(length = 400)
    private String description;
    private String photo;
    @OneToMany(mappedBy = "film")
    private Collection<ProjectionFilm> projectionFilms;
    @ManyToOne
    private Categorie categorie;

}
