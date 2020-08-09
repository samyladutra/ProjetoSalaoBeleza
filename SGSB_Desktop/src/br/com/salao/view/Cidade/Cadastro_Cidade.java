package br.com.salao.view.Cidade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Pagina_Inicial_correta;
import br.com.salao.vo.Cidade;

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
public class Cadastro_Cidade extends javax.swing.JDialog {
	private CidadeDAO dao;
	private Cidade cidade;

	private JPanel Panel1;
	private JButton btConsultar;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JButton btAlterar;
	private JButton btExcluir;
	private JLabel jLabel3;
	private JTextField jTextField1;
	private JButton btcancelar;
	private JButton btSalvar;
	private JLabel lbNome;
	private JPanel AbaAltera;
	private JPanel AbaCadastra;
	private JTabbedPane TabbedPaneCadastro;
	private JLabel jLabel1;
	private JLabel lbCadastro;
	private JButton btSair;
	private JLabel lbUF;
	private JTextField tfNome;
	private JButton btVoltar;
	private JComboBox tfUF;

	private JTable Tablecidade;
	private DefaultTableModel TableModel;
	private JScrollPane jScrollPane1;
	private JButton btExibirTodas;
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

	public Cadastro_Cidade(Connection conexao) {
		super();
		try {
			dao = new CidadeDAO(conexao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Cadastro de Cidade");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/building_add.png")).getImage());
			this.setResizable(false);
			{
				Panel1 = new JPanel();
				getContentPane().add(Panel1, BorderLayout.CENTER);
				Panel1.setLayout(null);
				{
					btConsultar = new JButton();
					Panel1.add(btConsultar);
					btConsultar.setText("Consultar");
					btConsultar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btConsultar.setBounds(68, 11, 107, 24);
					btConsultar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Consulta_Cidade inst;
							try {
								inst = new Consulta_Cidade(ConnectionFactory
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
					Panel1.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.setBounds(186, 11, 86, 24);
					dispose();
				}
				{
					btSair = new JButton();
					Panel1.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btSair.setBounds(282, 11, 77, 24);
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
				{
					lbCadastro = new JLabel();
					Panel1.add(lbCadastro);
					lbCadastro.setText("Cadasto de Cidade");
					lbCadastro.setBounds(106, 54, 239, 50);
					lbCadastro.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					jLabel1 = new JLabel();
					Panel1.add(jLabel1);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/building_add.png")));
					jLabel1.setBounds(68, 59, 32, 32);
				}
				{
					TabbedPaneCadastro = new JTabbedPane();
					Panel1.add(TabbedPaneCadastro);
					TabbedPaneCadastro.setBounds(21, 104, 365, 229);
					{
						AbaCadastra = new JPanel();
						TabbedPaneCadastro.addTab("Cadastrar", null,
								AbaCadastra, null);
						AbaCadastra.setLayout(null);
						{
							lbNome = new JLabel();
							AbaCadastra.add(lbNome);
							lbNome.setText("Nome");
							lbNome.setBounds(57, 12, 27, 14);
						}
						{
							lbCodigo = new JLabel();
							AbaCadastra.add(lbCodigo);
							lbCodigo.setText("Código");
							lbCodigo.setBounds(10, 11, 42, 14);
						}
						{
							tfCodigo = new JTextField();
							AbaCadastra.add(tfCodigo);
							tfCodigo.setBounds(10, 31, 37, 20);
							tfCodigo.setEnabled(false);
							try {
								int id = dao.getProximoId();
								tfCodigo.setText(Integer.toString(id));
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						{
							tfNome = new JTextField();
							AbaCadastra.add(tfNome);
							tfNome.setBounds(60, 31, 219, 20);
						}
						{
							lbUF = new JLabel();
							AbaCadastra.add(lbUF);
							lbUF.setText("UF");
							lbUF.setBounds(289, 11, 23, 14);
						}
						{
							btSalvar = new JButton();
							AbaCadastra.add(btSalvar);
							btSalvar.setText("Salvar");
							btSalvar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Salvaar.png")));
							btSalvar.setBounds(151, 155, 83, 24);
							btSalvar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									if (!tfNome.getText().equals("")) {
										cidade = new Cidade(tfNome.getText(),
												(String) tfUF.getSelectedItem());
										JOptionPane
												.showMessageDialog(null,
														"Cidade cadastrada com sucesso!");
										tfNome.setText("");
										try {
											int id = dao.getProximoId();
											tfCodigo.setText(Integer
													.toString(id + 1));
										} catch (SQLException e) {
											e.printStackTrace();
										}
										try {
											dao.adiciona(cidade);
										} catch (SQLException e1) {
											e1.printStackTrace();
										}

									} else {
										JOptionPane.showMessageDialog(null,
												"Erro! Campo não preenchido",
												"Erro",
												JOptionPane.ERROR_MESSAGE);
									}
								}

							});

						}
						{
							btcancelar = new JButton();
							AbaCadastra.add(btcancelar);
							btcancelar.setText("Cancelar");
							btcancelar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/retiraar.png")));
							btcancelar.setBounds(244, 155, 95, 24);
							btcancelar.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									dispose();

								}
							});

						}
						{
							tfUF = new JComboBox(new String[] { "AC", "AP",
									"AL", "AM", "BA", "CE", "DF", "ES", "GO",
									"MA", "MG", "MS", "MT", "PA", "PB", "PE",
									"PI", "PR", "RJ", "RN", "RO", "RR", "RS",
									"SC", "SE", "SP", "TO" });
							AbaCadastra.add(tfUF);
							tfUF.setBounds(289, 31, 50, 20);
						}
					}
					{
						AbaAltera = new JPanel();
						TabbedPaneCadastro.addTab("Alterar/ Excluir", null,
								AbaAltera, null);
						AbaAltera.setLayout(null);
						AbaAltera.setPreferredSize(new java.awt.Dimension(363,
								201));
						{
							jLabel3 = new JLabel();
							AbaAltera.add(jLabel3);
							jLabel3.setText("Nome");
							jLabel3.setBounds(10, 11, 27, 14);
						}

						{

						}
						{
							btExcluir = new JButton();
							AbaAltera.add(btExcluir);
							btExcluir.setText("Excluir");
							btExcluir.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/excluir.png")));
							btExcluir.setBounds(265, 173, 83, 24);
							btExcluir.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									int linhaSelecionada = Tablecidade
											.getSelectedRow();
									if (linhaSelecionada < 0) {
										JOptionPane
												.showMessageDialog(null,
														"Selecione uma linha para excluir!");
									} else {
										if (JOptionPane.showOptionDialog(null,
												"Deseja excluir essa cidade?",
												"", JOptionPane.YES_NO_OPTION,
												JOptionPane.QUESTION_MESSAGE,
												null, null, null) == 0) {
											Object obj = Tablecidade
													.getValueAt(Tablecidade
															.getSelectedRow(),
															0);
											String str = String.valueOf(obj);
											int codigo = Integer.parseInt(str);
											try {
												dao.remove(codigo);
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
											JOptionPane
													.showMessageDialog(null,
															"Cidade excluida com sucesso!");
											atualizaGrid();

										}
									}
								}
							});
						}
						{
							btAlterar = new JButton();
							AbaAltera.add(btAlterar);
							btAlterar.setText("Alterar");
							btAlterar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/alterar.png")));
							btAlterar.setBounds(170, 173, 85, 24);
							btAlterar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									int linhaSelecionada = Tablecidade
											.getSelectedRow();
									if (linhaSelecionada < 0) {
										JOptionPane
												.showMessageDialog(null,
														"Selecione uma linha para alterar!");
									} else {
										if (Tablecidade.getValueAt(
												Tablecidade.getSelectedRow(), 0) == null) {
										} else {
											Object obj = Tablecidade
													.getValueAt(Tablecidade
															.getSelectedRow(),
															0);
											String str = String.valueOf(obj);
											int codigo = Integer.parseInt(str);
											try {
												cidade = dao
														.DescobreCidade(codigo);
											} catch (SQLException e) {
												e.printStackTrace();
											}
											// System.out.println(cidade.getCodigo());
											Alterar_Cidade c = new Alterar_Cidade(
													cidade, ConnectionFactory
															.getConnection());
											c.setLocationRelativeTo(null);
											c.setVisible(true);
											atualizaGrid();

										}
									}
								}

							});
						}
						{
							btExibirTodas = new JButton();
							AbaAltera.add(btExibirTodas);
							btExibirTodas.setText("Exibir Todas");
							btExibirTodas.setBounds(218, 26, 130, 23);
							btExibirTodas.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Listar.png")));
							btExibirTodas
									.addActionListener(new ActionListener() {
										public void actionPerformed(
												ActionEvent arg0) {
											atualizaGrid();
										}

									});
						}
					}
				}
				{
					jScrollPane1 = new JScrollPane();
					AbaAltera.add(jScrollPane1);
					jScrollPane1.setBounds(15, 68, 335, 94);
					{
						String colunas[] = { "Código", "Nome", "UF" };
						TableModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						Tablecidade = new JTable(TableModel);
						jScrollPane1.setViewportView(Tablecidade);
						Tablecidade.setModel(TableModel);

						// largura da 1a. coluna (0)
						Tablecidade.getColumnModel().getColumn(0)
								.setPreferredWidth(80);
						Tablecidade.getColumnModel().getColumn(0)
								.setResizable(false);
						// largura da 2a. coluna (1)
						Tablecidade.getColumnModel().getColumn(1)
								.setPreferredWidth(200);
						Tablecidade.getColumnModel().getColumn(1)
								.setResizable(false);
						Tablecidade.getColumnModel().getColumn(2)
								.setPreferredWidth(80);
						Tablecidade.getColumnModel().getColumn(2)
								.setResizable(false);
						Tablecidade.setBounds(82, 121, 316, 66);

						// barra de rolagem vertical sempre visÃ­vel
						jScrollPane1
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre oculta
						jScrollPane1
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

						jTextField1 = new JTextField();
						AbaAltera.add(jTextField1);
						jTextField1.setBounds(13, 27, 195, 20);
						jTextField1.getDocument().addDocumentListener(
								new DocumentListener() {

									@Override
									public void removeUpdate(DocumentEvent e) {
										atualizaGrid(jTextField1.getText());
									}

									@Override
									public void insertUpdate(DocumentEvent e) {
										atualizaGrid(jTextField1.getText());
									}

									@Override
									public void changedUpdate(DocumentEvent e) {
										atualizaGrid(jTextField1.getText());
									}
								});
					}
				}
			}
			pack();
			this.setSize(433, 383);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void atualizaGrid() {
		List<Cidade> cidades = null;
		try {
			cidades = dao.getLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (cidades != null) {
			for (Cidade cidade : cidades)
				TableModel.addRow(cidade.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<Cidade> cidades = null;
		try {
			cidades = dao.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (cidades != null) {
			for (Cidade cidade : cidades)
				TableModel.addRow(cidade.toArray());
		}
	}

	public Cidade getCidade() {
		return cidade;
	}

}
