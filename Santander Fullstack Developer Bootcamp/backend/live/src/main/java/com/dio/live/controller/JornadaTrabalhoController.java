package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.save(jornadaTrabalho);
    }

    @GetMapping("/list")
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public JornadaTrabalho getJornadaById(@PathVariable("id") long id) throws Exception {
        return jornadaService.getById(id).orElseThrow(() -> new Exception("Jornada não encontrada."));
    }

    @PutMapping
    public JornadaTrabalho updateJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public void deleteJornadaById(@PathVariable("id") long id) {
        jornadaService.delete(id);
    }

}
