package br.com.clientes.repository.filter;

public class ClienteFilter {
	
	private Long id;
	
	private String cpf;
	
	private String nome;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cPF
	 */
	public String getCPF() {
		return cpf;
	}

	/**
	 * @param CPF the CPF to set
	 */
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
