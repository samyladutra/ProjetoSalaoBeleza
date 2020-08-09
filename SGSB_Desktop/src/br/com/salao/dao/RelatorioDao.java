package br.com.salao.dao;

import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDao {

	public void geraRelatorio() throws Exception {
		// ele que é o relatorio em pdf
		JasperPrint relat;
		Connection conn = ConnectionFactory.getConnection();

		HashMap parameters = new HashMap();

		relat = JasperFillManager
				.fillReport(
						"C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\1ºBimestre\\RelatorioProduto.jasper",
						parameters, conn);

		JasperExportManager
				.exportReportToPdfFile(
						relat,
						"C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\1ºBimestre\\RelatorioProduto.pdf");

		JasperViewer.viewReport(relat, false);
	}
}
