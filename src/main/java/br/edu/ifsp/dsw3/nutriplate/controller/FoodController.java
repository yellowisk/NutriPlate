package br.edu.ifsp.dsw3.nutriplate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.nutriplate.model.dao.FoodDAO;
import br.edu.ifsp.dsw3.nutriplate.model.domain.Food;

@Controller
@RequestMapping("/foods")
public class FoodController {
    @Autowired
    FoodDAO dao;

    @GetMapping("/cadastrar")
    public String cadastrar(Food food) {
        return "/foods/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("foods", dao.findAll());
        return "/foods/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Food food) {
        dao.save(food);
        return "redirect:foods/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") UUID id) {
        dao.deleteById(id);
        return "redirect:/foods/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") UUID id, ModelMap map) {
        map.addAttribute("food", dao.findById(id).get());
        return "/foods/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Food food) {
        dao.save(food);
        return "redirect:/foods/listar";
    }
}
