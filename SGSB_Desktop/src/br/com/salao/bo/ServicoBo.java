package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.ServicoDAO;
import br.com.salao.vo.ServicoVo;

public class ServicoBo {
	private Connection conexao = ConnectionFactory.getConnection();
	

	public void adiciona(ServicoVo servico) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		try {
			sDao.adiciona(servico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoId() throws SQLException {
		long i;
		ServicoDAO sDao = new ServicoDAO(conexao);
		i = sDao.getProximoId();
		return i;
	}

	public void excluir(int codigo) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		try {
			sDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ServicoVo> Lista() throws SQLException {
		List<ServicoVo> serv = new ArrayList<ServicoVo>();
		ServicoDAO sDao = new ServicoDAO(conexao);
		serv = sDao.getLista();
		return serv;
	}

	public List<ServicoVo> ListaPorNome(String nome) throws SQLException {
		List<ServicoVo> serv = new ArrayList<ServicoVo>();
		ServicoDAO sDao = new ServicoDAO(conexao);
		serv = sDao.getListaPorNome(nome);
		return serv;

	}

	public ServicoVo DescobreServico(long codigo) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		ServicoVo serv = new ServicoVo();
		serv = sDao.DescobreServico(codigo);
		return serv;
	}

	public void alterar(ServicoVo serv) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		sDao.altera(serv);
	}

}
