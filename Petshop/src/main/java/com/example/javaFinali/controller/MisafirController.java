package com.example.javaFinali.controller;

import com.example.javaFinali.model.Misafir;
import com.example.javaFinali.service.MisafirService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MisafirController {

    private final MisafirService service;

    public MisafirController(MisafirService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("tumMisafirler", service.misafirListele());
        return "index";
    }

    @GetMapping("/yeniMisafir")
    public String addNewEmployee(Model model) {
        Misafir misafir = new Misafir();
        model.addAttribute("misafir", misafir);
        return "yenimisafir";
    }

    @PostMapping("/kaydet")
    public String saveEmployee(@ModelAttribute("misafir") Misafir misafir) {
        service.misafirEkle(misafir);
        return "redirect:/";
    }

    @GetMapping("/guncelle/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Misafir misafir = service.misafirGetir(id);
        model.addAttribute("misafir", misafir);
        return "guncelle";
    }

    @GetMapping("/misafirSil/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        service.misafirSil(id);
        return "redirect:/";

    }

}
