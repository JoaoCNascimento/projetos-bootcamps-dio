package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Ocorrencia;
import com.dio.live.repository.OcorrenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService {

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia save(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getById(long id) {
        return ocorrenciaRepository.findById(id);
    }

    public Ocorrencia update(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void delete(long id) {
        ocorrenciaRepository.deleteById(id);
    }
}
