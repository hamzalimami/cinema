package org.sid.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  long id;
    @Column(length = 32)
    private String name;
    private  double longitude;
    private double latitude;
    private double altitude;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;
}
