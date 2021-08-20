package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoDataService;

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
@RequestMapping("/tipo-data")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData) {
        return tipoDataService.save(tipoData);
    }

    @GetMapping("/list")
    public List<TipoData> getList() {
        return tipoDataService.findAll();
    }

    @GetMapping("/{id}")
    public TipoData getById(@PathVariable("id") long id) throws Exception {
        return tipoDataService.getById(id).orElseThrow(() -> new Exception("Tipo de data não encontrado."));
    }

    @PutMapping
    public TipoData update(@RequestBody TipoData tipoData) {
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        tipoDataService.delete(id);
    }

}
