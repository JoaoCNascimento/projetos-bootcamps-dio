package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoHorasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoHorasService {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    public BancoHoras save(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll() {
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(long id) {
        return bancoHorasRepository.findById(id);
    }

    public BancoHoras update(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(long id) {
        bancoHorasRepository.deleteById(id);
    }
}
