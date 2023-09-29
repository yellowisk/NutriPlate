package br.edu.ifsp.dsw3.nutriplate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.nutriplate.model.dao.MenuDAO;
import br.edu.ifsp.dsw3.nutriplate.model.domain.Menu;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    MenuDAO dao;

    @GetMapping("/cadastrar")
    public String cadastrar(Menu menu) {
        return "/menu/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("menus", dao.findAll());
        return "/menu/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Menu menu) {
        dao.save(menu);
        return "redirect:/menus/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") UUID id) {
        dao.deleteById(id);
        return "redirect:/menus/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") UUID id, ModelMap map) {
        map.addAttribute("menu", dao.findById(id).get());
        return "/menu/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Menu menu) {
        dao.save(menu);
        return "redirect:/menus/listar";
    }
}
