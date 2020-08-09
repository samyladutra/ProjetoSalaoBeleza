package br.com.salao.view.Venda;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import br.com.salao.bo.ClienteBo;
import br.com.salao.bo.ItemBo;
import br.com.salao.bo.VendaBo;
import br.com.salao.bo.Venda_ItensBo;
import br.com.salao.view.Pagamento.Selecionar_Pagamento;
import br.com.salao.vo.Cliente;
import br.com.salao.vo.ItemVo;
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
public class Venda_Itens extends javax.swing.JFrame {
	private JPanel Panel;
	private JLabel lbItem;
	private JTextField tfCdItem;
	private JPanel PanelNome;
	private JLabel lbNmItem;
	private JButton btPesquisa;
	private JButton btCliente;
	private JLabel lbCliente;
	private JLabel lbasterisco;
	private JTextField tfData;
	private JComboBox ComboBoxStatus;
	private JLabel lbStatus;
	private JLabel lbData;
	private JLabel lbastData;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JLabel lbCodigoCli;
	private JButton btCancelar;
	private JButton btRealizaPagamento;
	private JLabel lbaster;
	private JLabel jLabel1;
	private JButton btAddItem;
	private JButton btRegistrar;
	private JTextField tfTotal;
	private JLabel lbTotal;
	private JToggleButton btRetira;
	private JScrollPane ScrollPane;
	private JLabel lbQuant;
	private JTextField tfQuant;
	private JLabel lbVenda;
	private DefaultTableModel TableModel;
	private JComboBox ComboBoxCliente;
	private JComboBox ComboBoxItem;
	private JButton btSair;
	private JTextField tfCdCliente;
	private JPanel PanelCliente;
	private JTable TableItens;
	// private VendaVo vendaVo;
	// private VendaBo vendaBo;
	// private Cliente clienteVo;
	private ClienteBo cBo;
	private ItemBo iBo;
	private JButton btAddTabela;
	private ItemVo iVo;
	private Venda_ItensVo viVO;
	private Venda_ItensBo viBO;
	private VendaVo vendaVo;
	private VendaBo vBo;
	private double subTotal;
	private double total = 0;
	private int Quantidade = 0;

	List<Venda_ItensVo> listVendaItem = new ArrayList<Venda_ItensVo>();

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
				Venda_Itens inst = new Venda_Itens();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Venda_Itens() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Venda");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/total_plan_cost1.png")).getImage());
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				Panel.setBounds(0, 0, 593, 432);
				Panel.setPreferredSize(new java.awt.Dimension(597, 514));
				{
					lbVenda = new JLabel();
					Panel.add(lbVenda);
					lbVenda.setText("Venda");
					lbVenda.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/total_plan_cost1.png")));
					lbVenda.setFont(new java.awt.Font("Tahoma", 0, 26));
					lbVenda.setBounds(264, 18, 121, 43);
				}
				{
					PanelNome = new JPanel();
					Panel.add(PanelNome);
					PanelNome.setBorder(BorderFactory.createTitledBorder(null,
							"Ítens Vendidos", TitledBorder.LEADING,
							TitledBorder.DEFAULT_POSITION));
					PanelNome.setLayout(null);
					PanelNome.setBounds(22, 198, 609, 246);
					{
						tfCdItem = new JTextField();
						PanelNome.add(tfCdItem);
						tfCdItem.setEditable(false);
						tfCdItem.setBounds(11, 44, 74, 20);
						// tfCdItem.setText(arg0);
					}
					{
						lbItem = new JLabel();
						PanelNome.add(lbItem);
						lbItem.setText("Código Ítem");
						lbItem.setBounds(11, 31, 78, 14);
					}
					{
						tfQuant = new JTextField();
						PanelNome.add(tfQuant);
						tfQuant.setBounds(420, 45, 69, 20);
						tfQuant.addKeyListener(new KeyListener() {

							@Override
							public void keyTyped(KeyEvent arg0) {
							}

							@Override
							public void keyReleased(KeyEvent arg0) {

							}

							@Override
							public void keyPressed(KeyEvent s) {
								if (s.getKeyCode() == 10) {
									addInTable();
								}
							}
						});
					}
					{
						lbQuant = new JLabel();
						PanelNome.add(lbQuant);
						lbQuant.setText("Quantidade");
						lbQuant.setBounds(420, 30, 56, 14);
					}
					{
						ScrollPane = new JScrollPane();
						PanelNome.add(ScrollPane);
						ScrollPane
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						ScrollPane
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						ScrollPane.setEnabled(false);
						ScrollPane.setBounds(14, 84, 549, 149);
						{

							String colunas[] = { "Item", "Quantidade", "Valor",
									"SubTotal" };
							TableModel = new DefaultTableModel(colunas, 0);

							TableItens = new JTable();
							ScrollPane.setViewportView(TableItens);
							TableItens.setModel(TableModel);

							TableItens.getColumnModel().getColumn(0)
									.setPreferredWidth(70);
							TableItens.getColumnModel().getColumn(1)
									.setPreferredWidth(35);
							TableItens.getColumnModel().getColumn(2)
									.setPreferredWidth(15);
						}
					}
					{
						lbNmItem = new JLabel();
						PanelNome.add(lbNmItem);
						lbNmItem.setText("Nome do Item");
						lbNmItem.setBounds(91, 30, 72, 14);
					}
					{
						btRetira = new JToggleButton();
						PanelNome.add(btRetira);
						btRetira.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/AApagar.png")));
						btRetira.setBounds(569, 84, 24, 23);
						btRetira.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// quantidade de linhas selecionadas na tabela
								if (TableItens.getSelectedRow() < 0) {
									JOptionPane
											.showMessageDialog(null,
													"Selecione uma linha para excluir!");
								} else {
									tfTotal.setText(String.valueOf(total
											- (Double
													.parseDouble((String) TableItens.getValueAt(
															TableItens
																	.getSelectedRow(),
															3)))));

									total = Double.parseDouble(tfTotal
											.getText());
									TableModel.removeRow(TableItens
											.getSelectedRow());
								}

							}
						});
					}
					{
						btAddItem = new JButton();
						PanelNome.add(btAddItem);
						btAddItem.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btAddItem.setBounds(328, 42, 87, 24);
						btAddItem.setText("Buscar");
						btAddItem.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								Selecionar_Item inst = new Selecionar_Item();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}
						});
					}
					{
						jLabel1 = new JLabel();
						PanelNome.add(jLabel1);
						jLabel1.setText("*");
						jLabel1.setForeground(new java.awt.Color(196, 0, 0));
						jLabel1.setBounds(160, 30, 12, 14);
					}
					{
						lbaster = new JLabel();
						PanelNome.add(lbaster);
						lbaster.setText("*");
						lbaster.setForeground(new java.awt.Color(196, 0, 0));
						lbaster.setBounds(479, 30, 10, 14);
					}
					{
						ComboBoxItem = new JComboBox();
						iBo = new ItemBo();

						List<ItemVo> item = iBo.ListaItem(); // adicionando a
																// lista
																// de servicos
																// no
																// combobox
						ComboBoxItem.addItem("");
						for (ItemVo i : item) {
							ComboBoxItem.addItem(i);
						}

						AutoCompleteDecorator.decorate(ComboBoxItem);
						ComboBoxItem.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (!ComboBoxItem.getSelectedItem().equals("")) {
									tfCdItem.setText(String
											.valueOf(((ItemVo) ComboBoxItem
													.getSelectedItem())
													.getCdItem()));
								} else {
									tfCdItem.setText("");
								}

							}
						});
						PanelNome.add(ComboBoxItem);
						ComboBoxItem.setBounds(91, 44, 230, 20);
						ComboBoxItem.setEditable(true);
					}
					{
						btAddTabela = new JButton();
						PanelNome.add(btAddTabela);
						btAddTabela.setText("Adicionar");
						btAddTabela.setBounds(499, 43, 99, 24);
						btAddTabela.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/Maaiis.png")));
						btAddTabela.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								addInTable();
							}
						});
					}
				}
				{
					btCancelar = new JButton();
					Panel.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/retiraar.png")));
					btCancelar.setBounds(459, 467, 95, 24);
					btCancelar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ComboBoxCliente.setSelectedItem("");
							ComboBoxItem.setSelectedItem("");
							tfQuant.setText("");
							TableModel.setColumnCount(0);
							tfTotal.setText("");
							subTotal = 0;
							total = 0;
						}
					});
				}
				{
					btRealizaPagamento = new JButton();
					Panel.add(btRealizaPagamento);
					btRealizaPagamento.setText("Realizar Pagamento");
					btRealizaPagamento.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/coins_hand.png")));
					btRealizaPagamento.setBounds(201, 467, 147, 24);
					btRealizaPagamento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Selecionar_Pagamento inst = new Selecionar_Pagamento();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
						}
					});
				}
				{
					btRegistrar = new JButton();
					Panel.add(btRegistrar);
					btRegistrar.setText("Registrar");
					btRegistrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Salvaar.png")));
					btRegistrar.setBounds(354, 467, 99, 24);
					btRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							Date data;
							viBO = new Venda_ItensBo();
							data = viBO.converteData(tfData.getText());

							vendaVo = new VendaVo();
							vendaVo = new VendaVo(
									Long.parseLong(tfCodigo.getText()),
									data,
									Double.parseDouble(tfTotal.getText()),
									(Cliente) ComboBoxCliente.getSelectedItem(),
									String.valueOf(ComboBoxStatus
											.getSelectedItem()));

							try {
								vBo = new VendaBo();
								vBo.adiciona(vendaVo);
							} catch (SQLException e) {
								e.printStackTrace();
							}

							for (int i = 0; i < TableItens.getModel()
									.getRowCount(); i++) {
								// adicionando a venda de itens em uma lista
								// para adicionar separadamente no banco de
								// dados
								listVendaItem.get(i).setVenda(vendaVo);
								Quantidade = listVendaItem.get(i)
										.getQuantItem();

								try {
									iBo = new ItemBo();
									iVo = new ItemVo();
									viBO.adicionaVendaItem(listVendaItem.get(i));
									iVo = iBo.DescobreItem(listVendaItem.get(i)
											.getItem().getCdItem());
									iVo.setQuantidade(iVo.getQuantidade()
											- Quantidade);
									iBo.alterarItem(iVo);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								Quantidade = 0;
							}

							JOptionPane.showMessageDialog(null,
									"Venda de ítens registrada!");
							// alterar a quantidade de produtos "em estoque":

							ComboBoxCliente.setSelectedItem("");
							ComboBoxItem.setSelectedItem("");
							try {
								tfCodigo.setText(String.valueOf(vBo.ProximoId()));
							} catch (SQLException e) {
								e.printStackTrace();
							}
							TableModel.setColumnCount(0);
							tfTotal.setText("");
							total = 0;
							subTotal = 0;
						}
					});
				}
				{
					tfTotal = new JTextField();
					Panel.add(tfTotal);
					tfTotal.setEditable(false);
					tfTotal.setBounds(26, 468, 85, 22);
				}
				{
					lbTotal = new JLabel();
					Panel.add(lbTotal);
					lbTotal.setText("Total");
					lbTotal.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/total_plan_cost.png")));
					lbTotal.setBounds(26, 450, 57, 18);
				}
				{
					PanelCliente = new JPanel();
					Panel.add(PanelCliente);
					PanelCliente.setBounds(118, 60, 445, 127);
					PanelCliente.setLayout(null);
					PanelCliente.setBorder(BorderFactory
							.createTitledBorder("Dados da Venda"));
					{
						tfCdCliente = new JTextField();
						PanelCliente.add(tfCdCliente);
						tfCdCliente.setEditable(false);
						tfCdCliente.setBounds(28, 90, 79, 20);

					}
					{
						lbCodigoCli = new JLabel();
						PanelCliente.add(lbCodigoCli);
						lbCodigoCli.setText("Código Cliente");
						lbCodigoCli.setBounds(28, 76, 69, 14);
					}
					{
						lbCodigo = new JLabel();
						PanelCliente.add(lbCodigo);
						lbCodigo.setText("Código Venda");
						lbCodigo.setBounds(28, 31, 66, 14);
					}
					{
						tfCodigo = new JTextField();
						PanelCliente.add(tfCodigo);
						tfCodigo.setEditable(false);
						tfCodigo.setBounds(28, 45, 79, 20);
						VendaBo vBo = new VendaBo();
						long id;
						id = vBo.ProximoId();
						tfCodigo.setText(String.valueOf(id));
					}
					{
						lbastData = new JLabel();
						PanelCliente.add(lbastData);
						lbastData.setText("*");
						lbastData.setForeground(new java.awt.Color(196, 0, 0));
						lbastData.setBounds(190, 31, 11, 14);
					}
					{
						lbData = new JLabel();
						PanelCliente.add(lbData);
						lbData.setText("Data da Venda");
						lbData.setBounds(117, 31, 71, 14);
					}
					{
						lbStatus = new JLabel();
						PanelCliente.add(lbStatus);
						lbStatus.setText("Status");
						lbStatus.setBounds(259, 31, 31, 14);
					}
					{
						ComboBoxModel ComboBoxStatusModel = new DefaultComboBoxModel(
								new String[] { "Inicial", "Em andamento",
										"Pago" });
						ComboBoxStatus = new JComboBox();
						PanelCliente.add(ComboBoxStatus);
						ComboBoxStatus.setModel(ComboBoxStatusModel);
						ComboBoxStatus.setBounds(258, 45, 164, 20);
					}
					{
						tfData = new JTextField();
						PanelCliente.add(tfData);
						tfData.setBounds(117, 45, 131, 20);
						tfData.setEditable(false);
						viBO = new Venda_ItensBo();
						tfData.setText(viBO.getDateTime());
					}

					{
						lbasterisco = new JLabel();
						PanelCliente.add(lbasterisco);
						lbasterisco.setText("*");
						lbasterisco
								.setForeground(new java.awt.Color(196, 0, 0));
						lbasterisco.setBounds(198, 76, 13, 14);
					}
					{
						lbCliente = new JLabel();
						PanelCliente.add(lbCliente);
						lbCliente.setText("Nome do Cliente");
						lbCliente.setBounds(117, 78, 82, 10);
					}
					{
						btCliente = new JButton();
						PanelCliente.add(btCliente);
						btCliente.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/user_add16.png")));
						btCliente.setBounds(400, 87, 22, 23);
						btCliente.addActionListener(new AddCliente());
					}
					{
						btPesquisa = new JButton();
						PanelCliente.add(btPesquisa);
						btPesquisa.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btPesquisa.setBounds(371, 87, 25, 23);
						btPesquisa.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								Selecionar_Cliente inst = new Selecionar_Cliente();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);

							}
						});
					}
					{

						ComboBoxCliente = new JComboBox();
						cBo = new ClienteBo();
						// criando uma lista de objetos do tipo cliente:
						List<Cliente> cli = cBo.Lista();

						// para nao aparecer nenhum objeto ja selecionado:
						ComboBoxCliente.addItem("");

						// adicionando a lista de clientes no combobox
						// c é um objeto do tipo cliente e cli é o nome da
						// lista. Adicionar o objeto do tipo c que esta na lista
						// cli no combobox:
						for (Cliente c : cli) {
							ComboBoxCliente.addItem(c);
						}
						// Para filtrar o nome digitado no combobox: (importado
						// pela biblioteca):
						AutoCompleteDecorator.decorate(ComboBoxCliente);

						ComboBoxCliente.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (!ComboBoxCliente.getSelectedItem().equals(
										"")) {
									tfCdCliente.setText(String
											.valueOf(((Cliente) ComboBoxCliente
													.getSelectedItem())
													.getCodigo()));
								} else {
									tfCdCliente.setText("");
								}

							}
						});
						PanelCliente.add(ComboBoxCliente);
						ComboBoxCliente.setBounds(117, 90, 248, 20);
						ComboBoxCliente.setEditable(true);

					}
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(560, 467, 71, 24);
					btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
			}
			pack();
			this.setSize(653, 547);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class AddCliente implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Cliente c = new Cliente();
			c = cBo.ChamaTelaInserir();
			ComboBoxCliente.addItem(c);
		}
	}

	private void adicionaItensVenda(Venda_ItensVo itensVenda) {
		TableModel.addRow(itensVenda.toArray());

		// adicionando a venda_itens em uma lista para ser adicionada na venda
		// posteriormente
		listVendaItem.add(itensVenda);
	}

	private void addInTable() {

		iVo = new ItemVo();
		iVo = (ItemVo) ComboBoxItem.getSelectedItem();
		ItemVo itemVo = new ItemVo();
		try {
			itemVo = iBo.DescobreItem(iVo.getCdItem());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// bubTotal:
		subTotal = iVo.getPreco() * Double.parseDouble(tfQuant.getText());
		tfTotal.setText(String.valueOf(subTotal + total));

		viVO = new Venda_ItensVo(vendaVo, iVo, subTotal,
				Integer.parseInt(tfQuant.getText()), iVo.getPreco());

		System.out.println("SUB-TOTAL:" + viVO.getVlTotal());

		viBO = new Venda_ItensBo();
		String mensagem;
		mensagem = viBO.Verifica(viVO);
		if (mensagem.equals("")) {
			if (itemVo.getTipo().equals("Produto")) {

				// se for produto e se nao tiver
				// quantidade suficiente no estoque
				// emite a mensagem de erro:
				if (Integer.parseInt(tfQuant.getText()) > iVo.getQuantidade()) {
					JOptionPane
							.showMessageDialog(
									null,
									"Este produto não possui quantidade suficiente  \n"
											+ " no estoque, portanto não pode ser vendido!",
									"Produto em falta",
									JOptionPane.ERROR_MESSAGE);

				} else {

					// se houver quantidade suficiente
					// subtrai da quantidade que esta
					// sendo comprada:
					Quantidade = Integer.parseInt(tfQuant.getText());
					iVo.setQuantidade(iVo.getQuantidade() - Quantidade);

					// bubTotal:
					subTotal = iVo.getPreco()
							* Double.parseDouble(tfQuant.getText());
					tfTotal.setText(String.valueOf(subTotal + total));

					adicionaItensVenda(viVO);

					tfCdItem.setText("");
					tfQuant.setText("");
					ComboBoxItem.setSelectedItem("");
					total = Double.parseDouble(tfTotal.getText());
				}
			} else {
				if (iVo.getTipo().equals("Servico")) {
					// bubTotal:
					subTotal = iVo.getPreco()
							* Double.parseDouble(tfQuant.getText());
					tfTotal.setText(String.valueOf(subTotal + total));

					adicionaItensVenda(viVO);

					tfCdItem.setText("");
					tfQuant.setText("");
					ComboBoxItem.setSelectedItem("");
					total = Double.parseDouble(tfTotal.getText());
				}

			}

		} else {
			JOptionPane.showMessageDialog(null, mensagem);
		}

	}

}
