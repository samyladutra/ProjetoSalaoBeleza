package br.com.salao.vo;

import br.com.salao.bo.Venda_ItensBo;

public class Venda_ItensVo {

	private VendaVo Venda;
	private ItemVo Item;
	private double VlTotal;
	private int QuantItem;
	private double VlItem;

	public Venda_ItensVo() {

	}

	public Venda_ItensVo(VendaVo Venda, ItemVo Item, double VlTotal,
			int QuantItem, double VlItem) {
		this.Item = Item;
		this.Venda = Venda;
		this.VlItem = VlItem;
		this.VlTotal = VlTotal;
		this.QuantItem = QuantItem;

	}

	public VendaVo getVenda() {
		return Venda;
	}

	public void setVenda(VendaVo venda) {
		Venda = venda;
	}

	public ItemVo getItem() {
		return Item;
	}

	public void setItem(ItemVo item) {
		Item = item;
	}

	public double getVlTotal() {
		return VlTotal;
	}

	public void setVlTotal(double vlTotal) {
		VlTotal = vlTotal;
	}

	public int getQuantItem() {
		return QuantItem;
	}

	public void setQuantItem(int quantItem) {
		QuantItem = quantItem;
	}

	public double getVlItem() {
		return VlItem;
	}

	public void setVlItem(double vlItem) {
		VlItem = vlItem;
	}

	public double RetornaSubTotal() {
		System.out.println(Item.getPreco() * getQuantItem());
		return (Item.getPreco() * getQuantItem());
	}

	public String[] toArray() {

		return new String[] { Item.getNmItem(),
				String.valueOf(this.getQuantItem()), String.valueOf(VlItem),
				String.valueOf(VlTotal) };
	}

	public String[] AtualizaTable() {
		Venda_ItensBo viBo = new Venda_ItensBo();
		String data;
		data = viBo.converteDataemString(Venda.getData());
		return new String[] { String.valueOf(Venda.getCodigo()), data,
				Venda.getCli().getNome(), String.valueOf(Item.getCdItem()),
				Item.getNmItem(), String.valueOf(VlTotal) };
	}
	
}
