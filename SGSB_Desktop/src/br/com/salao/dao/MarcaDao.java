package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.MarcaVo;


public class MarcaDao {

	private Connection conexao;

	public MarcaDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}
	


	public void incluir(MarcaVo marca) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO marca (CdMarca, NmMarca) VALUES (?, ?)");

		stmt.setLong(1, marca.getCdMarca());
		stmt.setString(2, marca.getNmMarca());

		// para pegar o proximo codigo do banco de dados:
		long id = getProximoId();
		marca.setCdMarca(id);

		stmt.execute();
		stmt.close();
	}
	
	public List<MarcaVo> getListaPorNome(String nome) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM marca WHERE NmMarca LIKE ? ORDER BY NmMarca");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		List<MarcaVo> ListaMarca = new ArrayList<MarcaVo>();

		while (rs.next()) {
			MarcaVo marca = new MarcaVo();
			marca.setCdMarca(rs.getLong("CdMarca"));
			marca.setNmMarca(rs.getString("NmMarca"));
			ListaMarca.add(marca);
		}
		rs.close();
		stmt.close();
		return ListaMarca;

	}

	public long getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'marca'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getInt("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public List<MarcaVo> getLista() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdMarca, NmMarca FROM marca ORDER BY CdMarca");
		ResultSet rs = stmt.executeQuery();
		List<MarcaVo> ListaMarca = new ArrayList<MarcaVo>();

		while (rs.next()) {
			// criando o objeto Lista Produto. Que sao os atributos do produto
			// que aparecerão na lista
			MarcaVo marca = new MarcaVo();
			marca.setCdMarca(rs.getLong("CdMarca"));
			marca.setNmMarca(rs.getString("NmMarca"));
			// adicionando o objeto a lista
			ListaMarca.add(marca);
		}
		rs.close();
		stmt.close();
		return ListaMarca;
	}
	
	public MarcaVo busca(int id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM marca WHERE CdMarca=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		MarcaVo m = new MarcaVo();

		if (rs.first()) {
			m.setCdMarca(rs.getLong("CdMarca"));
			m.setNmMarca(rs.getString("NmMarca"));
		}
		rs.close();
		stmt.close();
		return m;
	}

	public void remove(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM marca WHERE CdMarca=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}
	
	
	public MarcaVo DescobreMarca(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmMarca FROM marca WHERE CdMarca=?");
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		MarcaVo marca = new MarcaVo();
		if (rs.first()) {
			marca.setCdMarca(codigo);
			marca.setNmMarca(rs.getString("NmMarca"));
		}

		return marca;
	}
	
	public void altera(MarcaVo marca) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE marca SET NmMarca=? WHERE CdMarca=?");

		
		stmt.setString(1, marca.getNmMarca());
		stmt.execute();
		stmt.close();
	}
}
