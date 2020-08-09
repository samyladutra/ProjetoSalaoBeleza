package br.com.salao.vo;

import java.util.Date;

import br.com.salao.bo.Venda_ItensBo;

public class RelatorioVenda_ItensVo {

	private long cliente_CdCliente;
	private String cliente_NmCliente;
	private String item_Descricao;
	private long item_CdItem;
	private String item_NmItem;
	private Date venda_DtVenda;
	private double venda_itens_VlItem;
	private double venda_itens_VlTotal;
	
	public long getCliente_CdCliente() {
		return cliente_CdCliente;
	}
	public void setCliente_CdCliente(long cliente_CdCliente) {
		this.cliente_CdCliente = cliente_CdCliente;
	}
	public String getCliente_NmCliente() {
		return cliente_NmCliente;
	}
	public void setCliente_NmCliente(String cliente_NmCliente) {
		this.cliente_NmCliente = cliente_NmCliente;
	}
	public String getItem_Descricao() {
		return item_Descricao;
	}
	public void setItem_Descricao(String item_Descricao) {
		this.item_Descricao = item_Descricao;
	}
	public long getItem_CdItem() {
		return item_CdItem;
	}
	public void setItem_CdItem(long item_CdItem) {
		this.item_CdItem = item_CdItem;
	}
	public String getItem_NmItem() {
		return item_NmItem;
	}
	public void setItem_NmItem(String item_NmItem) {
		this.item_NmItem = item_NmItem;
	}
	public Date getVenda_DtVenda() {
		return venda_DtVenda;
	}
	public void setVenda_DtVenda(Date venda_DtVenda) {
		this.venda_DtVenda = venda_DtVenda;
	}
	public double getVenda_itens_VlItem() {
		return venda_itens_VlItem;
	}
	public void setVenda_itens_VlItem(double venda_itens_VlItem) {
		this.venda_itens_VlItem = venda_itens_VlItem;
	}
	public double getVenda_itens_VlTotal() {
		return venda_itens_VlTotal;
	}
	public void setVenda_itens_VlTotal(double venda_itens_VlTotal) {
		this.venda_itens_VlTotal = venda_itens_VlTotal;
	}
	

}
