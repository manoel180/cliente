package br.com.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.clientes.entities.Cliente;
import br.com.clientes.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {

		try {
			clienteService.salvar(cliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Cliente> pesquisar() {
		List<Cliente> todosCliente = clienteService.filtrar(null);
		return todosCliente;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Cliente> pesquisarCliente(@PathVariable("id") Long codigo) {
		Cliente cliente = clienteService.getCliente(codigo);
		return  new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}


	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> excluir(@PathVariable("id") Long codigo) {
		clienteService.excluir(codigo);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
