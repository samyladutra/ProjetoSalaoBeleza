package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.MarcaDao;
import br.com.salao.vo.MarcaVo;

public class MarcaBo {
	
	private Connection conexao = ConnectionFactory.getConnection();
	
	public void incluir(MarcaVo marca) throws SQLException {
		MarcaDao mDao = new MarcaDao(conexao);
		try {
			mDao.incluir(marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoId() throws SQLException {
		long i;
		MarcaDao mDao = new MarcaDao(conexao);
		i = mDao.getProximoId();
		return i;
	}

	public void excluir(long codigo) throws SQLException {
		MarcaDao mDao = new MarcaDao(conexao);
		try {
			mDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<MarcaVo> Lista() throws SQLException {
		List<MarcaVo> marca = new ArrayList<MarcaVo>();
		MarcaDao mDao = new MarcaDao(conexao);
		marca = mDao.getLista();
		return marca;
	}
	
	public List<MarcaVo> ListaPorNome(String nome) throws SQLException {
		List<MarcaVo> marca = new ArrayList<MarcaVo>();
		MarcaDao mDao = new MarcaDao(conexao);
		marca = mDao.getListaPorNome(nome);
		return marca;

	}
	
	public void alterar(MarcaVo marca) throws SQLException {
		MarcaDao mDao = new MarcaDao(conexao);
		mDao.altera(marca);
	}
	
	public MarcaVo DescobrirMarca(long codigo) throws SQLException {
		MarcaDao mDao = new MarcaDao(conexao);
		MarcaVo marca = new MarcaVo();
		marca = mDao.DescobreMarca(codigo);
		return marca;
	}

}
