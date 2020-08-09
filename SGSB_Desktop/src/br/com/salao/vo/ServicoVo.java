package br.com.salao.vo;

public class ServicoVo {
	private long codigo;
	private String nome;
	private int duracao;
	private double preco;
	private String descricao;

	public ServicoVo() {

	}

	public ServicoVo(long codigo, String nome, int duracao, double preco,
			String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
		this.preco = preco;
		this.descricao = descricao;
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

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] toArray() {
		return new String[] { Long.toString(codigo), nome,
				Integer.toString(duracao), Double.toString(preco)};
	}
	
	public String toString(){
		return nome;
	}

}