package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.ServicoVo;

public class ServicoDAO {
	private Connection conexao;

	public ServicoDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public ServicoDAO() {

	}

	public void adiciona(ServicoVo servico) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO item (NmItem, Duracao, Preco, Descricao, Tipo) VALUES (?, ?, ?, ?,?)");

		stmt.setString(1, servico.getNome());
		stmt.setInt(2, servico.getDuracao());
		stmt.setDouble(3, servico.getPreco());
		stmt.setString(4, servico.getDescricao());
		stmt.setString(5, "Servico");

		long id = getProximoId();
		servico.setCodigo(id);

		stmt.execute();
		stmt.close();
	}

	public void altera(ServicoVo servico) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE item SET NmItem=?, Duracao=?, Preco=?, Descricao=? WHERE CdItem=?");

		stmt.setString(1, servico.getNome());
		stmt.setInt(2, servico.getDuracao());
		stmt.setDouble(3, servico.getPreco());
		stmt.setString(4, servico.getDescricao());
		stmt.setLong(5, servico.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public void remove(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM item WHERE CdItem=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public ServicoVo DescobreServico(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmItem, Duracao, Preco, Descricao FROM item WHERE CdItem=?");
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		ServicoVo servico = new ServicoVo();
		if (rs.first()) {
			servico.setCodigo(codigo);
			servico.setNome(rs.getString("NmItem"));
			servico.setDuracao(rs.getInt("Duracao"));
			servico.setPreco(rs.getDouble("Preco"));
			servico.setDescricao(rs.getString("Descricao"));
		}

		return servico;
	}

	public long getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'item'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getInt("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public List<ServicoVo> getLista() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao FROM item where Tipo='Servico' ORDER BY CdItem");
		ResultSet rs = stmt.executeQuery();
		List<ServicoVo> servicos = new ArrayList<ServicoVo>();

		while (rs.next()) {
			// criando o objeto Contato
			ServicoVo servico = new ServicoVo();
			servico.setCodigo(rs.getLong("CdItem"));
			servico.setNome(rs.getString("NmItem"));
			servico.setDuracao(rs.getInt("Duracao"));
			servico.setPreco(rs.getDouble("Preco"));
			servico.setDescricao(rs.getString("Descricao"));
			servicos.add(servico);
		}
		rs.close();
		stmt.close();
		return servicos;
	}

	public List<ServicoVo> getListaPorNome(String nome) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao FROM item WHERE Tipo='Servico' and NmItem LIKE ? ORDER BY CdItem");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		List<ServicoVo> servicos = new ArrayList<ServicoVo>();

		while (rs.next()) {
			ServicoVo servico = new ServicoVo();
			servico.setCodigo(rs.getLong("CdItem"));
			servico.setNome(rs.getString("NmItem"));
			servico.setDuracao(rs.getInt("Duracao"));
			servico.setPreco(rs.getDouble("Preco"));
			servico.setDescricao(rs.getString("Descricao"));
			servicos.add(servico);
		}
		rs.close();
		stmt.close();
		return servicos;
	}

	public ServicoVo busca(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao  FROM item WHERE CdItem=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		ServicoVo s = null;
		if (rs.first()) {

			s = new ServicoVo();
			s.setCodigo(rs.getLong("CdItem"));
			s.setNome(rs.getString("NmItem"));
			s.setDuracao(rs.getInt("Duracao"));
			s.setPreco(rs.getDouble("Preco"));
			s.setDescricao(rs.getString("Descricao"));

		}
		rs.close();
		stmt.close();
		return s;
	}

}
