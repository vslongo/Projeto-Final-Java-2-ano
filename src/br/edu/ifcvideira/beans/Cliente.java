package br.edu.ifcvideira.beans;

import java.sql.Timestamp;
import java.util.Date;

public class Cliente {
	
	private int codigo;
	private String nome;
	private String cpf;
	private String telefone;
	private double renda;
	private int idade;
	private int filhos;
	private String periodo;
	private Timestamp data;
	
	//construtor vazio, sem necessidade de parâmetros
	public Cliente(){
		
	}
	
	//encapsulamento dos atributos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(java.sql.Timestamp timestamp) {
		this.data = timestamp;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getFilhos() {
		return filhos;
	}

	public void setFilhos(int filhos) {
		this.filhos = filhos;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}	

	
	
}
