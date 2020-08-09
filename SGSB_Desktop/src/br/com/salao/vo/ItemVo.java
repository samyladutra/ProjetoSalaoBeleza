package br.com.salao.vo;

public class ItemVo {

	// rever eficiencia da permanencia dessa classe

	private long CdItem;
	private String NmItem;
	private int Duracao;
	private double Preco;
	private String Descricao;
	private String Marca;
	private String Area;
	private int Quantidade;
	private String Tipo;

	public ItemVo() {

	}


	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public long getCdItem() {
		return CdItem;
	}

	public void setCdItem(long cdItem) {
		CdItem = cdItem;
	}

	public String getNmItem() {
		return NmItem;
	}

	public void setNmItem(String nmItem) {
		NmItem = nmItem;
	}

	public int getDuracao() {
		return Duracao;
	}

	public void setDuracao(int duracao) {
		Duracao = duracao;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public String[] toArray() {
		return new String[] { String.valueOf(CdItem), NmItem };
	}

	public String toString() {
		return NmItem;
	}
}
