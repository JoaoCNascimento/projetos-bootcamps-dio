package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Calendario;
import com.dio.live.repository.CalendarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarioService {

    @Autowired
    CalendarioRepository calendarioRepository;

    public Calendario save(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> findAll() {
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getById(long id) {
        return calendarioRepository.findById(id);
    }

    public Calendario update(Calendario calendario) {
        return calendarioRepository.save(calendario);
    }

    public void delete(long id) {
        calendarioRepository.deleteById(id);
    }
}
