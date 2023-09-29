package br.edu.ifsp.dsw3.nutriplate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.nutriplate.model.dao.ReservationDAO;
import br.edu.ifsp.dsw3.nutriplate.model.domain.Reservation;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    ReservationDAO dao;

    @GetMapping("/cadastrar")
    public String cadastrar(Reservation reservation) {return "/reservation/cadastro";}

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("reservations", dao.findAll());
        return "/reservation/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Reservation reservation) {
        dao.save(reservation);
        return "redirect:/reservation/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") UUID id) {
        dao.deleteById(id);
        return "redirect:/reservations/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") UUID id, ModelMap map) {
        map.addAttribute("reservation", dao.findById(id).get());
        return "/reservation/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Reservation reservation) {
        dao.save(reservation);
        return "redirect:/reservations/listar";
    }
}
