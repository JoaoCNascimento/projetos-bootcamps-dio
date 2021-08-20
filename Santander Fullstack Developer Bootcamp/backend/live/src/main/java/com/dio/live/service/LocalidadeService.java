package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Localidade;
import com.dio.live.repository.LocalidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {

    @Autowired
    LocalidadeRepository localidadeRepository;

    public Localidade save(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> getById(long id) {
        return localidadeRepository.findById(id);
    }

    public Localidade update(Localidade localidade) {
        return localidadeRepository.save(localidade);
    }

    public void delete(long id) {
        localidadeRepository.deleteById(id);
    }
}
