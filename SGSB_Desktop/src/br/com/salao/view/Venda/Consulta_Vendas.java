package br.com.salao.view.Venda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import br.com.salao.bo.VendaBo;
import br.com.salao.bo.Venda_ItensBo;
import br.com.salao.vo.VendaVo;
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
public class Consulta_Vendas extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JLabel lbDtInicio;
	private JButton btSair;
	private JTable TableVendas;
	private JScrollPane ScrollPaneVendas;
	private JButton btPesquisa;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JLabel CdCliente;
	public static JTextField tfCdCliente;
	private JButton btAlterar;
	private JTextField tfDtInicio;
	private JPanel PanelConsulta;
	private JLabel lbTitulo;
	private DefaultTableModel TableModel;
	private JButton btExcluir;
	private JButton btCliente;
	private JLabel lbCliente;
	public static JTextField tfCliente;
	private Venda_ItensBo viBo;
	private Venda_ItensVo viVo;
	private VendaBo vBo;
	private VendaVo vVo;

	List<Venda_ItensVo> lista = new ArrayList<Venda_ItensVo>();

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
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Consulta_Vendas inst = new Consulta_Vendas();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Consulta_Vendas() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setPreferredSize(new java.awt.Dimension(476, 376));
				this.setIconImage(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/document_valid.png")).getImage());
				this.setTitle("Consultar Vendas");
				{
					lbTitulo = new JLabel();
					PanelTotal.add(lbTitulo);
					lbTitulo.setText("Consultar Vendas");
					lbTitulo.setBounds(180, 26, 251, 40);
					lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 26));
					lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/document_valid.png")));
				}
				{
					PanelConsulta = new JPanel();
					PanelTotal.add(PanelConsulta);
					PanelConsulta.setLayout(null);
					PanelConsulta.setBounds(98, 72, 400, 112);
					PanelConsulta.setBorder(BorderFactory
							.createTitledBorder("Consulta"));
					{
						lbDtInicio = new JLabel();
						PanelConsulta.add(lbDtInicio);
						lbDtInicio.setText("Data Início");
						lbDtInicio.setBounds(16, 64, 51, 14);
					}
					{
						tfDtInicio = new JTextField();
						PanelConsulta.add(tfDtInicio);
						tfDtInicio.setBounds(16, 78, 122, 20);
					}
					{
						lbDtFinal = new JLabel();
						PanelConsulta.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setBounds(150, 64, 48, 14);
					}
					{
						tfDtFinal = new JTextField();
						PanelConsulta.add(tfDtFinal);
						tfDtFinal.setBounds(148, 78, 118, 20);
					}

					{
						btPesquisa = new JButton();
						PanelConsulta.add(btPesquisa);
						btPesquisa.setText("Consultar");
						btPesquisa.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btPesquisa.setBounds(275, 76, 99, 25);
						btPesquisa.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if ((tfDtInicio.getText().equals("") && ((tfDtFinal
										.getText().equals(""))))
										&& ((!tfCliente.getText().equals("")))) {
									System.out
											.println("Passou no AddVendaPorNome()");
									AddVendaPorNome();
								}

								if ((!tfDtFinal.getText().equals(""))
										&& (!tfDtInicio.getText().equals(""))
										&& (!tfCliente.getText().equals(""))) {
									System.out.println("Entrou if correto!!");
									AddVendaPorNomeData();

								}

								if ((tfCliente.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))
										&& (!tfDtFinal.getText().equals(""))) {
									System.out
											.println("Passou no AddVendaPorData()");
									AddVendaPorData();
								}

							}
						});

						// Para o filtro por data:
						// if ((tfDtInicial.getText().equals(""))
						// || (tfDtInicial.getText().equals(""))) {
						// btCadastrar
						// .addActionListener(new emitirRalatorioData());
						// } else {
						// btCadastrar
						// .addActionListener(new emiteRelatorioNome());
						// }

					}
					{
						tfCliente = new JTextField();
						PanelConsulta.add(tfCliente);
						tfCliente.setBounds(88, 35, 250, 20);
					}
					{
						lbCliente = new JLabel();
						PanelConsulta.add(lbCliente);
						lbCliente.setText("Cliente");
						lbCliente.setBounds(88, 23, 33, 12);
					}
					{
						btCliente = new JButton();
						PanelConsulta.add(btCliente);
						btCliente.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/user (2).png")));
						btCliente.setBounds(344, 33, 24, 24);
						btCliente.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								Selecionar_Cliente inst = new Selecionar_Cliente();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}
						});
					}
					{
						tfCdCliente = new JTextField();
						PanelConsulta.add(tfCdCliente);
						tfCdCliente.setBounds(16, 35, 64, 20);
						tfCdCliente.setEditable(false);
					}
					{
						CdCliente = new JLabel();
						PanelConsulta.add(CdCliente);
						CdCliente.setText("Código");
						CdCliente.setBounds(16, 22, 33, 14);
					}
				}
				{
					ScrollPaneVendas = new JScrollPane();
					PanelTotal.add(ScrollPaneVendas);
					ScrollPaneVendas.setBounds(10, 190, 591, 239);
					{

						String colunas[] = { "Código Venda", "Data da Venda",
								"Cliente", "Código Item", "Item", "Total" };
						TableModel = new DefaultTableModel(colunas, 0);

						TableVendas = new JTable();
						ScrollPaneVendas.setViewportView(TableVendas);
						TableVendas.setModel(TableModel);

						TableVendas.getColumnModel().getColumn(0)
								.setPreferredWidth(15);
						TableVendas.getColumnModel().getColumn(1)
								.setPreferredWidth(15);
						TableVendas.getColumnModel().getColumn(2)
								.setPreferredWidth(40);
						TableVendas.getColumnModel().getColumn(3)
								.setPreferredWidth(10);
						TableVendas.getColumnModel().getColumn(4)
								.setPreferredWidth(15);
						TableVendas.getColumnModel().getColumn(5)
								.setPreferredWidth(20);
						ScrollPaneVendas
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre oculta
						ScrollPaneVendas
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					}
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(10, 442, 71, 24);
					btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();

						}
					});
				}
				{
					btAlterar = new JButton();
					PanelTotal.add(btAlterar);
					btAlterar.setText("Alterar");
					btAlterar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/alterar.png")));
					btAlterar.setBounds(516, 442, 85, 24);
					btAlterar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String senha;
							senha = JOptionPane
									.showInputDialog(null,
											"Digite o código de segurança para alterar esta venda:");
							if (senha.equals("samyla")) {
								Alterar_Venda inst = new Alterar_Venda();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}

						}
					});
				}
				{
					btExcluir = new JButton();
					PanelTotal.add(btExcluir);
					btExcluir.setText("Excluir");
					btExcluir.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/AApagar.png")));
					btExcluir.setBounds(427, 442, 83, 24);
					btExcluir.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							String senha;

							if (TableVendas.getSelectedRow() < 0) {
								JOptionPane.showMessageDialog(null,
										"Selecione uma linha para excluir!");
							} else {
								senha = JOptionPane
										.showInputDialog(null,
												"Digite o código de confirmação para excluir essa venda:");
								if (senha.equals("samyla")) {

									viVo = new Venda_ItensVo();
									viBo = new Venda_ItensBo();
									String id;
									String idItem;
									long codigoVenda;
									long codigoItem;
									Object obj = TableVendas.getValueAt(
											TableVendas.getSelectedRow(), 0);
									Object ObjItem = TableVendas.getValueAt(
											TableVendas.getSelectedRow(), 3);
									id = String.valueOf(obj);
									codigoVenda = Integer.parseInt(id);
									idItem = String.valueOf(ObjItem);
									codigoItem = Integer.parseInt(idItem);

									try {
										viVo = viBo.DescobreVendaItens(
												codigoVenda, codigoItem);
									} catch (SQLException e) {
										e.printStackTrace();
									}
									try {
										System.out
												.println("Tela Consulta_Venda linha 322: Codigo da venda:"
														+ viVo.getVenda());
										System.out.println("Codigo Item:"
												+ viVo.getItem().getCdItem());

										viBo.removeVendaI(viVo.getItem()
												.getCdItem(), viVo.getVenda()
												.getCodigo());
									} catch (SQLException e) {
										e.printStackTrace();
									}
									TableModel.removeRow(TableVendas
											.getSelectedRow());

								} else {
									JOptionPane.showMessageDialog(null,
											"Senha incorreta!", "Erro",
											JOptionPane.ERROR_MESSAGE);
								}
							}

						}
					});
				}
			}
			this.setSize(626, 514);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void AddVendaPorNome() {
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
		TableModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableModel.addRow(vendaITEM.AtualizaTable());
		}
	}

	public void Mascara(String Mascara) {
		javax.swing.text.MaskFormatter data;
		try {
			data = new javax.swing.text.MaskFormatter("##/##/####");
			tfDtFinal = new javax.swing.JFormattedTextField(data);
			tfDtInicio = new javax.swing.JFormattedTextField(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void AddVendaPorData() {
		Date dataInicio;
		Date dataFinal;
		// convertendo a data do textField em data.util para chamar o método
		// de busca por data no BD
		viBo = new Venda_ItensBo();
		System.out.println("OOOOOOOOKKKK");
		dataInicio = viBo.converteData(tfDtInicio.getText());
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
		TableModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableModel.addRow(vendaITEM.AtualizaTable());
		}
	}

	private void AddVendaPorNomeData() {
		Date dataInicio;
		Date dataFinal;

		viBo = new Venda_ItensBo();
		dataInicio = viBo.converteData(tfDtInicio.getText());
		dataFinal = viBo.converteData(tfDtFinal.getText());
		atualizaGrid(tfCliente.getText(), dataInicio, dataFinal);
	}

	private void atualizaGrid(String nome, Date data1, Date data2) {
		List<Venda_ItensVo> venda_itens = null;
		viBo = new Venda_ItensBo();
		try {
			venda_itens = viBo.buscaPorNomeData(nome, data1, data2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (venda_itens != null) {
			for (Venda_ItensVo vendaITEM : venda_itens)
				TableModel.addRow(vendaITEM.AtualizaTable());
		}
	}

}
