package br.com.salao.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.Venda_ItensDao;
import br.com.salao.vo.Venda_ItensVo;

public class Venda_ItensBo {

	private Connection conexao = ConnectionFactory.getConnection();

	public String Verifica(Venda_ItensVo vi) {
		if ((vi.getQuantItem() == 0) || (vi.getQuantItem() < 0)) {
			return "Digite uma quantidade válida!";
		}
		if ((vi.getItem().getCdItem() == 0)
				|| (vi.getItem().getNmItem().equals(""))) {
			return "Selecione um ítem!";
		}
		return "";
	}

	public void adicionaVendaItem(Venda_ItensVo vItens) throws SQLException {
		Venda_ItensDao vIDao = new Venda_ItensDao(conexao);
		vIDao.adiciona(vItens);
	}

	// apenas para aparecer na interface (Venda_Itens)
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public Date converteData(String data) {
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formata.parse(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public String converteDataemString(Date data) {
		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		return formata.format(data);
	}

	public List<Venda_ItensVo> buscaPorData(Date date1, Date date2)
			throws SQLException {
		List<Venda_ItensVo> list = new ArrayList<Venda_ItensVo>();
		Venda_ItensDao vIDao = new Venda_ItensDao(conexao);
		list = vIDao.buscaPorData(date1, date2);
		return list;
	}
	
	public List<Venda_ItensVo> buscaPorNmCliente(long id)
			throws SQLException {
		List<Venda_ItensVo> list = new ArrayList<Venda_ItensVo>();
		Venda_ItensDao vIDao = new Venda_ItensDao(conexao);
		list = vIDao.buscaPorNmCliente(id);
		return list;
	}
	
	public List<Venda_ItensVo> buscaPorNomeData(String nome, Date data1, Date data2)
			throws SQLException {
		List<Venda_ItensVo> list = new ArrayList<Venda_ItensVo>();
		Venda_ItensDao vIDao = new Venda_ItensDao(conexao);
		list = vIDao.buscaPorNomeData(nome, data1, data2);
		return list;
	}

	public Venda_ItensVo DescobreVendaItens(long idItem, long idVenda) throws SQLException {
		Venda_ItensDao viDao = new Venda_ItensDao(conexao);
		Venda_ItensVo viVo = new Venda_ItensVo();
		viVo = viDao.DescobreVendaItens(idItem, idVenda);
		return viVo;
	}

	public void removeVendaI(long idItem, long idVenda) throws SQLException {
		Venda_ItensDao viDao = new Venda_ItensDao(conexao);
		viDao.removeVendaI(idItem, idVenda);
	}
}
