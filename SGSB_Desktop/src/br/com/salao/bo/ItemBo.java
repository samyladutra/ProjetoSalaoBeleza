package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.ItemDao;
import br.com.salao.dao.ProdutoDao;
import br.com.salao.dao.ServicoDAO;
import br.com.salao.vo.ItemVo;
import br.com.salao.vo.ProdutoVo;
import br.com.salao.vo.ServicoVo;

public class ItemBo {

	// rever eficiencia da permanencia dessa classe
	private Connection conexao = ConnectionFactory.getConnection();

	public List<ItemVo> ListaItem() throws SQLException {
		List<ItemVo> item = new ArrayList<ItemVo>();
		ItemDao iDao = new ItemDao(conexao);
		item = iDao.getListaItem();
		return item;
	}

	public ItemVo DescobreItem(long codigo) throws SQLException {
		ItemDao itemdao = new ItemDao(conexao);
		ItemVo i = new ItemVo();
		i = itemdao.DescobreItem(codigo);
		return i;
	}

	public void adicionaServico(ServicoVo servico) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		try {
			sDao.adiciona(servico);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoIdServico() throws SQLException {
		long i;
		ServicoDAO sDao = new ServicoDAO(conexao);
		i = sDao.getProximoId();
		return i;
	}

	public void excluirServico(int codigo) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		try {
			sDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ServicoVo> ListaServico() throws SQLException {
		List<ServicoVo> serv = new ArrayList<ServicoVo>();
		ServicoDAO sDao = new ServicoDAO(conexao);
		serv = sDao.getLista();
		return serv;
	}

	public List<ServicoVo> ListaPorNomeServico(String nome) throws SQLException {
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

	public void alterarServico(ServicoVo serv) throws SQLException {
		ServicoDAO sDao = new ServicoDAO(conexao);
		sDao.altera(serv);
	}

	public void alterarItem(ItemVo item) throws SQLException {
		ItemDao iDao = new ItemDao(conexao);
		iDao.alteraItem(item);
	}

	public String verificaProduto(ProdutoVo prod) {
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

	public void incluirProduto(ProdutoVo produto) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		try {
			pDao.incluir(produto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public long ProximoIdProduto() throws SQLException {
		long i;
		ProdutoDao pDao = new ProdutoDao(conexao);
		i = pDao.getProximoId();
		return i;
	}

	public void excluirProduto(long codigo) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		try {
			pDao.remove(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ProdutoVo> ListaProduto() throws SQLException {
		List<ProdutoVo> prod = new ArrayList<ProdutoVo>();
		ProdutoDao pDao = new ProdutoDao(conexao);
		prod = pDao.getLista();
		return prod;
	}

	public List<ProdutoVo> ListaPorNomeProduto(String nome) throws SQLException {
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

	public void alterarProduto(ProdutoVo prod) throws SQLException {
		ProdutoDao pDao = new ProdutoDao(conexao);
		pDao.altera(prod);
	}

}
