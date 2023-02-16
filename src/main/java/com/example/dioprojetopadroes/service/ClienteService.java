package com.example.dioprojetopadroes.service;

import com.example.dioprojetopadroes.model.Cliente;

import java.util.List;

public interface ClienteService {

    Iterable<Cliente> findAll();

    Cliente findById(Long id);

    void save(Cliente cliente);

    void update(Long id, Cliente cliente);

    void delete(Long id);

}
