package br.com.salao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.salao.vo.ProdutoVo;

public class ProdutoDao {
	private Connection conexao;

	public ProdutoDao(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}

	public void incluir(ProdutoVo produto) throws SQLException {

		PreparedStatement stmt = conexao
				.prepareStatement("INSERT INTO item (NmItem, Marca, Preco, Area, Descricao, Tipo, Quantidade) VALUES (?, ?, ?, ?, ?,?,?)");

		stmt.setString(1, produto.getNmProduto());
		stmt.setString(2, produto.getMarca());
		stmt.setDouble(3, produto.getPreco());
		stmt.setString(4, produto.getArea());
		stmt.setString(5, produto.getDescricao());
		stmt.setString(6, "Produto");
		stmt.setInt(7, produto.getQuantidade());

		// para pegar o proximo codigo do banco de dados:
		long id = getProximoId();
		produto.setCdProduto(id);

		stmt.execute();
		stmt.close();
	}

	public long getProximoId() throws SQLException {
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

	public List<ProdutoVo> getLista() throws SQLException {
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

	public List<ProdutoVo> getListaPorNome(String nome) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Marca, Area, Descricao, Preco FROM item WHERE Tipo='Produto' and NmItem LIKE ? ORDER BY CdItem");
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

	public ProdutoVo busca(long id) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("SELECT CdItem, NmItem, Marca, Area, Descricao, Preco, Tipo FROM item WHERE Tipo='Produto' and CdItem=?");
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

	public void remove(long codigo) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM item WHERE CdItem=?");
		stmt.setLong(1, codigo);
		stmt.execute();
		stmt.close();
	}

	public ProdutoVo DescobreProduto(long codigo) throws SQLException {

		PreparedStatement stmt2 = conexao
				.prepareStatement("Select NmItem, Marca, Preco, Descricao, Area, Quantidade FROM item WHERE Tipo='Produto' and CdItem=?");
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
			produto.setQuantidade(rs.getInt("Quantidade"));
		}

		return produto;
	}

	public void altera(ProdutoVo produto) throws SQLException {
		PreparedStatement stmt = conexao
				.prepareStatement("UPDATE item SET NmItem=?,Marca =?, Preco=?, Descricao=?, Area=?, Quantidade=? WHERE Tipo='Produto' and CdItem=?");

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
