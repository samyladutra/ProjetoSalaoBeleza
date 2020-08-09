package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.VendaDao;

import br.com.salao.vo.VendaVo;

public class VendaBo {

	// classe ainda nao terminada!!

	private Connection conexao = ConnectionFactory.getConnection();

	public long ProximoId() throws SQLException {
		long i;
		VendaDao vDao = new VendaDao(conexao);
		i = vDao.getProximoId();
		return i;
	}

	public void adiciona(VendaVo venda) throws SQLException {
		VendaDao vDao = new VendaDao(conexao);
		vDao.adiciona(venda);
	}

	public void excluir(long codigo) throws SQLException {
		VendaDao vDao = new VendaDao(conexao);
		try {
			vDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(VendaVo venda) throws SQLException {
		VendaDao vDao = new VendaDao(conexao);
		vDao.altera(venda);
	}

}
