package br.com.salao.vo;

public class Cidade {
	private long codigo;
	private String nome;
	private String estado;

	public Cidade() {
	}

	public Cidade(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// O ComboBox usa este mÃ©todo para exibir o nome da cidade
	@Override
	public String toString() {
		return nome + (estado == null ? "" : "/" + estado);
	}

	// reescrevi o método que compara dois objetos da classe Cidade
	@Override
	public boolean equals(Object cidade) {
		Cidade c = (Cidade) cidade;

		if (c != null && codigo == c.codigo)
			return true;
		else
			return false;
	}

	public String[] toArray() {
		return new String[] { Long.toString(codigo), nome, estado};
	}

}
