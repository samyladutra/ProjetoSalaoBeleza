package br.com.salao.vo;

public class ProdutoVo {

	private long CdProduto;
	private String NmProduto;
	private String Marca;
	private double Preco;
	private String Area;
	private String Descricao;
	private int Quantidade;

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public ProdutoVo() {

	}

	public ProdutoVo(long CdProduto, String NmProduto, String Marca,
			double Preco, String area, String Descricao, int Quantidade) {
		this.CdProduto = CdProduto;
		this.Marca = Marca;
		this.Preco = Preco;
		this.NmProduto = NmProduto;
		this.Area = area;
		this.Descricao = Descricao;
		this.Quantidade = Quantidade;
	}

	public long getCdProduto() {
		return CdProduto;
	}

	public void setCdProduto(long CdProduto) {
		this.CdProduto = CdProduto;
	}

	public String getNmProduto() {
		return NmProduto;
	}

	public void setNmProduto(String nmProduto) {
		NmProduto = nmProduto;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String toString() {
		return CdProduto
				+ (NmProduto == null ? "" : " - " + NmProduto + Marca + Preco);
	}

	public String[] toArray() {
		return new String[] { String.valueOf(CdProduto), NmProduto, Marca,
				String.valueOf(Preco), Descricao };
	}

	public String[] fillsTable() {
		return new String[] { String.valueOf(CdProduto), NmProduto, Marca,
				String.valueOf(Preco), Descricao, String.valueOf(Quantidade) };
	}

}
