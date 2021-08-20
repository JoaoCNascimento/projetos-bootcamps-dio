package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelAcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelAcessoService {

    @Autowired
    NivelAcessoRepository nivelAcessoRepository;

    public NivelAcesso save(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> findAll() {
        return nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> getById(long id) {
        return nivelAcessoRepository.findById(id);
    }

    public NivelAcesso update(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void delete(long id) {
        nivelAcessoRepository.deleteById(id);
    }
}
