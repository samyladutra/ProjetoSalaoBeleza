package br.com.salao.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salao.vo.FornecedorVo;

public class FornecedorDao {
	
	//classe errada! Ainda precisa ser implementada para fazer conexao com o Banco de Dados

	private static List<FornecedorVo> fornecedorList = new ArrayList<FornecedorVo>();
	private static int id = 0;

	public int incluir(FornecedorVo f) {
		FornecedorDao.id++;
		int id = FornecedorDao.id;
		f.setCdForn(id);
		FornecedorDao.fornecedorList.add(f);
		return id;
	}

	public FornecedorVo consultarPorCodigo(int id) {
		FornecedorVo fRet = null;
		for (int i = 0; i < FornecedorDao.fornecedorList.size(); i++) {
			if (FornecedorDao.fornecedorList.get(i).getCdForn() == id) {
				fRet = FornecedorDao.fornecedorList.get(i);
				break;
			}
		}
		return fRet;
	}

	public void excluir(int id) {
		for (int i = 0; i < FornecedorDao.fornecedorList.size(); i++) {
			if (FornecedorDao.fornecedorList.get(i).getCdForn() == id) {
				fornecedorList.remove(i);
			}
		}
	}
	
	public void alterar(int codigo, String nome, String empresa, int telefone, String tipoProduto,
			Date dtPassagem){
		//procura qual cliente deseja alterar
		FornecedorVo fRet = this.consultarPorCodigo(codigo);
		fRet.setNmForn(nome);
		fRet.setEmpresa(empresa);
		fRet.setTelefone(telefone);
		fRet.setTipoProduto(tipoProduto);
		fRet.setDtPassagem(dtPassagem);
	}
}
