package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.Cidade;
import br.com.salao.vo.Cliente;

public class ClienteDAO {
	private Connection conexao;

	public ClienteDAO() {

	}

	public ClienteDAO(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public void adiciona(Cliente cliente) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO cliente (NmCliente, Sexo, Telefone, CPF, Email, Bairro, Rua, Num, Complemento,CdCidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		// seta os valores
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getSexo());
		stmt.setInt(3, cliente.getTelefone());
		stmt.setInt(4, cliente.getCpf());
		stmt.setString(5, cliente.getEmail());
		stmt.setString(6, cliente.getBairro());
		stmt.setString(7, cliente.getRua());
		stmt.setInt(8, cliente.getNumero());
		stmt.setString(9, cliente.getComplemento());
		stmt.setLong(10, cliente.getCidade().getCodigo());

		// aparecer o codigo modificando a cada "novo" na interface
		Long id = getProximoId();
		cliente.setCodigo(id);

		// executa
		stmt.execute();
		stmt.close();
	}

	public void altera(Cliente cliente) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE cliente SET NmCliente=?,Num =?, Rua=?, Bairro=?, Telefone=?, Sexo=?, Email=?, Complemento=?, CdCidade=?, CPF=? WHERE CdCliente=?");

		stmt.setString(1, cliente.getNome());
		stmt.setInt(2, cliente.getNumero());
		stmt.setString(3, cliente.getRua());
		stmt.setString(4, cliente.getBairro());
		stmt.setInt(5, cliente.getTelefone());
		stmt.setString(6, cliente.getSexo());
		stmt.setString(7, cliente.getEmail());
		stmt.setString(8, cliente.getComplemento());
		stmt.setLong(9, cliente.getCidade().getCodigo());
		stmt.setInt(10, cliente.getCpf());
		stmt.setLong(11, cliente.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public long getProximoId() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'cliente'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getLong("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public List<Cliente> getLista() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdCliente, NmCliente, Telefone, Email, CdCidade, Sexo, CPF FROM cliente ORDER BY CdCliente");
		ResultSet rs = stmt.executeQuery();
		List<Cliente> cliente = new ArrayList<Cliente>();
		Cidade cid = new Cidade();
		CidadeDAO cidDAO = new CidadeDAO(conexao);

		while (rs.next()) {
			// criando o objeto Lista Cliente. Que sao os atributos do cliente
			// que aparecerão na lista
			Cliente ListaCli = new Cliente();
			ListaCli.setCodigo(rs.getInt("CdCliente"));
			ListaCli.setNome(rs.getString("NmCliente"));
			ListaCli.setTelefone(rs.getInt("Telefone"));
			ListaCli.setEmail(rs.getString("Email"));
			ListaCli.setCpf(rs.getInt("CPF"));
			// criando um objeto do tipo cidade para pesquisar o nome da cidade
			// a partir do codigo retornado do banco de dados
			cid = cidDAO.DescobreCidade(rs.getInt("CdCidade"));
			ListaCli.setCidade(cid);
			ListaCli.setSexo(rs.getString("Sexo"));

			// adicionando o objeto a lista
			cliente.add(ListaCli);
		}
		rs.close();
		stmt.close();
		return cliente;
	}

	public List<Cliente> getListaPorNome(String nome) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM cliente WHERE NmCliente LIKE ? ORDER BY CdCliente");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		Cidade cid = new Cidade();
		CidadeDAO cidDAO = new CidadeDAO(conexao);

		List<Cliente> cliente = new ArrayList<Cliente>();

		while (rs.next()) {
			// criando o objeto Lista do Cliente
			Cliente ListaCli = new Cliente();
			ListaCli.setCodigo(rs.getInt("CdCliente"));
			ListaCli.setNome(rs.getString("NmCliente"));
			ListaCli.setTelefone(rs.getInt("Telefone"));
			ListaCli.setEmail(rs.getString("Email"));
			ListaCli.setBairro(rs.getString("Bairro"));
			ListaCli.setCpf(rs.getInt("CPF"));
			ListaCli.setComplemento(rs.getString("Complemento"));
			ListaCli.setNumero(Integer.parseInt(rs.getString("Num")));
			ListaCli.setRua(rs.getString("Rua"));

			cid = cidDAO.DescobreCidade(rs.getInt("CdCidade"));
			ListaCli.setCidade(cid);
			ListaCli.setSexo(rs.getString("Sexo"));

			cliente.add(ListaCli);
		}
		rs.close();
		stmt.close();
		return cliente;
	}

	public Cliente DescobreCliente(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmCliente, Telefone, Sexo, Num, Email, Bairro, Rua, CPF, Complemento FROM cliente WHERE CdCliente=?");
		// , Numero, Email, Bairro, Rua, CPF
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		Cliente cliente = new Cliente();
		if (rs.first()) {

			cliente.setCodigo(codigo);

			cliente.setNome(rs.getString("NmCliente"));
			cliente.setTelefone(rs.getInt("Telefone"));
			cliente.setSexo(rs.getString("Sexo"));
			cliente.setNumero(rs.getInt("Num"));
			cliente.setEmail(rs.getString("Email"));
			cliente.setBairro(rs.getString("Bairro"));
			cliente.setRua(rs.getString("Rua"));
			cliente.setCpf(rs.getInt("CPF"));
			cliente.setComplemento(rs.getString("Complemento"));

		}

		return cliente;
	}

	public void remove(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM cliente WHERE CdCliente=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public Cliente busca(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT * FROM cliente WHERE CdCliente=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();

		Cliente c = null;
		if (rs.first()) {

			c = new Cliente();
			c.setCodigo(rs.getLong("CdCliente"));
			c.setNome(rs.getString("NmCliente"));
			c.setTelefone(rs.getInt("Telefone"));
			c.setSexo(rs.getString("Sexo"));
			c.setNumero(rs.getInt("Num"));
			c.setEmail(rs.getString("Email"));
			c.setBairro(rs.getString("Bairro"));
			c.setRua(rs.getString("Rua"));
			c.setCpf(rs.getInt("CPF"));
			c.setComplemento(rs.getString("Complemento"));
		}
		rs.close();
		stmt.close();
		return c;
	}

}
