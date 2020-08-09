package br.com.salao.vo;

import java.util.Date;

public class FornecedorVo {
	private long CdForn;
	private String NmForn;
	private int Telefone;
	private String Produto;
	private String Empresa;
	private Date DtPassagem;

	public long getCdForn() {
		return CdForn;
	}

	public void setCdForn(long cdForn) {
		CdForn = cdForn;
	}

	public String getNmForn() {
		return NmForn;
	}

	public void setNmForn(String nmForn) {
		NmForn = nmForn;
	}

	public int getTelefone() {
		return Telefone;
	}

	public void setTelefone(int telefone) {
		Telefone = telefone;
	}

	public String getTipoProduto() {
		return Produto;
	}

	public void setTipoProduto(String tipoProduto) {
		Produto = tipoProduto;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public Date getDtPassagem() {
		return DtPassagem;
	}

	public void setDtPassagem(Date dtPassagem) {
		DtPassagem = dtPassagem;
	}
	
	public String toString() {
		return CdForn
				+ (NmForn == null ? "" : " - " + NmForn);
	}
}
