package com.example.dioprojetopadroes.repositories;

import com.example.dioprojetopadroes.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
