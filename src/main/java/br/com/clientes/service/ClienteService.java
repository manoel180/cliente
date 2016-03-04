package br.com.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.clientes.entities.Cliente;
import br.com.clientes.repository.ClienteRepository;
import br.com.clientes.repository.filter.ClienteFilter;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public void salvar(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public void excluir(Long codigo) {
		clienteRepository.delete(codigo);
	}
	
	public List<Cliente> filtrar(ClienteFilter filtro) {
	//	String descricao = filtro.getNome() == null ? "%" : filtro.getNome();
		return clienteRepository.findByNomeContaining("%");
	}

	public Cliente getCliente(Long codigo) {
		return clienteRepository.findOne(codigo);
	}
	
}
