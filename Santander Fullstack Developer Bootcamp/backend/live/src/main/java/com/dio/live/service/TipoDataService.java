package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDataService {

    @Autowired
    TipoDataRepository tipoDataRepository;

    public TipoData save(TipoData tipoData) {
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> findAll() {
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> getById(long id) {
        return tipoDataRepository.findById(id);
    }

    public TipoData update(TipoData usuario) {
        return tipoDataRepository.save(usuario);
    }

    public void delete(long id) {
        tipoDataRepository.deleteById(id);
    }
}
