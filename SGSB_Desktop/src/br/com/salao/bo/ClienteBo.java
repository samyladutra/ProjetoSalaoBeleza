package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Cliente.Inserir_Cliente;
import br.com.salao.vo.Cliente;

public class ClienteBo {

	// alterar para verificar todos os dados do cliente

	private Connection conexao = ConnectionFactory.getConnection();

	public String VerificaDados(Cliente cliente) {
		if (cliente.getNome() == null) {
			return "Preencha o campo nome!";
		}
		if (cliente.getCpf() < 0) {
			return "Digite o CPF corretamente!";
		}
		return "";
	}

	public void incluir(Cliente produto) throws SQLException {
		ClienteDAO pDao = new ClienteDAO(conexao);
		try {
			pDao.adiciona(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoId() throws SQLException {
		long i;
		ClienteDAO pDao = new ClienteDAO(conexao);
		i = pDao.getProximoId();
		return i;
	}

	public void excluir(long codigo) throws SQLException {
		ClienteDAO pDao = new ClienteDAO(conexao);
		try {
			pDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> Lista() throws SQLException {
		List<Cliente> prod = new ArrayList<Cliente>();
		ClienteDAO pDao = new ClienteDAO(conexao);
		prod = pDao.getLista();
		return prod;
	}

	public List<Cliente> ListaPorNome(String nome) throws SQLException {
		List<Cliente> prod = new ArrayList<Cliente>();
		ClienteDAO pDao = new ClienteDAO(conexao);
		prod = pDao.getListaPorNome(nome);
		return prod;

	}

	public Cliente DescobrirCliente(long codigo) throws SQLException {
		ClienteDAO cDao = new ClienteDAO(conexao);
		Cliente cli = new Cliente();
		cli = cDao.DescobreCliente(codigo);
		return cli;
	}

	public void alterar(Cliente prod) throws SQLException {
		ClienteDAO pDao = new ClienteDAO(conexao);
		pDao.altera(prod);
	}

	public Cliente ChamaTelaInserir() {
		Cliente c = new Cliente();
		Inserir_Cliente inst = new Inserir_Cliente();
		inst.setVisible(true);
		inst.setLocationRelativeTo(null);
		c = inst.getCliente();
		return c;
	}

}
