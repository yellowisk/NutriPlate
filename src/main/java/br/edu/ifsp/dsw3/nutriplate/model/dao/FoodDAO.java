package br.edu.ifsp.dsw3.nutriplate.model.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.nutriplate.model.domain.Food;

public interface FoodDAO extends JpaRepository<Food, UUID> {

}
