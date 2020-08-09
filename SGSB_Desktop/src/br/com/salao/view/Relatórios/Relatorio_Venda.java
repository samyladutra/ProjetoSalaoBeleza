package br.com.salao.view.Relatórios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import br.com.salao.bo.Venda_ItensBo;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.RelatorioVenda_ItensDao;
import br.com.salao.vo.RelatorioVenda_ItensVo;
import br.com.salao.vo.Venda_ItensVo;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Relatorio_Venda extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbDtInicio;
	private ButtonGroup btGroup;
	private JPanel PanelExibir;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JButton btFiltrar;
	public static JTextField tfCdCliente;
	private JButton btCancelar;
	private JButton btCadastrar;
	private JButton btSair;
	private JTable TableRelatorio;
	private JScrollPane ScrollPane;
	private JButton btPesquisaCliente;
	public static JTextField tfNmCliente;
	private JCheckBox CheckBoxCliente;
	private JCheckBox CheckBoxPago;
	private JCheckBox CheckBoxAndamento;
	private JCheckBox CheckBoxInicial;
	private JTextField tfDtInicial;
	private JPanel PanelPeriodo;
	private JLabel lbRelatorioVenda;
	private DefaultTableModel TableRelatorioModel;
	private Venda_ItensBo viBo;
	private RelatorioVenda_ItensDao RviDao;
	private RelatorioVenda_ItensVo RviVo;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Relatorio_Venda inst = new Relatorio_Venda();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Relatorio_Venda() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setTitle("Relatório de Vendas");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/blogs32.png")).getImage());
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbRelatorioVenda = new JLabel();
					PanelTotal.add(lbRelatorioVenda);
					lbRelatorioVenda.setText("Relatório de Vendas");
					lbRelatorioVenda.setBounds(171, 24, 290, 43);
					lbRelatorioVenda
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/blogs32.png")));
					lbRelatorioVenda.setFont(new java.awt.Font("Lucida Sans",
							0, 24));
				}
				{
					PanelPeriodo = new JPanel();
					PanelTotal.add(PanelPeriodo);
					PanelPeriodo.setLayout(null);
					PanelPeriodo.setBounds(407, 78, 255, 98);
					PanelPeriodo.setBorder(BorderFactory
							.createTitledBorder("Período"));
					{
						lbDtInicio = new JLabel();
						PanelPeriodo.add(lbDtInicio);
						lbDtInicio.setText("Data Inicial");
						lbDtInicio.setBounds(22, 24, 76, 14);
						lbDtInicio.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/calendar.png")));
					}
					{
						tfDtInicial = new JTextField();
						PanelPeriodo.add(tfDtInicial);
						tfDtInicial.setBounds(22, 38, 105, 20);
					}
					{
						lbDtFinal = new JLabel();
						PanelPeriodo.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setBounds(133, 24, 80, 14);
						lbDtFinal.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/calendar.png")));
					}
					{
						tfDtFinal = new JTextField();
						PanelPeriodo.add(tfDtFinal);
						tfDtFinal.setBounds(133, 38, 106, 20);
					}
					{
						btFiltrar = new JButton();
						PanelPeriodo.add(btFiltrar);
						btFiltrar.setText("Filtrar");
						btFiltrar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/filter (2).png")));
						btFiltrar.setBounds(158, 64, 81, 25);
						btFiltrar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if ((tfDtInicial.getText().equals("") && ((tfDtFinal
										.getText().equals(""))))
										&& ((!tfNmCliente.getText().equals("")))) {
									System.out
											.println("Passou no AddVendaPorNome()");
									ListarRelatorioNome();
								}

								if ((!tfDtFinal.getText().equals(""))
										&& (!tfDtInicial.getText().equals(""))
										&& (!tfNmCliente.getText().equals(""))) {
									System.out.println("Entrou if correto!!");
									ListarRelatorioNomeData();

								}

								if ((tfNmCliente.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))) {
									System.out
											.println("Passou no AddVendaPorData()");
									ListarRelatorioData();
								}

							}
						});
					}
				}
				{
					CheckBoxInicial = new JCheckBox();
					CheckBoxInicial.setText("Status Inicial");
					CheckBoxInicial.setBounds(13, 58, 87, 23);
				}
				{
					CheckBoxAndamento = new JCheckBox();
					CheckBoxAndamento.setText("Status Andamento");
					CheckBoxAndamento.setBounds(102, 58, 115, 23);
				}
				{
					CheckBoxPago = new JCheckBox();
					CheckBoxPago.setText("Status Pago");
					CheckBoxPago.setBounds(219, 58, 83, 23);
				}
				{
					CheckBoxCliente = new JCheckBox();
					CheckBoxCliente.setText("Por cliente:");
					CheckBoxCliente.setBounds(13, 30, 80, 23);
					CheckBoxCliente.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							tfNmCliente.setEnabled(true);
							btPesquisaCliente.setEnabled(true);

						}
					});
				}
				{
					tfNmCliente = new JTextField();
					tfNmCliente.setBounds(138, 30, 198, 20);
				}
				{
					btPesquisaCliente = new JButton();
					btPesquisaCliente.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisaCliente.setBounds(342, 28, 28, 24);
					btPesquisaCliente.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Selecionar_Cliente inst = new Selecionar_Cliente();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
						}
					});
				}

				{
					ScrollPane = new JScrollPane();
					ScrollPane.setBounds(20, 193, 642, 222);
					ScrollPane.setViewportView(TableRelatorio);
				}
				{

					String colunas[] = { "Código Venda", "Data da Venda",
							"Cliente", "Código Item", "Item", "Total" };
					TableRelatorioModel = new DefaultTableModel(colunas, 0);

					TableRelatorio = new JTable();
					ScrollPane.setViewportView(TableRelatorio);
					TableRelatorio.setModel(TableRelatorioModel);

					TableRelatorio.getColumnModel().getColumn(0)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(1)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(2)
							.setPreferredWidth(40);
					TableRelatorio.getColumnModel().getColumn(3)
							.setPreferredWidth(10);
					TableRelatorio.getColumnModel().getColumn(4)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(5)
							.setPreferredWidth(20);
					ScrollPane
							.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					// barra de rolagem horizontal sempre oculta
					ScrollPane
							.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				}

				{
					PanelExibir = new JPanel();
					PanelExibir.setLayout(null);
					PanelTotal.add(PanelExibir);
					PanelTotal.add(ScrollPane);
					{
						btSair = new JButton();
						PanelTotal.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/door_out.png")));
						btSair.setBounds(20, 421, 74, 24);
						btSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();

							}
						});
					}
					{
						btCadastrar = new JButton();
						PanelTotal.add(btCadastrar);
						btCadastrar.setText("Relatório");
						btCadastrar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/page_white_stack.png")));
						btCadastrar.setBounds(460, 421, 95, 24);
						btCadastrar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if ((tfDtInicial.getText().equals("") && ((tfDtFinal
										.getText().equals(""))))
										&& ((!tfNmCliente.getText().equals("")))) {
									System.out
											.println("Passou no AddVendaPorNome()");
									emiteRelatorioNome();
								}

								if ((!tfDtFinal.getText().equals(""))
										&& (!tfDtInicial.getText().equals(""))
										&& (!tfNmCliente.getText().equals(""))) {
									System.out.println("Entrou if correto!!");
									emitirRalatorioNomeData();

								}

								if ((tfNmCliente.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))) {
									System.out
											.println("Passou no AddVendaPorData()");
									emitirRalatorioData();
								}
							}
						});
						// ActionListener nesse botao chamará os métodos
						// dependendo dos campos preenchidos na interface; Esses
						// métodos estarão em um local separado no final do
						// codigo
					}
					{
						btCancelar = new JButton();
						PanelTotal.add(btCancelar);
						btCancelar.setText("Cancelar");
						btCancelar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/Retiraar.png")));
						btCancelar.setBounds(561, 421, 101, 24);
						btCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evento) {
								tfDtFinal.setText("");
								tfDtInicial.setText("");
								tfNmCliente.setText("");
								CheckBoxAndamento.setSelected(false);
								CheckBoxCliente.setSelected(false);
								CheckBoxInicial.setSelected(false);
								CheckBoxPago.setSelected(false);
								tfCdCliente.setText("");
							}
						});
					}
					PanelExibir.setBounds(20, 78, 377, 98);
					PanelExibir.setBorder(BorderFactory
							.createTitledBorder("Exibir Vendas"));
					PanelExibir.add(CheckBoxPago);
					PanelExibir.add(CheckBoxAndamento);
					PanelExibir.add(CheckBoxInicial);
					PanelExibir.add(CheckBoxCliente);
					PanelExibir.add(tfNmCliente);
					tfNmCliente.setEnabled(false);
					PanelExibir.add(btPesquisaCliente);
					btPesquisaCliente.setEnabled(false);
					{
						tfCdCliente = new JTextField();
						PanelExibir.add(tfCdCliente);
						tfCdCliente.setBounds(95, 30, 37, 20);
						tfCdCliente.setEnabled(false);
					}
				}

			}
			pack();
			this.setSize(678, 488);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ListarRelatorioNome() {
		atualizaGridNome(Long.parseLong(tfCdCliente.getText()));
	}

	private void atualizaGridNome(Long id) {
		List<Venda_ItensVo> venda_itens = null;
		viBo = new Venda_ItensBo();
		try {
			venda_itens = viBo.buscaPorNmCliente(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableRelatorioModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableRelatorioModel.addRow(vendaITEM.AtualizaTable());
		}
	}

	private void ListarRelatorioData() {
		Date dataInicio;
		Date dataFinal;
		// convertendo a data do textField em data.util para chamar o
		// método
		// de busca por data no BD
		viBo = new Venda_ItensBo();
		dataInicio = viBo.converteData(tfDtInicial.getText());
		dataFinal = viBo.converteData(tfDtFinal.getText());
		atualizaGrid(dataInicio, dataFinal);

	}

	private void atualizaGrid(Date data1, Date data2) {
		List<Venda_ItensVo> venda_itens = null;
		viBo = new Venda_ItensBo();
		try {
			venda_itens = viBo.buscaPorData(data1, data2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableRelatorioModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableRelatorioModel.addRow(vendaITEM.AtualizaTable());
		}
	}

	private void ListarRelatorioNomeData() {
		Date dataInicio;
		Date dataFinal;
		viBo = new Venda_ItensBo();
		dataInicio = viBo.converteData(tfDtInicial.getText());
		dataFinal = viBo.converteData(tfDtFinal.getText());
		atualizaGridNomeData(tfNmCliente.getText(), dataInicio, dataFinal);
	}

	private void atualizaGridNomeData(String nome, Date data1, Date data2) {
		List<Venda_ItensVo> venda_itens = null;
		viBo = new Venda_ItensBo();
		try {
			venda_itens = viBo.buscaPorNomeData(nome, data1, data2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableRelatorioModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableRelatorioModel.addRow(vendaITEM.AtualizaTable());
		}
	}

	// este é apenas o primeiro ActionListener do botao para gerar relatorio
	// por data:
	private void emitirRalatorioData() {
		String reportSource = "C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\Relatorio_Venda_ItensOK.jasper";

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			Date dataInicial, dataFinal;
			viBo = new Venda_ItensBo();

			try {
				RviDao = new RelatorioVenda_ItensDao(
						ConnectionFactory.getConnection());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dataInicial = viBo.converteData(tfDtInicial.getText());
			dataFinal = viBo.converteData(tfDtFinal.getText());
			List<RelatorioVenda_ItensVo> listRelaVo = null;

			try {
				listRelaVo = RviDao.buscaPorData(dataInicial, dataFinal);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(
					listRelaVo);

			JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(reportSource, params,
					jrBean);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

	private void emitirRalatorioNomeData() {
		String reportSource = "C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\Relatorio_Venda_ItensOK.jasper";

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			Date dataInicial, dataFinal;
			viBo = new Venda_ItensBo();

			try {
				RviDao = new RelatorioVenda_ItensDao(
						ConnectionFactory.getConnection());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			dataInicial = viBo.converteData(tfDtInicial.getText());
			dataFinal = viBo.converteData(tfDtFinal.getText());
			List<RelatorioVenda_ItensVo> listRelaVo = null;

			try {
				listRelaVo = RviDao.buscaPorNomeData(tfNmCliente.getText(),
						dataInicial, dataFinal);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(
					listRelaVo);

			JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(reportSource, params,
					jrBean);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

	private void emiteRelatorioNome() {
		String reportSource = "C:\\Users\\Samyla\\Documents\\Samyla INF-3\\LP III\\Relatorio_Venda_ItensOK.jasper";

		Map<String, Object> params = new HashMap<String, Object>();

		try {
			viBo = new Venda_ItensBo();
			System.out.println("ENTROU RELATORIO POR NOME");

			try {
				RviDao = new RelatorioVenda_ItensDao(
						ConnectionFactory.getConnection());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			List<RelatorioVenda_ItensVo> listRelaVo = null;

			try {
				// listRelaVo = RviDao
				// .buscaPorNmCliente(tfNmCliente.getText());
				// alterei para a consulta por código (é melhor porque nao
				// causa ambiguidade)
				listRelaVo = RviDao.buscaPorCdCliente(Long
						.parseLong(tfCdCliente.getText()));
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(
					listRelaVo);

			JasperPrint jasperPrint;
			jasperPrint = JasperFillManager.fillReport(reportSource, params,
					jrBean);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

	// aqui estará os métodos do ActionListener do botao "Relatorio"
}
