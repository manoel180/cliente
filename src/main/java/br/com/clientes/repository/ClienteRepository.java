package br.com.clientes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.clientes.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	public List<Cliente> findByNomeContaining(String descricao);

}
