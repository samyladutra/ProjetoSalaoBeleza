package br.com.salao.vo;

public class MarcaVo {

	private long CdMarca;
	private String NmMarca;

	public long getCdMarca() {
		return CdMarca;
	}

	public void setCdMarca(long cdMarca) {
		CdMarca = cdMarca;
	}

	public String getNmMarca() {
		return NmMarca;
	}

	public void setNmMarca(String nmMarca) {
		NmMarca = nmMarca;
	}

	public String toString() {
		return NmMarca;
	}

	public String[] toArray() {
		return new String[] { String.valueOf(CdMarca), NmMarca };
	}

}
