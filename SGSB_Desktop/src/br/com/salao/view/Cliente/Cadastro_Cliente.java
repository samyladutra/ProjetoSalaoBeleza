package br.com.salao.view.Cliente;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import br.com.salao.dao.CidadeDAO;
import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Pagina_Inicial_correta;
import br.com.salao.view.Cidade.Cadastro_Cidade;
import br.com.salao.vo.Cidade;
import br.com.salao.vo.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class Cadastro_Cliente extends javax.swing.JDialog {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DefaultTableModel TableModel;
	private JLabel lbBairro;
	private JButton btListar;
	private JRadioButton radioButtonF;
	private JRadioButton radioButtonM;
	private ButtonGroup buttonGroupSexo;
	private JButton btPesquisaCid;
	private JButton btSair;
	private JButton btVoltar;
	private JButton btConsultar;
	private JLabel lbCdCliente;
	private JButton btAlterar;
	private JButton btExcluir;
	private JTable TableCliente;
	private JScrollPane ScrollPane1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JPanel Panel2;
	private JButton btCadastrar;
	private JButton btCancelar;
	private JTextField tfComplemento;
	private JLabel lbComplemento;
	private JTextField tfNum;
	private JLabel lbNum;
	private JTextField tfRua;
	private JComboBox ComboboxCidade;
	private JLabel lbRua;
	private JTextField tfBairro;
	private JLabel lbCidade;
	private JTextField tfEmail;
	private JLabel lbEmail;
	private JTextField tfCPF;
	private JLabel lbCPF;
	private JPanel Panel;
	private JPanel jPanel1;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JLabel lbTelefone;
	private JLabel lbSexo;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JTabbedPane jTabbedPane1;
	private JLabel lbCadastro;
	private ClienteDAO dao;
	private Cliente cliente;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public Cadastro_Cliente(Connection conexao) {
		super();
		try {
			dao = new ClienteDAO(conexao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Cadastro de Cliente");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/user_add.png")).getImage());
			this.setResizable(false);
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				Panel.setPreferredSize(new java.awt.Dimension(64, -46));
				{
					lbCadastro = new JLabel();
					Panel.add(lbCadastro);
					lbCadastro.setText("Cadastro de Cliente");
					lbCadastro.setFont(new java.awt.Font("Lucida Sans", 0, 24));
					lbCadastro.setBounds(156, 49, 254, 45);
				}
				{
					jTabbedPane1 = new JTabbedPane();
					Panel.add(jTabbedPane1);
					jTabbedPane1.setBounds(16, 105, 459, 275);
					{
						jPanel1 = new JPanel();
						jTabbedPane1.addTab("Cadastrar", null, jPanel1, null);
						jPanel1.setPreferredSize(new java.awt.Dimension(64, 15));
						jPanel1.setLayout(null);
						{
							lbCodigo = new JLabel();
							jPanel1.add(lbCodigo);
							lbCodigo.setText("Código");
							lbCodigo.setBounds(10, 11, 53, 14);
						}
						{
							tfCodigo = new JTextField();
							jPanel1.add(tfCodigo);
							tfCodigo.setEnabled(false);
							tfCodigo.setBounds(10, 25, 53, 20);
							try {
								long id = dao.getProximoId();
								tfCodigo.setText(Long.toString(id));
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						{
							lbNome = new JLabel();
							jPanel1.add(lbNome);
							lbNome.setText("Nome");
							lbNome.setBounds(73, 11, 73, 14);
						}
						{
							tfNome = new JTextField();
							jPanel1.add(tfNome);
							tfNome.setBounds(73, 25, 273, 20);
						}
						radioButtonM = new JRadioButton();
						jPanel1.add(radioButtonM);
						radioButtonM.setText("M");
						radioButtonM.setBounds(407, 24, 33, 23);

						radioButtonF = new JRadioButton();
						jPanel1.add(radioButtonF);
						radioButtonF.setText("F");
						radioButtonF.setBounds(361, 24, 31, 23);

						buttonGroupSexo = new ButtonGroup();

						buttonGroupSexo.add(radioButtonM);
						buttonGroupSexo.add(radioButtonF);
						{
							lbSexo = new JLabel();
							jPanel1.add(lbSexo);
							lbSexo.setText("Sexo");
							lbSexo.setBounds(361, 11, 65, 14);
						}
						{
							lbTelefone = new JLabel();
							jPanel1.add(lbTelefone);
							lbTelefone.setText("Telefone");
							lbTelefone.setBounds(10, 62, 84, 14);
						}
						{
							tfTelefone = new JTextField();
							jPanel1.add(tfTelefone);
							tfTelefone.setBounds(10, 76, 104, 20);
						}
						{
							lbCPF = new JLabel();
							jPanel1.add(lbCPF);
							lbCPF.setText("CPF");
							lbCPF.setBounds(129, 62, 29, 14);
						}
						{
							tfCPF = new JTextField();
							jPanel1.add(tfCPF);
							tfCPF.setBounds(124, 76, 102, 20);

						}

						{
							lbEmail = new JLabel();
							jPanel1.add(lbEmail);
							lbEmail.setText("Email");
							lbEmail.setBounds(236, 62, 88, 14);
						}
						{
							tfEmail = new JTextField();
							jPanel1.add(tfEmail);
							tfEmail.setBounds(236, 76, 204, 20);
						}
						{
							lbCidade = new JLabel();
							jPanel1.add(lbCidade);
							lbCidade.setText("Cidade");
							lbCidade.setBounds(236, 107, 99, 14);
						}
						{
							lbBairro = new JLabel();
							jPanel1.add(lbBairro);
							lbBairro.setText("Bairro");
							lbBairro.setBounds(10, 108, 61, 14);
						}
						{
							tfBairro = new JTextField();
							jPanel1.add(tfBairro);
							tfBairro.setBounds(10, 121, 215, 20);
						}
						{
							lbRua = new JLabel();
							jPanel1.add(lbRua);
							lbRua.setText("Rua");
							lbRua.setBounds(10, 159, 38, 14);
						}
						{
							tfRua = new JTextField();
							jPanel1.add(tfRua);
							tfRua.setBounds(10, 173, 216, 20);
						}
						{
							lbNum = new JLabel();
							jPanel1.add(lbNum);
							lbNum.setText("Numero");
							lbNum.setBounds(243, 159, 47, 14);
						}
						{
							tfNum = new JTextField();
							jPanel1.add(tfNum);
							tfNum.setBounds(243, 173, 47, 20);
						}
						{
							lbComplemento = new JLabel();
							jPanel1.add(lbComplemento);
							lbComplemento.setText("Complemento");
							lbComplemento.setBounds(304, 159, 65, 14);
						}
						{
							tfComplemento = new JTextField();
							jPanel1.add(tfComplemento);
							tfComplemento.setBounds(304, 173, 136, 20);
						}
						{
							btCancelar = new JButton();
							jPanel1.add(btCancelar);
							btCancelar.setText("Cancelar");
							btCancelar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Retiraar.png")));
							btCancelar.setBounds(331, 211, 109, 25);
							btCancelar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evento) {
									dispose();
								}

							});
						}
						{
							btCadastrar = new JButton();
							jPanel1.add(btCadastrar);
							btCadastrar.setText("Cadastrar");
							btCadastrar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Salvaar.png")));
							btCadastrar.setBounds(214, 213, 108, 24);
							btCadastrar.addActionListener(new ActionListener() {

								public void actionPerformed(ActionEvent evento) {

									String sexo = null;
									if (radioButtonF.isSelected()) {
										sexo = "F";
									} else {
										if (radioButtonM.isSelected()) {
											sexo = "M";
										}
									}

									if ((!tfNome.getText().equalsIgnoreCase(""))
											&& (!tfTelefone.getText()
													.equalsIgnoreCase(""))
											&& (!tfCPF.getText()
													.equalsIgnoreCase(""))
											&& (!tfEmail.getText()
													.equalsIgnoreCase(""))
											&& (!tfBairro.getText()
													.equalsIgnoreCase(""))
											&& (!tfRua.getText()
													.equalsIgnoreCase(""))
											&& (!tfNum.getText()
													.equalsIgnoreCase(""))
											&& (!tfComplemento.getText()
													.equalsIgnoreCase(""))) {
										cliente = new Cliente(Long
												.parseLong(tfCodigo.getText()),
												tfNome.getText(), sexo, Integer
														.parseInt(tfTelefone
																.getText()),
												Integer.parseInt(tfCPF
														.getText()), tfEmail
														.getText(),
												(Cidade) ComboboxCidade
														.getSelectedItem(),
												tfBairro.getText(), tfRua
														.getText(), Integer
														.parseInt(tfNum
																.getText()),
												tfComplemento.getText());
										try {
											long id1 = dao.getProximoId();
											tfCodigo.setText(Long
													.toString(id1 + 1));
											dao.adiciona(cliente);

										} catch (SQLException e2) {
											// TODO Auto-generated catch block
											e2.printStackTrace();
										}
										atualizaGrid();
										// se a verificação está ok, entao
										// insira o cliente e atulize a tebela
										JOptionPane
												.showMessageDialog(null,
														"Cliente cadastrado com sucesso!");
										tfNome.setText("");
										tfBairro.setText("");
										tfComplemento.setText("");
										tfNum.setText("");
										tfCPF.setText("");
										tfRua.setText("");
										tfTelefone.setText("");
										tfEmail.setText("");

									} else {
										JOptionPane
												.showMessageDialog(
														null,
														"Campos não preenchidos corretamente!",
														"Erro",
														JOptionPane.ERROR_MESSAGE);
									}

								}

								/*
								 * btExibir.addActionListener(new
								 * ActionListener() { public void
								 * actionPerformed(ActionEvent arg0) {
								 * atualizaGrid(); } });
								 */
							});

						}
						{
							btPesquisaCid = new JButton();
							jPanel1.add(btPesquisaCid);
							btPesquisaCid.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/building_add16x16.png")));
							btPesquisaCid.setBounds(418, 117, 26, 24);
							btPesquisaCid
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent evento) {
											Cadastro_Cidade cid = new Cadastro_Cidade(
													ConnectionFactory
															.getConnection());
											cid.setLocationRelativeTo(null);
											cid.setVisible(true);
											dispose();
											Cadastro_Cliente cc = new Cadastro_Cliente(
													ConnectionFactory
															.getConnection());
											cc.setLocationRelativeTo(null);
											cc.setVisible(true);

										}
									});
						}
						{
							CidadeDAO dao = new CidadeDAO(
									ConnectionFactory.getConnection());
							ComboboxCidade = new JComboBox();
							// pegando uma lista de cidade
							List<Cidade> cids = dao.getLista();

							for (Cidade c : cids)
								ComboboxCidade.addItem(c);

							jPanel1.add(ComboboxCidade);
							// ComboboxCidade.setModel(ComboboxCidadeModel);
							ComboboxCidade.setBounds(235, 121, 173, 20);
						}
					}
					{
						Panel2 = new JPanel();
						jTabbedPane1.addTab("Alterar/ Excluir", null, Panel2,
								null);
						Panel2.setLayout(null);
						Panel2.setPreferredSize(new java.awt.Dimension(35, 10));
						{
							jLabel2 = new JLabel();
							Panel2.add(jLabel2);
							jLabel2.setText("Nome");
							jLabel2.setBounds(10, 10, 58, 16);
						}
						{
							ScrollPane1 = new JScrollPane();
							Panel2.add(ScrollPane1);
							ScrollPane1.setBounds(10, 63, 434, 140);
							{
								String colunas[] = { "Código", "Nome",
										"Telefone", "Cidade", "Sexo" };
								TableModel = new DefaultTableModel(colunas, 0) {
									@Override
									public boolean isCellEditable(int row,
											int column) {
										return false;
									}
								};

								TableCliente = new JTable();
								ScrollPane1.setViewportView(TableCliente);
								TableCliente.setModel(TableModel);

								TableCliente.getColumnModel().getColumn(0)
										.setPreferredWidth(15);
								TableCliente.getColumnModel().getColumn(1)
										.setPreferredWidth(35);
								TableCliente.getColumnModel().getColumn(2)
										.setPreferredWidth(35);
								TableCliente.getColumnModel().getColumn(3)
										.setPreferredWidth(150);

								TableCliente.getColumnModel().getColumn(4)
										.setPreferredWidth(15);

								// barra de rolagem vertical sempre visÃ­vel
								ScrollPane1
										.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
								// barra de rolagem horizontal sempre oculta
								ScrollPane1
										.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

								jTextField1 = new JTextField();
								Panel2.add(jTextField1);
								jTextField1.setBounds(10, 25, 331, 21);
								jTextField1.getDocument().addDocumentListener(
										new DocumentListener() {

											@Override
											public void removeUpdate(
													DocumentEvent e) {
												atualizaGrid(jTextField1
														.getText());
											}

											@Override
											public void insertUpdate(
													DocumentEvent e) {
												atualizaGrid(jTextField1
														.getText());
											}

											@Override
											public void changedUpdate(
													DocumentEvent e) {
												atualizaGrid(jTextField1
														.getText());
											}
										});

							}
						}
						{
							btExcluir = new JButton();
							Panel2.add(btExcluir);
							btExcluir.setText("Excluir");
							btExcluir.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/excluir.png")));
							btExcluir.setBounds(358, 215, 86, 24);
							btExcluir.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {

									int linhaSelecionada = TableCliente
											.getSelectedRow();
									if (linhaSelecionada < 0) {
										JOptionPane
												.showMessageDialog(null,
														"Selecione uma linha para alterar!");
									} else {
										if (JOptionPane.showOptionDialog(null,
												"Deseja excluir esse cliente?",
												"", JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null, null, null) == 0) {

											if (TableCliente.getValueAt(
													TableCliente
															.getSelectedRow(),
													0) == null) {
											} else {
												Object obj = TableCliente.getValueAt(
														TableCliente
																.getSelectedRow(),
														0);
												String str = String
														.valueOf(obj);
												long codigo = Long
														.parseLong(str);
												try {
													dao.remove(codigo);
												} catch (SQLException e) {
													// TODO Auto-generated catch
													// block
													e.printStackTrace();
												}
												JOptionPane
														.showMessageDialog(
																null,
																"Cliente excluído com sucesso!");
												atualizaGrid();
											}
										}

									}

								}
							});
						}
						{
							btAlterar = new JButton();
							Panel2.add(btAlterar);
							btAlterar.setText("Alterar");
							btAlterar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/alterar.png")));
							btAlterar.setBounds(259, 215, 89, 24);
							btAlterar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									int linhaSelecionada = TableCliente
											.getSelectedRow();
									if (linhaSelecionada < 0) {
										JOptionPane
												.showMessageDialog(null,
														"Selecione uma linha para alterar!");
									} else {
										if (TableCliente.getValueAt(
												TableCliente.getSelectedRow(),
												0) == null) {
										} else {
											Object obj = TableCliente
													.getValueAt(TableCliente
															.getSelectedRow(),
															0);
											String str = String.valueOf(obj);
											long codigo = Long.parseLong(str);
											try {
												cliente = dao
														.DescobreCliente(codigo);
											} catch (SQLException e) {
												e.printStackTrace();
											}
											Alterar_Cliente cli = new Alterar_Cliente(
													cliente);

											cli.setLocationRelativeTo(null);
											cli.setVisible(true);
											atualizaGrid();

										}
									}
								}

							});
						}
						{
							btListar = new JButton();
							Panel2.add(btListar);
							btListar.setText("Listar");
							btListar.setBounds(351, 24, 93, 23);
							btListar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Listar.png")));
							btListar.setSize(93, 24);
							btListar.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									atualizaGrid();

								}
							});
						}

					}
				}
				{
					lbCdCliente = new JLabel();
					Panel.add(lbCdCliente);
					lbCdCliente.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/user_add.png")));
					lbCdCliente.setBounds(121, 42, 29, 52);
				}
				{
					btConsultar = new JButton();
					Panel.add(btConsultar);
					btConsultar.setText("Consultar");
					btConsultar.setBounds(90, 13, 99, 24);
					btConsultar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btConsultar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Consulta_Cliente inst;
							try {
								inst = new Consulta_Cliente(ConnectionFactory
										.getConnection());
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}
					});
				}
				{
					btVoltar = new JButton();
					Panel.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setBounds(199, 13, 97, 24);
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							dispose();
							Pagina_Inicial_correta cc = new Pagina_Inicial_correta();
							cc.setLocationRelativeTo(null);
							cc.setVisible(true);
							dispose();
						}
					});
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btSair.setBounds(306, 13, 98, 24);
					btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Pagina_Inicial_correta p = new Pagina_Inicial_correta();
							p.setLocationRelativeTo(null);
							p.setVisible(true);
							dispose();

						}
					});
				}
			}

			pack();
			this.setSize(504, 435);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<Cliente> Cliente = null;
		try {
			Cliente = dao.getLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableModel.addRow(cliente.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<Cliente> Cliente = null;
		try {
			Cliente = dao.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableModel.addRow(cliente.toArray());
		}
	}
}
