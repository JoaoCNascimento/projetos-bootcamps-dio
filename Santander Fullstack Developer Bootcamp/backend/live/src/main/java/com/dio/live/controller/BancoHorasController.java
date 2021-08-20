package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.BancoHoras;
import com.dio.live.service.BancoHorasService;

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
@RequestMapping("/banco-horas")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.save(bancoHoras);
    }

    @GetMapping("/list")
    public List<BancoHoras> getList() {
        return bancoHorasService.findAll();
    }

    @GetMapping("/{id}")
    public BancoHoras getById(@PathVariable("id") long id) throws Exception {
        return bancoHorasService.getById(id).orElseThrow(() -> new Exception("Banco de horas não encontrado."));
    }

    @PutMapping
    public BancoHoras update(@RequestBody BancoHoras bancoHoras) {
        return bancoHorasService.update(bancoHoras);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        bancoHorasService.delete(id);
    }

}
