package br.edu.ifsp.dsw3.nutriplate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.nutriplate.model.dao.UserDAO;
import br.edu.ifsp.dsw3.nutriplate.model.domain.User;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserDAO dao;

    @GetMapping("/cadastrar")
    public String cadastrar(User user) {
        return "/user/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("users", dao.findAll());
        return "/user/lista";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable("id") UUID id, ModelMap map) {
        map.addAttribute("user", dao.findById(id).get());
        return "/user/lista";
    }
}
