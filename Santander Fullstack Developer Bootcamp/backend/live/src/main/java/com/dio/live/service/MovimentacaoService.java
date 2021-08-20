package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Movimentacao;
import com.dio.live.repository.MovimentacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> getById(long id) {
        return movimentacaoRepository.findById(id);
    }

    public Movimentacao update(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void delete(long id) {
        movimentacaoRepository.deleteById(id);
    }
}
