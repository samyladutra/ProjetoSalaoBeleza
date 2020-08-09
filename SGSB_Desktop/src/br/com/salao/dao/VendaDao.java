package br.com.salao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.salao.vo.Cliente;
import br.com.salao.vo.VendaVo;

public class VendaDao {

	// classe ainda nao terminada !!!

	private Connection conexao;

	public VendaDao() {
	}

	public VendaDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public long getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'venda'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getLong("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public void adiciona(VendaVo venda) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO venda (VlVenda, DtVenda, CdCliente, Status) VALUES (?, ?, ?, ?)");
		java.sql.Date data = new java.sql.Date(venda.getData().getTime());
		stmt.setDouble(1, venda.getTotal());
		stmt.setDate(2, data);
		stmt.setLong(3, venda.getCli().getCodigo());
		stmt.setString(4, venda.getStatus());

		long id = getProximoId();
		venda.setCodigo(id);

		stmt.execute();
		stmt.close();
	}

	public VendaVo DescobreVenda(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select VlVenda, DtVenda, CdCliente, Status FROM venda WHERE CdVenda=?");
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		VendaVo venda = new VendaVo();
		ClienteDAO cliDao = new ClienteDAO(conexao);

		if (rs.first()) {
			venda.setCodigo(codigo);
			venda.setTotal(rs.getDouble("VlVenda"));
			venda.setData(rs.getDate("DtVenda"));

			// adicionando a chave estrangeira cliente
			Cliente cliente = new Cliente();
			cliente = cliDao.DescobreCliente(rs.getLong("CdCliente"));
			venda.setCli(cliente);

			venda.setStatus(rs.getString("Status"));
		}

		return venda;
	}

	public void remove(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM venda WHERE CdVenda=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public void altera(VendaVo venda) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE venda SET VlVenda=?, DtVenda =?, CdCliente=?, Status=? WHERE CdVenda=?");

		stmt.setDouble(1, venda.getTotal());
		stmt.setDate(2, (Date) venda.getData());
		stmt.setLong(3, venda.getCli().getCodigo());
		stmt.setString(4, venda.getStatus());
		stmt.execute();
		stmt.close();
	}

}
