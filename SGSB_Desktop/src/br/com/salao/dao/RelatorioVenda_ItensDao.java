package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salao.vo.RelatorioVenda_ItensVo;

public class RelatorioVenda_ItensDao {

	private Connection conexao;

	public RelatorioVenda_ItensDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	// metodo que permite gerar o relatorio passando por parâmetro a data
	public List<RelatorioVenda_ItensVo> buscaPorData(Date data1, Date data2)
			throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT venda.DtVenda AS venda_DtVenda, venda_itens.VlTotal AS venda_itens_VlTotal, venda_itens.VlItem AS venda_itens_VlItem,cliente.CdCliente AS cliente_CdCliente, cliente.NmCliente AS cliente_NmCliente, item.NmItem AS item_NmItem, item.Descricao AS item_Descricao, item.CdItem AS item_CdItem FROM venda venda INNER JOIN venda_itens venda_itens ON venda.CdVenda = venda_itens.CdVenda INNER JOIN cliente cliente ON venda.CdCliente = cliente.CdCliente INNER JOIN item item ON venda_itens.CdItem = item.CdItem where venda.DtVenda between ? and ?");
		stmt.setDate(1, new java.sql.Date(data1.getTime()));
		stmt.setDate(2, new java.sql.Date(data2.getTime()));

		ResultSet rs = stmt.executeQuery();
		List<RelatorioVenda_ItensVo> vi = new ArrayList<RelatorioVenda_ItensVo>();

		while (rs.next()) {
			RelatorioVenda_ItensVo vendaItens = new RelatorioVenda_ItensVo();

			vendaItens.setItem_NmItem(rs.getString("item_NmItem"));
			vendaItens.setVenda_DtVenda(rs.getDate("venda_DtVenda"));
			vendaItens.setItem_Descricao(rs.getString("item_Descricao"));
			vendaItens.setVenda_itens_VlTotal(rs
					.getDouble("venda_itens_VlTotal"));
			vendaItens
					.setVenda_itens_VlItem(rs.getDouble("venda_itens_VlItem"));
			vendaItens.setCliente_NmCliente(rs.getString("cliente_NmCliente"));
			vendaItens.setCliente_CdCliente(rs.getLong("cliente_CdCliente"));
			vendaItens.setItem_CdItem(rs.getLong("item_CdItem"));

			vi.add(vendaItens);

		}

		rs.close();
		stmt.close();
		return vi;
	}

	public List<RelatorioVenda_ItensVo> buscaPorNmCliente(String nome)
			throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT C.NmCliente, C.CdCliente, V.DtVenda, I.CdItem, I.NmItem, VI.VlTotal, VI.VlItem, I.Descricao FROM venda_itens as VI INNER JOIN venda as V on VI.CdVenda = V.CdVenda INNER JOIN item as I on I.CdItem = VI.CdItem INNER JOIN cliente as C on C.CdCliente=V.CdCliente where C.NmCliente=?");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();

		List<RelatorioVenda_ItensVo> viVo = new ArrayList<RelatorioVenda_ItensVo>();

		while (rs.next()) {

			RelatorioVenda_ItensVo ListaRelat = new RelatorioVenda_ItensVo();
			ListaRelat.setItem_NmItem(rs.getString("item_NmItem"));
			ListaRelat.setVenda_DtVenda(rs.getDate("venda_DtVenda"));
			ListaRelat.setItem_Descricao(rs.getString("item_Descricao"));
			ListaRelat.setVenda_itens_VlTotal(rs
					.getDouble("venda_itens_VlTotal"));
			ListaRelat
					.setVenda_itens_VlItem(rs.getDouble("venda_itens_VlItem"));
			ListaRelat.setCliente_NmCliente(rs.getString("cliente_NmCliente"));
			ListaRelat.setCliente_CdCliente(rs.getLong("cliente_CdCliente"));
			ListaRelat.setItem_CdItem(rs.getLong("item_CdItem"));

			viVo.add(ListaRelat);
		}
		rs.close();
		stmt.close();
		return viVo;
	}

	public List<RelatorioVenda_ItensVo> buscaPorCdCliente(long id)
			throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT venda.DtVenda AS venda_DtVenda, venda_itens.VlTotal AS venda_itens_VlTotal, venda_itens.VlItem AS venda_itens_VlItem,cliente.CdCliente AS cliente_CdCliente, cliente.NmCliente AS cliente_NmCliente, item.NmItem AS item_NmItem, item.Descricao AS item_Descricao, item.CdItem AS item_CdItem FROM venda venda INNER JOIN venda_itens venda_itens ON venda.CdVenda = venda_itens.CdVenda INNER JOIN cliente cliente ON venda.CdCliente = cliente.CdCliente INNER JOIN item item ON venda_itens.CdItem = item.CdItem where cliente.CdCliente=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		List<RelatorioVenda_ItensVo> viVo = new ArrayList<RelatorioVenda_ItensVo>();

		while (rs.next()) {
			RelatorioVenda_ItensVo ListaRelat = new RelatorioVenda_ItensVo();
			ListaRelat.setItem_NmItem(rs.getString("item_NmItem"));
			ListaRelat.setVenda_DtVenda(rs.getDate("venda_DtVenda"));
			ListaRelat.setItem_Descricao(rs.getString("item_Descricao"));
			ListaRelat.setVenda_itens_VlTotal(rs
					.getDouble("venda_itens_VlTotal"));
			ListaRelat
					.setVenda_itens_VlItem(rs.getDouble("venda_itens_VlItem"));
			ListaRelat.setCliente_NmCliente(rs.getString("cliente_NmCliente"));
			ListaRelat.setCliente_CdCliente(rs.getLong("cliente_CdCliente"));
			ListaRelat.setItem_CdItem(rs.getLong("item_CdItem"));

			viVo.add(ListaRelat);
		}
		rs.close();
		stmt.close();
		return viVo;
	}

	// metodo que retorna as vendas de um cliente em um determinado período
	public List<RelatorioVenda_ItensVo> buscaPorNomeData(String nome,
			Date data1, Date data2) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT venda.DtVenda AS venda_DtVenda, venda_itens.VlTotal AS venda_itens_VlTotal, venda_itens.VlItem AS venda_itens_VlItem,cliente.CdCliente AS cliente_CdCliente, cliente.NmCliente AS cliente_NmCliente, item.NmItem AS item_NmItem, item.Descricao AS item_Descricao, item.CdItem AS item_CdItem FROM venda venda INNER JOIN venda_itens venda_itens ON venda.CdVenda = venda_itens.CdVenda INNER JOIN cliente cliente ON venda.CdCliente = cliente.CdCliente INNER JOIN item item ON venda_itens.CdItem = item.CdItem where venda.DtVenda between ? and ? and cliente.NmCliente=?");
		stmt.setDate(1, new java.sql.Date(data1.getTime()));
		stmt.setDate(2, new java.sql.Date(data2.getTime()));
		stmt.setString(3, nome);

		ResultSet rs = stmt.executeQuery();
		List<RelatorioVenda_ItensVo> vi = new ArrayList<RelatorioVenda_ItensVo>();

		while (rs.next()) {
			RelatorioVenda_ItensVo vendaItens = new RelatorioVenda_ItensVo();

			vendaItens.setItem_NmItem(rs.getString("item_NmItem"));
			vendaItens.setVenda_DtVenda(rs.getDate("venda_DtVenda"));
			vendaItens.setItem_Descricao(rs.getString("item_Descricao"));
			vendaItens.setVenda_itens_VlTotal(rs
					.getDouble("venda_itens_VlTotal"));
			vendaItens
					.setVenda_itens_VlItem(rs.getDouble("venda_itens_VlItem"));
			vendaItens.setCliente_NmCliente(rs.getString("cliente_NmCliente"));
			vendaItens.setCliente_CdCliente(rs.getLong("cliente_CdCliente"));
			vendaItens.setItem_CdItem(rs.getLong("item_CdItem"));

			vi.add(vendaItens);

		}

		rs.close();
		stmt.close();
		return vi;
	}

	// código que deverá ser excluído posteriormente:

	// classe em construção
	//
	// public void geraRelatorio() throws Exception {
	// // metodo gera relatorio completo de todas as vendas sem nenhum filtro
	// // (nao faz sentido)
	// JasperPrint relat;
	// Connection conn = ConnectionFactory.getConnection();
	//
	// HashMap parameters = new HashMap();
	//
	// relat = JasperFillManager
	// .fillReport(
	// "C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\Relatorio_Venda_Itens.jasper",
	// parameters, conn);
	//
	// JasperExportManager
	// .exportReportToPdfFile(relat,
	// "C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\Relatorio_Venda_Itens.pdf");
	//
	// JasperViewer.viewReport(relat, false);
	// }
}
