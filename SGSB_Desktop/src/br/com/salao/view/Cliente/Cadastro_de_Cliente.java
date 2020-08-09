package br.com.salao.view.Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

import br.com.salao.bo.ClienteBo;
import br.com.salao.vo.Cliente;

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
public class Cadastro_de_Cliente extends javax.swing.JFrame {
	private JPanel PanelPesquisa;
	private JScrollPane ScrollPane;
	private JLabel lbTitulo;
	private JButton btSair;
	private JTextField tfNomeCadastrado;
	private JButton btExcluir;
	private JButton btVisualizar;
	private JButton btInserir;
	private JButton btPesquisa;
	private JButton btListar;
	private JButton btAlterar;
	private JLabel jLabel1;
	private JTable TableCliente;
	private DefaultTableModel TableClienteModel;
	private Cliente cVo;
	private ClienteBo cBo;

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
				Cadastro_de_Cliente inst = new Cadastro_de_Cliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Cadastro_de_Cliente() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Cadastro de Cliente");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/user.png")).getImage());
			{
				PanelPesquisa = new JPanel();
				getContentPane().add(PanelPesquisa, BorderLayout.CENTER);
				PanelPesquisa.setLayout(null);
				PanelPesquisa.setBounds(0, 0, 492, 355);
				{
					ScrollPane = new JScrollPane();
					PanelPesquisa.add(ScrollPane);
					ScrollPane.setBounds(19, 131, 462, 187);
					{
						String colunas[] = { "Código", "Nome", "Telefone",
								"CPF", "E-mail" };
						TableClienteModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						TableCliente = new JTable();
						ScrollPane.setViewportView(TableCliente);
						TableCliente.setModel(TableClienteModel);

						TableCliente.getColumnModel().getColumn(0)
								.setPreferredWidth(10);
						TableCliente.getColumnModel().getColumn(1)
								.setPreferredWidth(40);
						TableCliente.getColumnModel().getColumn(2)
								.setPreferredWidth(15);
						TableCliente.getColumnModel().getColumn(3)
								.setPreferredWidth(13);
						TableCliente.getColumnModel().getColumn(4)
								.setPreferredWidth(70);
					}
				}
				{
					jLabel1 = new JLabel();
					PanelPesquisa.add(jLabel1);
					jLabel1.setText("Nome do Cliente");
					jLabel1.setBounds(19, 82, 169, 14);
				}
				{
					btAlterar = new JButton();
					PanelPesquisa.add(btAlterar);
					btAlterar.setText("Alterar");
					btAlterar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/user_edit (2).png")));
					btAlterar.setBounds(301, 325, 86, 24);
					btAlterar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int linhaSelecionada = TableCliente
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane.showMessageDialog(null,
										"Selecione uma linha para alterar!");
							} else {
								Object obj = TableCliente.getValueAt(
										TableCliente.getSelectedRow(), 0);
								int codigo;
								String cd;
								cd = String.valueOf(obj);
								codigo = Integer.parseInt(cd);
								try {
									cVo = cBo.DescobrirCliente(codigo);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Alterar_Cliente inst = new Alterar_Cliente(cVo);
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
								atualizaGrid();
							}

						}
					});
				}
				{
					btListar = new JButton();
					PanelPesquisa.add(btListar);
					btListar.setText("Listar Todos");
					btListar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/document_comment_below.png")));
					btListar.setBounds(373, 94, 111, 24);
					btListar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGrid();
						}
					});
				}
				{
					lbTitulo = new JLabel();
					PanelPesquisa.add(lbTitulo);
					lbTitulo.setText("Cadastro de Cliente");
					lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/user_add.png")));
					lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 26));
					lbTitulo.setBounds(103, 14, 284, 57);
				}
				{
					btPesquisa = new JButton();
					PanelPesquisa.add(btPesquisa);
					btPesquisa.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisa.setBounds(318, 95, 49, 23);
					btPesquisa.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGridNome(tfNomeCadastrado.getText());

						}
					});
				}
				{
					btInserir = new JButton();
					PanelPesquisa.add(btInserir);
					btInserir.setText("Inserir");
					btInserir.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/user_add16.png")));
					btInserir.setBounds(208, 325, 87, 24);
					btInserir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Inserir_Cliente inst = new Inserir_Cliente();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
							dispose();

						}
					});
				}
				{
					btVisualizar = new JButton();
					PanelPesquisa.add(btVisualizar);
					btVisualizar.setText("Detalhar");
					btVisualizar
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/legend.png")));
					btVisualizar.setBounds(109, 325, 93, 24);
					btVisualizar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int linhaSelecionada = TableCliente
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane
										.showMessageDialog(null,
												"Selecione uma linha para visualizar mais detalhes!");
							} else {
								Object obj = TableCliente.getValueAt(
										TableCliente.getSelectedRow(), 0);

								String cd;
								int i;
								cd = String.valueOf(obj);
								i = Integer.parseInt(cd);
								cVo = new Cliente();
								try {
									cVo = cBo.DescobrirCliente(i);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}

								Inserir_Cliente inst = new Inserir_Cliente(cVo);
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);

							}
						}
					});
				}
				{
					btSair = new JButton();
					PanelPesquisa.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(20, 325, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
				{
					tfNomeCadastrado = new JTextField();
					PanelPesquisa.add(tfNomeCadastrado);
					tfNomeCadastrado.setBounds(19, 96, 293, 20);
					tfNomeCadastrado.addKeyListener(new KeyListener() {

						@Override
						public void keyTyped(KeyEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void keyPressed(KeyEvent s) {
							if (s.getKeyCode() == 10) {
								atualizaGridNome(tfNomeCadastrado.getText());
							}

						}
					});
				}
				{
					btExcluir = new JButton();
					PanelPesquisa.add(btExcluir);
					btExcluir.setText("Excluir");
					btExcluir.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/user_delete.png")));
					btExcluir.setOpaque(false);
					btExcluir.setBounds(393, 325, 88, 24);
					btExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int linhaSelecionada = TableCliente
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane.showMessageDialog(null,
										"Selecione uma cliente para excluir!");
							} else {
								if (JOptionPane.showOptionDialog(null,
										"Deseja excluir esse cliente?", "",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										null, null) == 0) {
									// para pegar o codigo que está na
									// tabela e apartir dele excluir no
									// BD
									Object obj = TableCliente.getValueAt(
											TableCliente.getSelectedRow(), 0);
									int codigo;
									String cd;
									cd = String.valueOf(obj);
									codigo = Integer.parseInt(cd);

									try {
										cBo.excluir(codigo);
									} catch (SQLException e) {
										e.printStackTrace();
									}
									JOptionPane.showMessageDialog(null,
											"Cliente excluído com sucesso!");
									atualizaGrid();

								}

							}

						}
					});
				}
			}
			pack();
			this.setSize(511, 398);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<Cliente> Cliente = null;
		cBo = new ClienteBo();
		try {

			Cliente = cBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableClienteModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente c : Cliente)
				TableClienteModel.addRow(c.toArray());
		}
	}

	private void atualizaGridNome(String nome) {
		List<Cliente> Cliente = null;
		cBo = new ClienteBo();
		try {
			Cliente = cBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableClienteModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente c : Cliente)
				TableClienteModel.addRow(c.toArray());
		}
	}

	public Cliente getCliente() {
		return cVo;
	}

}
