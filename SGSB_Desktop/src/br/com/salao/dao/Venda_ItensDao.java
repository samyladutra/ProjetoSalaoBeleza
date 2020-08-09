package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.ItemVo;
import br.com.salao.vo.VendaVo;
import br.com.salao.vo.Venda_ItensVo;

public class Venda_ItensDao {
	private Connection conexao;

	public Venda_ItensDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public Venda_ItensDao() {

	}

	public long getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'venda_itens'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getLong("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public void adiciona(Venda_ItensVo vItens) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO venda_itens (CdItem, CdVenda, VlTotal, QuantItem, VlItem) VALUES (?, ?, ?, ?,?)");

		stmt.setLong(1, vItens.getItem().getCdItem());
		System.out.println("Código do ítem: " + vItens.getItem().getCdItem());
		stmt.setLong(2, vItens.getVenda().getCodigo());
		stmt.setDouble(3, vItens.getVlTotal());
		stmt.setInt(4, vItens.getQuantItem());
		stmt.setDouble(5, vItens.getVlItem());

		stmt.execute();
		stmt.close();
	}

	// busca por data (Consulta Venda de itens)
	public List<Venda_ItensVo> buscaPorData(Date data1, Date data2)
			throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("select * from venda_itens as VI INNER JOIN venda as V on VI.CdVenda = V.CdVenda INNER JOIN item as I on I.CdItem = VI.CdItem where V.DtVenda between ? and ?");
		stmt.setDate(1, new java.sql.Date(data1.getTime()));
		stmt.setDate(2, new java.sql.Date(data2.getTime()));

		ResultSet rs = stmt.executeQuery();
		List<Venda_ItensVo> vi = new ArrayList<Venda_ItensVo>();
		ItemDao iDao = new ItemDao(conexao);
		VendaDao vDao = new VendaDao(conexao);
		ItemVo item = new ItemVo();

		while (rs.next()) {
			Venda_ItensVo vendaItens = new Venda_ItensVo();
			item = iDao.DescobreItem(rs.getInt("I.CdItem"));
			// adicionar o item descoberto na tabela Venda_Itens
			vendaItens.setItem(item);

			VendaVo venda = new VendaVo();
			venda = vDao.DescobreVenda(rs.getLong("V.CdVenda"));
			vendaItens.setVenda(venda);

			vendaItens.setVlItem(rs.getDouble("VI.VlItem"));
			vendaItens.setQuantItem(rs.getInt("VI.QuantItem"));
			vendaItens.setVlTotal(rs.getDouble("VI.VlTotal"));

			vi.add(vendaItens);

		}

		rs.close();
		stmt.close();
		return vi;
	}

	public List<Venda_ItensVo> buscaPorNomeData(String nome, Date data1,
			Date data2) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("select C.NmCliente, I.CdItem, V.CdVenda, VI.VlItem, VI.QuantItem, VI.VlTotal from venda_itens as VI INNER JOIN venda as V on VI.CdVenda = V.CdVenda INNER JOIN item as I on I.CdItem = VI.CdItem INNER JOIN Cliente as C on C.CdCliente=V.CdCliente where V.DtVenda between ? and ? and C.NmCliente=?");
		stmt.setDate(1, new java.sql.Date(data1.getTime()));
		stmt.setDate(2, new java.sql.Date(data2.getTime()));
		stmt.setString(3, nome);

		ResultSet rs = stmt.executeQuery();
		List<Venda_ItensVo> vi = new ArrayList<Venda_ItensVo>();
		ItemDao iDao = new ItemDao(conexao);
		VendaDao vDao = new VendaDao(conexao);
		ItemVo item = new ItemVo();

		while (rs.next()) {
			Venda_ItensVo vendaItens = new Venda_ItensVo();
			item = iDao.DescobreItem(rs.getInt("I.CdItem"));
			// adicionar o item descoberto na tabela Venda_Itens
			vendaItens.setItem(item);

			VendaVo venda = new VendaVo();
			venda = vDao.DescobreVenda(rs.getLong("V.CdVenda"));
			vendaItens.setVenda(venda);

			vendaItens.setVlItem(rs.getDouble("VI.VlItem"));
			vendaItens.setQuantItem(rs.getInt("VI.QuantItem"));
			vendaItens.setVlTotal(rs.getDouble("VI.VlTotal"));

			vi.add(vendaItens);

		}

		rs.close();
		stmt.close();
		return vi;
	}

	public Venda_ItensVo DescobreVendaItens(long idItem, long idVenda)
			throws SQLException {
		PreparedStatement stmt2 = conexao
				.prepareStatement("Select CdItem, CdVenda, VlTotal, QuantItem, VlItem FROM venda_itens WHERE CdItem=? and CdVenda=?");
		stmt2.setLong(1, idItem);
		stmt2.setLong(2, idVenda);

		ResultSet rs = stmt2.executeQuery();
		Venda_ItensVo VendaItens = new Venda_ItensVo();
		ItemDao iDao = new ItemDao();
		VendaDao vDao = new VendaDao();

		if (rs.first()) {
			ItemVo item = new ItemVo();
			item = iDao.DescobreItem(rs.getLong("CdItem"));
			VendaItens.setItem(item);

			VendaVo venda = new VendaVo();
			venda = vDao.DescobreVenda(rs.getLong("CdVenda"));
			VendaItens.setVenda(venda);

			VendaItens.setVlTotal(rs.getDouble("VlTotal"));

			VendaItens.setQuantItem(rs.getInt("QuantItem"));
			VendaItens.setVlItem(rs.getDouble("VlItem"));
		}

		return VendaItens;
	}

	public void removeVendaI(long idItem, long idVenda) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM venda_itens WHERE CdItem=? and CdVenda=?");
		stmt.setLong(1, idItem);
		stmt.setLong(2, idVenda);
		stmt.execute();
		stmt.close();
	}

	public List<Venda_ItensVo> buscaPorNmCliente(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM venda_itens as VI INNER JOIN venda as V on VI.CdVenda = V.CdVenda INNER JOIN item as I on I.CdItem = VI.CdItem INNER JOIN cliente as C on C.CdCliente=V.CdCliente where C.CdCliente=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		List<Venda_ItensVo> viVo = new ArrayList<Venda_ItensVo>();
		ItemDao iDao = new ItemDao(conexao);
		VendaDao vDao = new VendaDao(conexao);
		ItemVo item = new ItemVo();

		while (rs.next()) {

			Venda_ItensVo ListaRelat = new Venda_ItensVo();
			item = iDao.DescobreItem(rs.getInt("I.CdItem"));
			// adicionar o item descoberto na tabela Venda_Itens
			ListaRelat.setItem(item);

			VendaVo venda = new VendaVo();
			venda = vDao.DescobreVenda(rs.getLong("V.CdVenda"));
			ListaRelat.setVenda(venda);

			ListaRelat.setVlItem(rs.getDouble("VI.VlItem"));
			ListaRelat.setQuantItem(rs.getInt("VI.QuantItem"));
			ListaRelat.setVlTotal(rs.getDouble("VI.VlTotal"));

			viVo.add(ListaRelat);
		}
		rs.close();
		stmt.close();
		return viVo;
	}
}
