package br.edu.ifsp.dsw3.nutriplate.model.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "portion", nullable = false)
    private int portion;

    @Enumerated(EnumType.STRING)
    @Column(name = "nutritional_group", nullable = false)
    private NutritionalGroup nutritionalGroup;

    @ManyToMany(mappedBy = "foods")
    private List<Menu> menus;

    public Food(UUID id, String name, int portion, NutritionalGroup nutritionalGroup, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.portion = portion;
        this.nutritionalGroup = nutritionalGroup;
        this.menus = menus;
    }

    public Food(UUID id, String name, int portion, NutritionalGroup nutritionalGroup) {
        this.id = id;
        this.name = name;
        this.portion = portion;
        this.nutritionalGroup = nutritionalGroup;
    }

    public Food(String name, int portion, NutritionalGroup nutritionalGroup) {
        this.name = name;
        this.portion = portion;
        this.nutritionalGroup = nutritionalGroup;
    }

    public Food() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public NutritionalGroup getNutritionalGroup() {
        return nutritionalGroup;
    }

    public void setNutritionalGroup(NutritionalGroup nutritionalGroup) {
        this.nutritionalGroup = nutritionalGroup;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Food createFromFoodRequest(NutritionalGroup group, String name, int portion) {
        return new Food(name, portion, group);
    }
}
