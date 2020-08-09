package br.com.salao.bo;

import br.com.salao.dao.RelatorioDao;

public class RelatorioBo {
	
	public void GeraRelatorio() throws Exception{
		RelatorioDao relatorio = new RelatorioDao();
		relatorio.geraRelatorio();
	}
	
	
	

}
