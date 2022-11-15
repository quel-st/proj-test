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

    @Override
    public Cliente findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Cliente();
    }

    @Override
    public List<Cliente> findByNome(String nome){
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }


}
