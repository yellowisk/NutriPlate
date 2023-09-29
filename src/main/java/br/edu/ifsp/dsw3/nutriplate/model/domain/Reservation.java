package br.edu.ifsp.dsw3.nutriplate.model.domain;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "reservation_status_id")
    private ReservationStatus reservationStatus;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "reservation_date")
    private Timestamp reservationDate;

    public Reservation(UUID id, User user, Menu menu, ReservationStatus reservationStatus, Timestamp creationDate,
            Timestamp reservationDate) {
        this.id = id;
        this.user = user;
        this.menu = menu;
        this.reservationStatus = reservationStatus;
        this.creationDate = creationDate;
        this.reservationDate = reservationDate;
    }

    public Reservation(User user, Menu menu) {
        this.user = user;
        this.menu = menu;
    }

    public static Reservation createFromUserAndMenu(User user, Menu menu) {
        return new Reservation(user, menu);
    }

    public Reservation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }
}