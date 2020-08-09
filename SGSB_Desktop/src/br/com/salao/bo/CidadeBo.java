package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.CidadeDAO;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Cidade.Cadastro_Cidade;
import br.com.salao.view.Cliente.Cadastro_Cliente;
import br.com.salao.vo.Cidade;
import br.com.salao.vo.Cliente;

public class CidadeBo {
private Connection conexao = ConnectionFactory.getConnection();
	
	public void incluir(Cidade marca) throws SQLException {
		CidadeDAO mDao = new CidadeDAO(conexao);
		try {
			mDao.adiciona(marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoId() throws SQLException {
		long i;
		CidadeDAO mDao = new CidadeDAO(conexao);
		i = mDao.getProximoId();
		return i;
	}

	public void excluir(int codigo) throws SQLException {
		CidadeDAO mDao = new CidadeDAO(conexao);
		try {
			mDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cidade> Lista() throws SQLException {
		List<Cidade> marca = new ArrayList<Cidade>();
		CidadeDAO mDao = new CidadeDAO(conexao);
		marca = mDao.getLista();
		return marca;
	}
	
	public List<Cidade> ListaPorNome(String nome) throws SQLException {
		List<Cidade> marca = new ArrayList<Cidade>();
		CidadeDAO mDao = new CidadeDAO(conexao);
		marca = mDao.getListaPorNome(nome);
		return marca;

	}
	
	public void alterar(Cidade marca) throws SQLException {
		CidadeDAO mDao = new CidadeDAO(conexao);
		mDao.altera(marca);
	}
	
	public Cidade DescobrirMarca(int codigo) throws SQLException {
		CidadeDAO mDao = new CidadeDAO(conexao);
		Cidade marca = new Cidade();
		marca = mDao.DescobreCidade(codigo);
		return marca;
	}
	
	public Cidade ChamaTelaInserir() {
		Cidade c = new Cidade();
		Cadastro_Cidade inst = new Cadastro_Cidade(conexao);
		inst.setVisible(true);
		inst.setLocationRelativeTo(null);
		c = inst.getCidade();
		return c;
	}
	
}
