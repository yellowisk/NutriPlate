package br.edu.ifsp.dsw3.nutriplate.model.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.dsw3.nutriplate.model.domain.Menu;

public interface MenuDAO extends JpaRepository<Menu, UUID> {

}
