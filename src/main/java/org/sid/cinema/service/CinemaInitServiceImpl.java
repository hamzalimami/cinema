package org.sid.cinema.service;

import org.sid.cinema.dao.*;
import org.sid.cinema.entities.Cinema;
import org.sid.cinema.entities.Salle;
import org.sid.cinema.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class CinemaInitServiceImpl implements IcinemainitService {
    @Autowired
    VilleRepository villeRepository;
    @Autowired
   CinemaRepository cinemaRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionFilmRepository projectionRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired private TicketRepository ticketRepository;
    @Override
    public void initVilles() {
        Stream.of("Casablanca","Rabat","Marrakech","Tanger").forEach(nameVille->{
            Ville ville=new Ville();
            ville.setName(nameVille);
            villeRepository.save(ville);
        });

    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("MegaRama","Rialto","lynce","IMAX").forEach(nameCinema->{
                Cinema cinema = new Cinema();
                cinema.setName(nameCinema);
                cinema.setNombreSalles(3+(int)(Math.random()*10)+1);
                cinema.setVille(v);
                cinemaRepository.save(cinema);
            });

        });

    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema->{
            for(int i=0;i<cinema.getNombreSalles();i++) {
                Salle salle=new Salle();
                salle.setName("Salle "+(i+1));
                salle.setCinema(cinema);
                salle.setNombrePlaces(15+(int)(Math.random()*20));
                salleRepository.save(salle);
            }});


    }

    @Override
    public void initPlaces() {

    }

    @Override
    public void initSeances() {

    }

    @Override
    public void initCategories() {

    }

    @Override
    public void initFilms() {

    }

    @Override
    public void initProjections() {

    }

    @Override
    public void initTickets() {

    }
}
