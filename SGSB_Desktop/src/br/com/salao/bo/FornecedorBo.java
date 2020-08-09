package br.com.salao.bo;

import java.util.Date;

import br.com.salao.dao.FornecedorDao;
import br.com.salao.vo.FornecedorVo;

public class FornecedorBo {
	
	public int incluir(FornecedorVo f) {
		FornecedorDao forn = new FornecedorDao();
		int id = forn.incluir(f);
		return id;
	}
	

	public FornecedorVo consultarPorCodigo(int id) {
		FornecedorDao forn = new FornecedorDao();
		FornecedorVo f = forn.consultarPorCodigo(id);
		return f;
	}

	public boolean excluir(int id) {
		FornecedorDao forn = new FornecedorDao();
		if (forn.consultarPorCodigo(id) != null) {
			forn.excluir(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean alterar(int codigo, String nome, String empresa, int telefone,
			String tipoProduto,  Date dtPassagem) {
		FornecedorDao forn = new FornecedorDao();
		if ((telefone > 0) && (nome != null)) {
			forn.alterar(codigo, nome, empresa, telefone, tipoProduto, dtPassagem);
			return true;
		} else {
			return false;
		}
	}

}
