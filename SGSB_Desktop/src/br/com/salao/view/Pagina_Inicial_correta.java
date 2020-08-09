package br.com.salao.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Cidade.Cadastro_Cidade;
import br.com.salao.view.Cidade.Consulta_Cidade;
import br.com.salao.view.Cliente.Cadastro_Cliente;
import br.com.salao.view.Cliente.Consulta_Cliente;
import br.com.salao.view.Produto.Cadastro_Produto;
import br.com.salao.view.Servico.Cadastro_de_Serviços_2;
import br.com.salao.view.Servico.Consulta_Servico;

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
public class Pagina_Inicial_correta extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel2;
	private JButton btCadastrar_Cliente;
	private JButton btCadastroProduto;
	private JButton btEmitirRelatorio;
	private JButton btCadastrarForn;
	private JButton btRegistrarPag;
	private JButton btRegistrarGasto;
	private JButton btServico;
	private JButton btCadastra_Cidade;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem7;
	private JMenu jMenu4;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem5;
	private JMenu jMenu2;
	private JMenuItem jMenuItem2;
	private JMenuItem jmenoe;
	private JMenu jmenu;
	private JMenuItem MenuItem6;
	private JMenuItem MenuItem2;
	private JMenuItem MenuItem;
	private JMenu Menu6;
	private JMenuItem jMenuItem1;
	private JMenu jMenu3;
	private JMenuItem jMenuItem4;
	private JMenu jMenu1;
	private JMenuBar Menu;
	private JLabel lbSalaodeBeleza;
	private JLabel lbicone;
	private JButton btAgendar;
	private JButton btVisualizar_Agenda;
	private JButton btCadastrar_Serviço;
	private JButton btCadastrar_Profissional;
	private JPanel jPanel1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Pagina_Inicial_correta inst = new Pagina_Inicial_correta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Pagina_Inicial_correta() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Sistema para Salão de Beleza");
			this.setVisible(false);
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/496709690.gif")).getImage());
			this.setResizable(false);
			{
				Menu = new JMenuBar();
				setJMenuBar(Menu);
				{
					jMenu1 = new JMenu();
					Menu.add(jMenu1);
					jMenu1.setText("Início");
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("Pagina Inicial");
					}
				}
				{
					jMenu3 = new JMenu();
					Menu.add(jMenu3);
					jMenu3.setText("Consultas");
					{
						jMenuItem1 = new JMenuItem();
						jMenu3.add(jMenuItem1);
						jMenuItem1.setText("Agendamento");
					}
					{
						Menu6 = new JMenu();
						jMenu3.add(Menu6);
						Menu6.setText("Cadastros");
						{
							MenuItem = new JMenuItem();
							Menu6.add(MenuItem);
							MenuItem.setText("Cliente");
							MenuItem.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									Consulta_Cliente inst;
									try {
										inst = new Consulta_Cliente(
												ConnectionFactory
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
							MenuItem2 = new JMenuItem();
							Menu6.add(MenuItem2);
							MenuItem2.setText("Profissional");
							// MenuItem2.addActionListener(new ActionListener()
							// {
							//
							// @Override
							// public void actionPerformed(ActionEvent e) {
							// Consulta_Profissional inst;
							// try {
							// inst = new Consulta_Profissional(
							// ConnectionFactory
							// .getConnection());
							// inst.setLocationRelativeTo(null);
							// inst.setVisible(true);
							//
							// } catch (SQLException e1) {
							// // TODO Auto-generated catch block
							// e1.printStackTrace();
							// }
							//
							// }
							// });
						}
						{
							MenuItem6 = new JMenuItem();
							Menu6.add(MenuItem6);
							MenuItem6.setText("Serviço");
							MenuItem6.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									Consulta_Servico inst;
									try {
										inst = new Consulta_Servico(
												ConnectionFactory
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
							jMenuItem9 = new JMenuItem();
							Menu6.add(jMenuItem9);
							jMenuItem9.setText("Cidade");
							jMenuItem9.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent arg0) {
									Consulta_Cidade inst;
									try {
										inst = new Consulta_Cidade(
												ConnectionFactory
														.getConnection());
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);

									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
							});

						}
					}
				}
				{
					jmenu = new JMenu();
					Menu.add(jmenu);
					jmenu.setText("Ações");
					{
						jmenoe = new JMenuItem();
						jmenu.add(jmenoe);
						jmenoe.setText("Agendar Horário");
					}
					{
						jMenuItem2 = new JMenuItem();
						jmenu.add(jMenuItem2);
						jMenuItem2.setText("Registrar Pagamento");
					}
				}
				{
					jMenu2 = new JMenu();
					Menu.add(jMenu2);
					jMenu2.setText("Relatórios");
					{
						jMenuItem5 = new JMenuItem();
						jMenu2.add(jMenuItem5);
						jMenuItem5.setText("Clientes Inadimplentes");
					}
					{
						jMenuItem6 = new JMenuItem();
						jMenu2.add(jMenuItem6);
						jMenuItem6.setText("Serviços Realizados");
						// jMenuItem6.addActionListener(new ActionListener() {
						//
						// @Override
						// public void actionPerformed(ActionEvent arg0) {
						// Controle_Servico_realizado inst = new
						// Controle_Servico_realizado(
						// ConnectionFactory.getConnection());
						// inst.setLocationRelativeTo(null);
						// inst.setVisible(true);
						//
						// }
						// });
					}
				}
				{
					jMenu4 = new JMenu();
					Menu.add(jMenu4);
					jMenu4.setText("Ajuda");
					{
						jMenuItem7 = new JMenuItem();
						jMenu4.add(jMenuItem7);
						jMenuItem7.setText("Sobre a tela");
					}
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, BorderLayout.WEST);
				jPanel2.setLayout(null);
				jPanel2.setPreferredSize(new java.awt.Dimension(495, 619));
				jPanel2.setBackground(new java.awt.Color(165, 34, 31));
				{
					jPanel1 = new JPanel();
					jPanel2.add(jPanel1, "Center");
					jPanel1.setLayout(null);
					jPanel1.setBounds(3, 153, 482, 447);
					{
						btCadastrar_Cliente = new JButton();
						jPanel1.add(btCadastrar_Cliente);
						btCadastrar_Cliente.setText("Cadastrar Cliente");
						btCadastrar_Cliente.setBounds(37, 26, 190, 55);
						btCadastrar_Cliente.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/Cadastrar.png")));
						btCadastrar_Cliente
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent arg0) {
										Cadastro_Cliente cc = new Cadastro_Cliente(
												ConnectionFactory
														.getConnection());
										cc.setLocationRelativeTo(null);
										cc.setVisible(true);

									}
								});
					}
					{
						btCadastrar_Profissional = new JButton();
						jPanel1.add(btCadastrar_Profissional);
						btCadastrar_Profissional
								.setText("Cadastrar Profissional");
						btCadastrar_Profissional.setBounds(261, 26, 190, 55);
						btCadastrar_Profissional.setIcon(new ImageIcon(
								getClass().getClassLoader().getResource(
										"Icones/profissional.png")));
						// btCadastrar_Profissional
						// .addActionListener(new ActionListener() {
						//
						// @Override
						// public void actionPerformed(ActionEvent e) {
						// Cadastro_Profissional inst = new
						// Cadastro_Profissional(
						// ConnectionFactory
						// .getConnection());
						// inst.setLocationRelativeTo(null);
						// inst.setVisible(true);
						//
						// }
						// });
					}
					{
						btCadastrar_Serviço = new JButton();
						jPanel1.add(btCadastrar_Serviço);
						btCadastrar_Serviço.setText("Cadastrar Serviço");
						btCadastrar_Serviço.setBounds(261, 97, 190, 53);
						btCadastrar_Serviço.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/escova_secador.png")));
						btCadastrar_Serviço
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										Cadastro_de_Serviços_2 inst = new Cadastro_de_Serviços_2(
												ConnectionFactory
														.getConnection());
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);

									}
								});
					}
					{
						btVisualizar_Agenda = new JButton();
						jPanel1.add(btVisualizar_Agenda);
						btVisualizar_Agenda.setText("Visualizar Agenda");
						btVisualizar_Agenda.setBounds(261, 234, 190, 53);
						btVisualizar_Agenda.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/visualizaragendamento.png")));
						// btVisualizar_Agenda
						// .addActionListener(new ActionListener() {
						//
						// @Override
						// public void actionPerformed(ActionEvent arg0) {
						// try {
						// Agendamento_Visualizar v = new
						// Agendamento_Visualizar(
						// ConnectionFactory
						// .getConnection());
						// v.setLocationRelativeTo(null);
						// v.setVisible(true);
						// } catch (SQLException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						//
						// }
						// });
					}
					{
						btAgendar = new JButton();
						jPanel1.add(btAgendar);
						btAgendar.setText("Agendar Horário");
						btAgendar.setBounds(37, 234, 190, 53);
						btAgendar.setIcon(new ImageIcon(getClass()
								.getClassLoader()
								.getResource("Icones/time.png")));
						// btAgendar.addActionListener(new ActionListener() {
						//
						// @Override
						// public void actionPerformed(ActionEvent arg0) {
						// try {
						// Agendamento_Tela a = new Agendamento_Tela(
						// ConnectionFactory.getConnection());
						// a.setLocationRelativeTo(null);
						// a.setVisible(true);
						// } catch (SQLException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						//
						// }
						// });
					}
					{
						btCadastra_Cidade = new JButton();
						jPanel1.add(btCadastra_Cidade);
						btCadastra_Cidade.setText("Cadastrar Cidade");
						btCadastra_Cidade.setBounds(37, 97, 190, 53);
						btCadastra_Cidade.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/building_add.png")));
						btCadastra_Cidade
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {

										Cadastro_Cidade inst = new Cadastro_Cidade(
												ConnectionFactory
														.getConnection());
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);

									}
								});
					}
					{
						btServico = new JButton();
						jPanel1.add(btServico);
						btServico.setText("Realizar Venda");
						btServico.setBounds(37, 312, 190, 53);
						btServico.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/total_plan_cost1.png")));
						btServico.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// Venda_Tela inst = new Venda_Tela();
								// inst.setVisible(true);
								// inst.setLocationRelativeTo(null);
							}
						});
					}
					{
						btRegistrarGasto = new JButton();
						jPanel1.add(btRegistrarGasto);
						btRegistrarGasto.setText("Registrar Gastos");
						btRegistrarGasto.setBounds(37, 381, 190, 53);
						btRegistrarGasto.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/cash_terminal.png")));
						btRegistrarGasto
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										// Gastos_Tela inst = new Gastos_Tela();
										// inst.setLocationRelativeTo(null);
										// inst.setVisible(true);

									}
								});
					}
					{
						btRegistrarPag = new JButton();
						jPanel1.add(btRegistrarPag);
						btRegistrarPag.setText("Registrar Pagamento");
						btRegistrarPag.setBounds(261, 312, 190, 53);
						btRegistrarPag.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/cash_register.png")));
						btRegistrarPag.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// Pagamento_Venda_Tela inst = new
								// Pagamento_Venda_Tela();
								// inst.setLocationRelativeTo(null);
								// inst.setVisible(true);

							}
						});
					}
					{
						btCadastroProduto = new JButton();
						jPanel1.add(btCadastroProduto);
						btCadastroProduto.setText("Cadastrar Produto");
						btCadastroProduto.setBounds(37, 164, 190, 52);
						btCadastroProduto.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/cart_put.png")));
						btCadastroProduto
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent arg0) {
										Cadastro_Produto inst = new Cadastro_Produto();
										inst.setLocationRelativeTo(null);
										inst.setVisible(true);
									}
								});
					}
					{
						btCadastrarForn = new JButton();
						jPanel1.add(btCadastrarForn);
						btCadastrarForn.setText("Cadastrar Fornecedor");
						btCadastrarForn.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/reseller_account.png")));
						btCadastrarForn.setBounds(261, 164, 190, 52);
					}
					{
						btEmitirRelatorio = new JButton();
						jPanel1.add(btEmitirRelatorio);
						btEmitirRelatorio.setText("Emitir Relatórios");
						btEmitirRelatorio.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/curriculum_vitae.png")));
						btEmitirRelatorio.setBounds(261, 381, 190, 53);
					}
				}
				{
					lbicone = new JLabel();
					jPanel2.add(lbicone);
					lbicone.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/496709690.gif")));
					lbicone.setBounds(373, 6, 99, 133);
				}
				{
					lbSalaodeBeleza = new JLabel();
					jPanel2.add(lbSalaodeBeleza);
					lbSalaodeBeleza.setText("Instituto Glamour");
					lbSalaodeBeleza.setBounds(44, 45, 329, 65);
					lbSalaodeBeleza.setFont(new java.awt.Font(
							"Monotype Corsiva", 2, 36));
					lbSalaodeBeleza.setForeground(new java.awt.Color(255, 255,
							255));
				}
			}
			pack();
			this.setSize(494, 652);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent,
			final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

}
