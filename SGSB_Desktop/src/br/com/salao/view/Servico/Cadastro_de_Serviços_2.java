package br.com.salao.view.Servico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import javax.swing.JScrollPane;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import br.com.salao.bo.ServicoBo;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.vo.ServicoVo;

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
public class Cadastro_de_Serviços_2 extends javax.swing.JDialog {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JTextField tfNomeAl;
	private JLabel lbNomeAl;
	private JButton btSalvar;
	private JTextArea TextAreaDescricao;
	private JScrollPane ScrollPaneDescricao;
	private JLabel lbDescricao;
	private JTextField tfPreco;
	private JLabel lbPreco;
	private JComboBox ComboBoxDuracao;
	private JLabel lbDuracao;
	private JTextField tfNome;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JButton btListar;
	private JLabel lbMinutos;
	private JButton btSair;
	private JButton btVoltar;
	private JButton btConsultar;
	private JLabel lbservico;
	private JButton btCancelarAl;
	private JScrollPane jScrollPane1;
	private JPanel Alterar;
	private JPanel jPanel1;
	private JTabbedPane TabbedPaneServico;
	private JPanel jPanel2;
	private JTextField titulo;
	private JButton btCancelar;
	private JButton btAlterar;
	private DefaultTableModel TabelaModel;
	private JTable TabelaServico;

	private ServicoVo servico;
	private ServicoBo sBo;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public Cadastro_de_Serviços_2(Connection conexao) {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Cadastro de Serviço");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/secador.png")).getImage());
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, BorderLayout.CENTER);
				jPanel2.setPreferredSize(new java.awt.Dimension(460, 54));
				jPanel2.setLayout(null);
				{
					titulo = new JTextField();
					jPanel2.add(titulo);
					titulo.setFont(new java.awt.Font("Lucida Sans",0,24));
					titulo.setText("Cadastro de Serviço");
					titulo.setEditable(false);
					titulo.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 0, 0));
					titulo.setBounds(115, 51, 231, 44);
				}
				{
					TabbedPaneServico = new JTabbedPane();
					jPanel2.add(TabbedPaneServico);
					TabbedPaneServico.setBounds(22, 101, 370, 312);
					{
						jPanel1 = new JPanel();
						TabbedPaneServico.addTab("Cadastrar", null, jPanel1,
								null);
						jPanel1.setFont(new java.awt.Font("Snap ITC", 0, 12));
						jPanel1.setPreferredSize(new java.awt.Dimension(460,
								175));
						jPanel1.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jPanel1.setLayout(null);
						{
							lbCodigo = new JLabel();
							jPanel1.add(lbCodigo);
							lbCodigo.setText("Código");
							lbCodigo.setBounds(10, 11, 57, 14);
						}
						{
							tfCodigo = new JTextField();
							jPanel1.add(tfCodigo);
							tfCodigo.setBounds(10, 25, 49, 20);
							tfCodigo.setEnabled(false);
							try {
								sBo = new ServicoBo();
								long id = sBo.ProximoId();
								tfCodigo.setText(Long.toString(id));
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						{
							lbNome = new JLabel();
							jPanel1.add(lbNome);
							lbNome.setText("Nome");
							lbNome.setBounds(77, 11, 77, 14);
						}
						{
							tfNome = new JTextField();
							jPanel1.add(tfNome);
							tfNome.setBounds(75, 25, 271, 20);
						}
						{
							lbDuracao = new JLabel();
							jPanel1.add(lbDuracao);
							lbDuracao.setText("Duração");
							lbDuracao.setBounds(10, 62, 65, 14);
						}
						{
							ComboBoxModel ComboBoxDuracaoModel = new DefaultComboBoxModel(
									new String[] { "10", "15", "20", "30",
											"50", "60", "80", "100", "120" });
							ComboBoxDuracao = new JComboBox();
							jPanel1.add(ComboBoxDuracao);
							ComboBoxDuracao.setModel(ComboBoxDuracaoModel);
							ComboBoxDuracao.setBounds(10, 76, 64, 20);
						}
						{
							lbPreco = new JLabel();
							jPanel1.add(lbPreco);
							lbPreco.setText("Preço");
							lbPreco.setBounds(131, 62, 53, 14);
						}
						{
							tfPreco = new JTextField();
							jPanel1.add(tfPreco);
							tfPreco.setBounds(131, 76, 88, 20);
						}
						{
							lbDescricao = new JLabel();
							jPanel1.add(lbDescricao);
							lbDescricao.setText("Descrição");
							lbDescricao.setBounds(10, 113, 98, 19);
						}
						{
							ScrollPaneDescricao = new JScrollPane();
							jPanel1.add(ScrollPaneDescricao);
							ScrollPaneDescricao.setBounds(10, 132, 336, 110);
							TextAreaDescricao = new JTextArea();
							ScrollPaneDescricao
									.setViewportView(TextAreaDescricao);
							// TextAreaDescricao
							// .setPreferredSize(new java.awt.Dimension(
							// 314, 108));
							// barra de rolagem vertical sempre visÃ­vel
							ScrollPaneDescricao
									.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
							// barra de rolagem horizontal sempre oculta
							ScrollPaneDescricao
									.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

						}
						{
							btCancelar = new JButton();
							jPanel1.add(btCancelar);
							btCancelar.setText("Cancelar");
							btCancelar.setBounds(254, 251, 94, 23);
							btCancelar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Retiraar.png")));
							btCancelar.setSize(94, 24);
							btCancelar.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									dispose();

								}
							});
						}
						{
							btSalvar = new JButton();
							jPanel1.add(btSalvar);
							btSalvar.setText("Cadastrar");
							btSalvar.setBounds(141, 251, 103, 23);
							btSalvar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/Salvaar.png")));
							btSalvar.setSize(103, 24);
							btSalvar.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent evento) {
									if (!tfNome.getText().equals("")
											&& !tfPreco.getText().equals("")
											&& !TextAreaDescricao.getText()
													.equals("")) {
										servico = new ServicoVo(
												Integer.parseInt((tfCodigo
														.getText())),
												tfNome.getText(),
												Integer.valueOf(String
														.valueOf(ComboBoxDuracao
																.getSelectedItem())),
												Double.parseDouble(tfPreco
														.getText().replace(",", ".")),
												TextAreaDescricao.getText());
										JOptionPane
												.showMessageDialog(null,
														"Serviço cadastrado com sucesso!");
										tfNome.setText("");
										tfPreco.setText("");
										TextAreaDescricao.setText("");
										try {
											long id = sBo.ProximoId();
											tfCodigo.setText(Long
													.toString(id));
										} catch (SQLException e) {
											e.printStackTrace();
										}
										try {
											sBo.adiciona(servico);
										} catch (SQLException e1) {
											e1.printStackTrace();
										}

									} else {
										JOptionPane.showMessageDialog(null,
												"Erro! Campo não preenchido",
												"Erro",
												JOptionPane.ERROR_MESSAGE);
									}
									atualizaGridServico();
								}

							});

						}
						{
							lbMinutos = new JLabel();
							jPanel1.add(lbMinutos);
							lbMinutos.setText("minutos");
							lbMinutos.setBounds(78, 79, 37, 14);
						}
					}
					{
						Alterar = new JPanel();
						TabbedPaneServico.addTab("Alterar/ Excluir", null,
								Alterar, null);
						Alterar.setPreferredSize(new java.awt.Dimension(455,
								324));
						Alterar.setLayout(null);
						{
							jScrollPane1 = new JScrollPane();
							Alterar.add(jScrollPane1);
							jScrollPane1.setBounds(10, 62, 340, 177);
							{
								String colunas[] = { "Código", "Nome",
										"Duração", "Descrição", "Preço" };
								TabelaModel = new DefaultTableModel(colunas, 0) {
									public boolean isCellEditable(int row,
											int column) {
										return false;
									}
								};

								TabelaServico = new JTable(TabelaModel);
								jScrollPane1.setViewportView(TabelaServico);
								TabelaServico.setModel(TabelaModel);

								// largura da 1a. coluna (0)
								TabelaServico.getColumnModel().getColumn(0)
										.setPreferredWidth(70);
								TabelaServico.getColumnModel().getColumn(0)
										.setResizable(false);
								// largura da 2a. coluna (1)
								TabelaServico.getColumnModel().getColumn(1)
										.setPreferredWidth(125);
								TabelaServico.getColumnModel().getColumn(1)
										.setResizable(false);
								TabelaServico.getColumnModel().getColumn(2)
										.setPreferredWidth(90);
								TabelaServico.getColumnModel().getColumn(2)
										.setResizable(false);
								TabelaServico.getColumnModel().getColumn(3)
										.setPreferredWidth(200);
								TabelaServico.getColumnModel().getColumn(3)
										.setResizable(false);
								TabelaServico.getColumnModel().getColumn(4)
										.setPreferredWidth(80);
								TabelaServico.getColumnModel().getColumn(4)
										.setResizable(false);

								TabelaServico.setBounds(82, 121, 316, 66);

								// barra de rolagem vertical sempre visÃ­vel
								jScrollPane1
										.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
								// barra de rolagem horizontal sempre oculta
								jScrollPane1
										.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

							}
						}
						{
							lbNomeAl = new JLabel();
							Alterar.add(lbNomeAl);
							lbNomeAl.setText("Nome");
							lbNomeAl.setBounds(10, 12, 64, 20);
						}
						{
							tfNomeAl = new JTextField();
							Alterar.add(tfNomeAl);
							tfNomeAl.setBounds(10, 30, 234, 20);
							tfNomeAl.getDocument().addDocumentListener(
									new DocumentListener() {

										@Override
										public void removeUpdate(DocumentEvent e) {
											atualizaGridNomeServico(tfNomeAl.getText());
										}

										@Override
										public void insertUpdate(DocumentEvent e) {
											atualizaGridNomeServico(tfNomeAl.getText());
										}

										@Override
										public void changedUpdate(
												DocumentEvent e) {
											atualizaGridNomeServico(tfNomeAl.getText());
										}
									});
						}
						{
							btCancelarAl = new JButton();
							Alterar.add(btCancelarAl);
							btCancelarAl.setText("Excluir");
							btCancelarAl.setBounds(245, 251, 105, 22);
							btCancelarAl.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/excluir.png")));
							btCancelarAl.setSize(105, 24);
							btCancelarAl
									.addActionListener(new ActionListener() {
										@Override
										public void actionPerformed(
												ActionEvent evento) {
											int linhaSelecionada;
											linhaSelecionada = TabelaServico
													.getSelectedRow();
											if (linhaSelecionada < 0) {
												JOptionPane
														.showMessageDialog(
																null,
																"Selecione uma linha para excluir!");
											} else {
												if (JOptionPane
														.showOptionDialog(
																null,
																"Deseja excluir esse profissional?",
																"",
																JOptionPane.YES_NO_OPTION,
																JOptionPane.QUESTION_MESSAGE,
																null, null,
																null) == 0) {
													if (TabelaServico.getValueAt(
															TabelaServico
																	.getSelectedRow(),
															0) == null) {
													} else {
														Object obj = TabelaServico.getValueAt(
																TabelaServico
																		.getSelectedRow(),
																0);
														String str = String
																.valueOf(obj);
														int codigo = Integer
																.parseInt(str);
														try {
															sBo
																	.excluir(codigo);
														} catch (SQLException e) {
															// TODO
															// Auto-generated
															// catch
															// block
															e.printStackTrace();
														}
														JOptionPane
																.showMessageDialog(
																		null,
																		"Serviço excluido com sucesso!");
														atualizaGridServico();
													}
												}
											}
										}
									});
						}
						{
							btAlterar = new JButton();
							Alterar.add(btAlterar);
							btAlterar.setText("Alterar");
							btAlterar.setBounds(133, 250, 102, 23);
							btAlterar.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource(
											"Icones/alterar.png")));
							btAlterar.setSize(102, 24);
							btAlterar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									int linhaSelecionada = TabelaServico
											.getSelectedRow();
									if (linhaSelecionada < 0) {
										JOptionPane
												.showMessageDialog(null,
														"Selecione uma linha para alterar!");
									} else {
										if (TabelaServico.getValueAt(
												TabelaServico.getSelectedRow(),
												0) == null) {
										} else {
											Object obj = TabelaServico
													.getValueAt(TabelaServico
															.getSelectedRow(),
															0);
											String str = String.valueOf(obj);
											int codigo = Integer.parseInt(str);
											try {
												servico = sBo
														.DescobreServico(codigo);
											} catch (SQLException e) {
												e.printStackTrace();
											}
											Alterar_Serviço_2 c;
											try {
												c = new Alterar_Serviço_2(
														servico,
														ConnectionFactory
																.getConnection());
												c.setLocationRelativeTo(null);
												c.setVisible(true);
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}

											atualizaGridServico();

										}
									}
								}

							});
						}
						{
							btListar = new JButton();
							Alterar.add(btListar);
							btListar.setText("Listar");
							btListar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Listar.png")));
							btListar.setBounds(257, 28, 93, 25);
							btListar.setSize(93, 24);
							btListar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									atualizaGridServico();
									
								}
							});
						}
					}
				}
				{
					lbservico = new JLabel();
					jPanel2.add(lbservico);
					lbservico.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/escova_secador.png")));
					lbservico.setBounds(70, 51, 41, 33);
				}
				{
					btConsultar = new JButton();
					jPanel2.add(btConsultar);
					btConsultar.setText("Consultar");
					btConsultar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btConsultar.setBounds(49, 16, 105, 24);
					btConsultar.addActionListener( new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Consulta_Servico inst;
							try {
								inst = new Consulta_Servico(ConnectionFactory.getConnection());
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					});
				}
				{
					btVoltar = new JButton();
					jPanel2.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.setBounds(164, 16, 83, 24);
				}
				{
					btSair = new JButton();
					jPanel2.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btSair.setBounds(257, 16, 72, 24);
					btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
				}
			}
			pack();
			this.setSize(424, 470);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGridServico() {
		List<ServicoVo> servicos = null;
		sBo = new ServicoBo();
		try {
			servicos = sBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TabelaModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TabelaModel.addRow(servico.toArray());
		}
	}

	private void atualizaGridNomeServico(String nome) {
		List<ServicoVo> servicos = null;
		sBo = new ServicoBo();
		try {
			servicos = sBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TabelaModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TabelaModel.addRow(servico.toArray());
		}
	}
}
