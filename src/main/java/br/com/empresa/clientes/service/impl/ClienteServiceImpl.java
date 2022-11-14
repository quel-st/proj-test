package br.com.empresa.clientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.clientes.entity.Cliente;
import br.com.empresa.clientes.repository.ClienteRepository;
import br.com.empresa.clientes.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    // listagem dos produtos
    @Override
    public List<Cliente> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }

}
