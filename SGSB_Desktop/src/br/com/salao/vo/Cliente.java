package br.com.salao.vo;

public class Cliente {
	private long codigo;
	private String nome;
	private String sexo;
	private int telefone;
	private int cpf;
	private String email;
	private Cidade cidade;
	private String bairro;

	private String rua;
	private int numero;
	private String complemento;

	public Cliente() {

	}

	public Cliente(long codigo, String nome, String sexo, int telefone,
			int cpf, String email, Cidade cidade, String bairro, String rua,
			int numero, String complemento) {
		super(); // qual o motivo desse super aqui ????
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return nome;
	}

	/*
	 * public String[] toArray(AgendamentoDAO dao) { return new String[] { nome
	 * }; }
	 */

	public String[] toArray() {
		return new String[] { Long.toString(codigo), nome,
				String.valueOf(telefone),
				String.valueOf(cpf), email };
	}

}
