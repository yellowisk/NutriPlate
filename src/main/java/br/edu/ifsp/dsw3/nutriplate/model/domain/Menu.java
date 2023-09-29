package br.edu.ifsp.dsw3.nutriplate.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "is_usable")
    private boolean isUsable;

    @Column(name = "date_start")
    private String dateStart;

    @Column(name = "date_finish")
    private String dateFinish;

    @ManyToMany
    @JoinTable(name = "food_menu", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> foods;

    public Menu(UUID id, boolean isUsable, String dateStart, String dateFinish, List<Food> foods) {
        this.id = id;
        this.isUsable = isUsable;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.foods = foods;
    }

    public Menu(UUID id, boolean isUsable, String dateStart, String dateFinish) {
        this.id = id;
        this.isUsable = isUsable;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
    }

    public Menu(boolean isUsable, String dateStart, String dateFinish, List<Food> foods) {
        this.isUsable = isUsable;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.foods = foods;
    }

    public Menu() {

    }

    public UUID getId() {
        return id;
    }

    public boolean getIsUsable() {
        return isUsable;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public static Menu createFromMenuRequest(boolean isUsable, ArrayList<Food> foods, String dateStart,
            String dateFinish) {
        return new Menu(isUsable, dateStart, dateFinish, foods);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setIsUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
