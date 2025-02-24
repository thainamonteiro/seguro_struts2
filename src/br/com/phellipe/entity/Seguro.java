package br.com.phellipe.entity;


public class Seguro {

	private Long id;
	private String nome;
	private Double valor;

	public Seguro(Long id, String nome, Double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Seguro() {
	}

	public Seguro(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Seguro [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}

}
