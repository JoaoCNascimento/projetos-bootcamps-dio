package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Calendario;
import com.dio.live.service.CalendarioService;

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
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario) {
        return calendarioService.save(calendario);
    }

    @GetMapping("/list")
    public List<Calendario> getList() {
        return calendarioService.findAll();
    }

    @GetMapping("/{id}")
    public Calendario getById(@PathVariable("id") long id) throws Exception {
        return calendarioService.getById(id).orElseThrow(() -> new Exception("Calendário não encontrado."));
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario) {
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        calendarioService.delete(id);
    }

}
