package br.com.empresa.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.clientes.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

    
}
