package com.example.dioprojetopadroes.service.impl;

import com.example.dioprojetopadroes.model.Cliente;
import com.example.dioprojetopadroes.model.Endereco;
import com.example.dioprojetopadroes.repositories.ClienteRepository;
import com.example.dioprojetopadroes.repositories.EnderecoRepository;
import com.example.dioprojetopadroes.service.ClienteService;
import com.example.dioprojetopadroes.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Long id, Cliente cliente) {

        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent())
            clienteRepository.save(cliente);

    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);

    }

    public void saveWithCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco newEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(newEndereco);
            return newEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
