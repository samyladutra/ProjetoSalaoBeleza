package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salao.vo.ItemVo;
import br.com.salao.vo.ProdutoVo;
import br.com.salao.vo.ServicoVo;

public class ItemDao {

	// repensar a eficiencia da existência de um ItemDao e um ItemBo

	private Connection conexao;

	public ItemDao() {

	}

	public ItemDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public List<ItemVo> getListaItem() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao, Quantidade, Marca, Area FROM item ORDER BY CdItem");
		ResultSet rs = stmt.executeQuery();
		List<ItemVo> itens = new ArrayList<ItemVo>();

		while (rs.next()) {
			ItemVo item = new ItemVo();
			item.setCdItem(rs.getLong("CdItem"));
			item.setNmItem(rs.getString("NmItem"));
			item.setDuracao(rs.getInt("Duracao"));
			item.setPreco(rs.getDouble("Preco"));
			item.setDescricao(rs.getString("Descricao"));
			item.setQuantidade(rs.getInt("Quantidade"));
			item.setMarca(rs.getString("Marca"));
			item.setArea(rs.getString("Area"));
			itens.add(item);
		}
		rs.close();
		stmt.close();
		return itens;
	}

	public ItemVo DescobreItem(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmItem, Duracao, Preco, Descricao, Marca, Area, Quantidade, Tipo FROM item WHERE CdItem=?");
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		ItemVo item = new ItemVo();
		if (rs.first()) {
			item.setCdItem(codigo);
			System.out.println("ITEM:" + item.getNmItem() + " Codigo: "
					+ item.getCdItem());
			item.setNmItem(rs.getString("NmItem"));
			item.setDuracao(rs.getInt("Duracao"));
			item.setPreco(rs.getDouble("Preco"));
			item.setDescricao(rs.getString("Descricao"));
			item.setMarca(rs.getString("Marca"));
			item.setArea(rs.getString("Area"));
			item.setQuantidade(rs.getInt("Quantidade"));
			item.setTipo(rs.getString("Tipo"));
		}

		return item;
	}

	public void alteraItem(ItemVo item) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE item SET NmItem=?,Marca =?, Preco=?, Descricao=?, Area=?, Quantidade=?, Duracao=?, Tipo=? WHERE CdItem=?");

		stmt.setString(1, item.getNmItem());
		stmt.setString(2, item.getMarca());
		stmt.setDouble(3, item.getPreco());
		stmt.setString(4, item.getDescricao());
		stmt.setString(5, item.getArea());
		stmt.setInt(6, item.getQuantidade());
		stmt.setInt(7, item.getDuracao());
		stmt.setString(8, item.getTipo());
		stmt.setLong(9, item.getCdItem());
		stmt.execute();
		stmt.close();
	}

	// desconsiderar o codigo daq pra baixo:

	public long getProximoIdServico() throws SQLException {
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

	public List<ServicoVo> getListaServico() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao FROM item where Tipo='Servico' ORDER BY CdItem");
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

	public List<ServicoVo> getListaPorNomeServico(String nome)
			throws SQLException {
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

	public ServicoVo buscaServico(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Duracao, Preco, Descricao FROM item WHERE Tipo='Servico' and CdItem=?");
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

	public void incluirProduto(ProdutoVo produto) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO item (NmItem, Marca, Preco, Area, Descricao, Tipo, Quantidade) VALUES (?, ?, ?, ?, ?,?,?)");

		stmt.setString(1, produto.getNmProduto());
		stmt.setString(2, produto.getMarca());
		stmt.setDouble(3, produto.getPreco());
		stmt.setString(4, produto.getArea());
		stmt.setString(5, produto.getDescricao());
		stmt.setInt(6, produto.getQuantidade());
		stmt.setString(7, "Produto");

		// para pegar o proximo codigo do banco de dados:
		long id = getProximoIdProduto();
		produto.setCdProduto(id);

		stmt.execute();
		stmt.close();
	}

	public long getProximoIdProduto() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_schema = 'salao_de_beleza2' AND table_name = 'item'");
		ResultSet rs = stmt.executeQuery();
		long u = 1;
		if (rs.first()) {
			u = rs.getLong("AUTO_INCREMENT");
		}
		rs.close();
		stmt.close();
		return u;
	}

	public List<ProdutoVo> getListaProduto() throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Marca, Preco, Descricao  FROM item  where Tipo='Produto' ORDER BY CdItem");
		ResultSet rs = stmt.executeQuery();
		List<ProdutoVo> ListaProd = new ArrayList<ProdutoVo>();

		while (rs.next()) {
			// criando o objeto Lista Produto. Que sao os atributos do produto
			// que aparecerão na lista
			ProdutoVo produto = new ProdutoVo();
			produto.setCdProduto(rs.getLong("CdItem"));
			produto.setNmProduto(rs.getString("NmItem"));
			produto.setMarca(rs.getString("Marca"));
			produto.setPreco(rs.getDouble("Preco"));
			produto.setDescricao(rs.getString("Descricao"));

			// adicionando o objeto a lista
			ListaProd.add(produto);
		}
		rs.close();
		stmt.close();
		return ListaProd;
	}

	public List<ProdutoVo> getListaPorNomeProduto(String nome)
			throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Marca, Area, Descricao, Preco FROM item WHERE Tipo='Produto' and NmItem LIKE ? ORDER BY NmItem");
		stmt.setString(1, "%" + nome + "%");
		ResultSet rs = stmt.executeQuery();
		List<ProdutoVo> ListaProd = new ArrayList<ProdutoVo>();

		while (rs.next()) {
			ProdutoVo produto = new ProdutoVo();
			produto.setCdProduto(rs.getLong("CdItem"));
			produto.setNmProduto(rs.getString("NmItem"));
			produto.setMarca(rs.getString("Marca"));
			produto.setArea(rs.getString("Area"));
			produto.setDescricao(rs.getString("Descricao"));
			produto.setPreco(rs.getDouble("Preco"));
			ListaProd.add(produto);
		}
		rs.close();
		stmt.close();
		return ListaProd;

	}

	public ProdutoVo buscaProduto(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Marca, Area, Descricao, Preco FROM produto WHERE Tipo='Produto' and CdItem=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		ProdutoVo p = new ProdutoVo();

		if (rs.first()) {
			p.setCdProduto(rs.getLong("CdItem"));
			p.setNmProduto(rs.getString("NmItem"));
			p.setMarca(rs.getString("Marca"));
			p.setArea(rs.getString("Area"));
			p.setDescricao(rs.getString("Descricao"));
			p.setPreco(rs.getDouble("Preco"));
		}
		rs.close();
		stmt.close();
		return p;
	}

	public void removeProduto(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM item WHERE CdItem=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public ProdutoVo DescobreProduto(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmItem, Marca, Preco, Descricao, Area FROM item WHERE CdItem=?");
		stmt2.setLong(1, codigo);

		ResultSet rs = stmt2.executeQuery();
		ProdutoVo produto = new ProdutoVo();
		if (rs.first()) {
			produto.setCdProduto(codigo);
			produto.setNmProduto(rs.getString("NmItem"));
			produto.setMarca(rs.getString("Marca"));
			produto.setPreco(rs.getDouble("Preco"));
			produto.setDescricao(rs.getString("Descricao"));
			produto.setArea(rs.getString("Area"));
		}

		return produto;
	}

	public void alteraProduto(ProdutoVo produto) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE item SET NmItem=?,Marca =?, Preco=?, Descricao=?, Area=?, Quantidade=? WHERE CdItem=?");

		stmt.setString(1, produto.getNmProduto());
		stmt.setString(2, produto.getMarca());
		stmt.setDouble(3, produto.getPreco());
		stmt.setString(4, produto.getDescricao());
		stmt.setString(5, produto.getArea());
		stmt.setInt(6, produto.getQuantidade());
		stmt.setLong(7, produto.getCdProduto());
		stmt.execute();
		stmt.close();
	}

}
