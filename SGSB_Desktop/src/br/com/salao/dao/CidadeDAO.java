package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.Cidade;



public class CidadeDAO {
	private Connection conexao;
	
	public CidadeDAO(){
		
	}

	public CidadeDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public void adiciona(Cidade cidade) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO cidades (NmCidade, Uf) VALUES (?, ?)");

		stmt.setString(1, cidade.getNome());
		stmt.setString(2, cidade.getEstado());

		long id = getProximoId();
		cidade.setCodigo(id);

		stmt.execute();
		stmt.close();
	}

	public void altera(Cidade cidade) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE cidades SET NmCidade=?, Uf=? WHERE CdCidade=?");

		stmt.setString(1, cidade.getNome());
		stmt.setString(2, cidade.getEstado());
		stmt.setLong(3, cidade.getCodigo());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(int codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM cidades WHERE CdCidade=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public Cidade DescobreCidade(int codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmCidade, Uf FROM cidades WHERE CdCidade=?");
		stmt2.setInt(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		Cidade cidade = new Cidade();
		if (rs.first()) {
			cidade.setCodigo(codigo);
			//System.out.println(cidade.getCodigo());
			cidade.setNome(rs.getString("NmCidade"));
			cidade.setEstado(rs.getString("Uf"));
		}
		
		return cidade;
	}

	public int getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'cidades'");
		ResultSet rs = stmt.executeQuery();
		int u = 1;
		if (rs.first()) {
			u = rs.getInt("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public List<Cidade> getLista() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM cidades ORDER BY CdCidade");
		ResultSet rs = stmt.executeQuery();
		List<Cidade> cidades = new ArrayList<Cidade>();

		while (rs.next()) {
			Cidade cidade = new Cidade();
			cidade.setCodigo(rs.getLong("CdCidade"));
			cidade.setNome(rs.getString("NmCidade"));
			cidade.setEstado(rs.getString("Uf"));
			cidades.add(cidade);
		}
		rs.close();
		stmt.close();
		return cidades;
	}

	public List<Cidade> getListaPorNome(String nome) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM cidades WHERE NmCidade LIKE ? ORDER BY CdCidade");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		List<Cidade> cidades = new ArrayList<Cidade>();

		while (rs.next()) {
			// criando o objeto Contato
			Cidade cidade = new Cidade();
			cidade.setCodigo(rs.getLong("CdCidade"));
			cidade.setNome(rs.getString("NmCidade"));
			cidade.setEstado(rs.getString("Uf"));
			cidades.add(cidade);
		}
		rs.close();
		stmt.close();
		return cidades;
	}

}
