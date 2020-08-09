package br.com.salao.vo;

import java.util.Date;


public class VendaVo {
	private long Codigo;
	private Date Data;
	private double Total;
	private Cliente cli;
	private String Status;

	public VendaVo() {

	}

	public VendaVo(long codigo, Date data, double total, Cliente cli, String Status) {
		this.Codigo = codigo;
		this.Data = data;
		this.Total = total;
		this.cli = cli;
		this.Status=Status;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Cliente getCli() {
		return cli;
	}

	public long getCodigo() {
		return Codigo;
	}

	public void setCodigo(long codigo) {
		Codigo = codigo;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}
	
	public void setCli(Cliente cli) {
		this.cli = cli;
	}

}
