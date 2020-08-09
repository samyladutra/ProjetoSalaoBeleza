package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.ProdutoDao;
import br.com.salao.vo.ProdutoVo;

public class ProdutoBo {
	private Connection conexao = ConnectionFactory.getConnection();

	public String verifica(ProdutoVo prod) {
		if (prod.getNmProduto() == null) {
			return "Preencha o campo Nome.";
		}
		if (prod.getMarca() == null) {
			return "Preencha o campo Marca.";
		}
		if (prod.getArea() == null) {
			return "Selecione uma área de utilização.";
		}
		if (prod.getPreco() == 0) {
			return "Digite um valor para preço";
		}
		return "";
	}

	public void incluir(ProdutoVo produto) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		try {
			pDao.incluir(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoId() throws SQLException {
		long i;
		ProdutoDao pDao = new ProdutoDao(conexao);
		i = pDao.getProximoId();
		return i;
	}

	public void excluir(long codigo) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		try {
			pDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ProdutoVo> Lista() throws SQLException {
		List<ProdutoVo> prod = new ArrayList<ProdutoVo>();
		ProdutoDao pDao = new ProdutoDao(conexao);
		prod = pDao.getLista();
		return prod;
	}

	public List<ProdutoVo> ListaPorNome(String nome) throws SQLException {
		List<ProdutoVo> prod = new ArrayList<ProdutoVo>();
		ProdutoDao pDao = new ProdutoDao(conexao);
		prod = pDao.getListaPorNome(nome);
		return prod;

	}

	public ProdutoVo DescobrirProduto(long codigo) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		ProdutoVo prod = new ProdutoVo();
		prod = pDao.DescobreProduto(codigo);
		return prod;
	}

	public void alterar(ProdutoVo prod) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		pDao.altera(prod);
	}

}
//
// public int incluir(ProdutoVo p) {
// ProdutoDao pro = new ProdutoDao();
// int id = pro.incluir(p);
// return id;
// }
//
// public ProdutoVo consultarPorCodigo(int id) {
// ProdutoDao pro = new ProdutoDao();
// ProdutoVo p = pro.consultarPorCodigo(id);
// return p;
// }
//
// public boolean excluir(int id) {
// ProdutoDao pro = new ProdutoDao();
// if (pro.consultarPorCodigo(id) != null) {
// pro.excluir(id);
// return true;
// } else {
// return false;
// }
// }
//
// public boolean alterar(int codigo, String nome, String marca, double
// preco) {
// ProdutoDao pro = new ProdutoDao();
// if ((preco > 0) && (nome != null)) {
// pro.alterar(codigo, nome, marca, preco);
// return true;
// } else {
// return false;
// }
// }

