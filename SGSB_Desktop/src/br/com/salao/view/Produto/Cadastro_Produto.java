package br.com.salao.view.Produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import br.com.salao.bo.ProdutoBo;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.RelatorioDao;
import br.com.salao.vo.MarcaVo;
import br.com.salao.vo.ProdutoVo;

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
public class Cadastro_Produto extends javax.swing.JFrame {
	private JPanel PanelPesquisa;
	private JScrollPane ScrollPane;
	private JLabel lbTitulo;
	private JButton btListar;
	private JButton btAlterar;
	private JLabel jLabel1;
	private JTable TableProduto;
	private ProdutoVo produtoVo;
	private ProdutoBo produtoBo;
	private JButton btExcluir;
	private JTextField tfNomeCadastrado;
	private JButton btSair;
	private JButton btVisualizar;
	private JButton btInserir;
	private JButton jButton1;
	private DefaultTableModel TableProdutoModel;

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
				Cadastro_Produto inst = new Cadastro_Produto();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Cadastro_Produto() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			this.setTitle("Consultar Produto");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/cart_full.png")).getImage());
			{
				PanelPesquisa = new JPanel();
				getContentPane().add(PanelPesquisa);
				PanelPesquisa.setLayout(null);
				PanelPesquisa.setBounds(0, 0, 492, 355);
				{
					ScrollPane = new JScrollPane();
					PanelPesquisa.add(ScrollPane);
					ScrollPane.setBounds(19, 131, 462, 187);
					{
						String colunas[] = { "Código", "Nome", "Marca",
								"Preço", "Descrição" };
						TableProdutoModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						TableProduto = new JTable();
						ScrollPane.setViewportView(TableProduto);
						TableProduto.setModel(TableProdutoModel);

						TableProduto.getColumnModel().getColumn(0)
								.setPreferredWidth(10);
						TableProduto.getColumnModel().getColumn(1)
								.setPreferredWidth(35);
						TableProduto.getColumnModel().getColumn(2)
								.setPreferredWidth(15);
						TableProduto.getColumnModel().getColumn(3)
								.setPreferredWidth(13);
						TableProduto.getColumnModel().getColumn(4)
								.setPreferredWidth(70);
					}
				}
				{
					jLabel1 = new JLabel();
					PanelPesquisa.add(jLabel1);
					jLabel1.setText("Nome do Produto");
					jLabel1.setBounds(19, 82, 169, 14);
				}
				{
					btAlterar = new JButton();
					PanelPesquisa.add(btAlterar);
					btAlterar.setText("Alterar");
					btAlterar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/cart_edit.png")));
					btAlterar.setBounds(301, 325, 86, 24);
					btAlterar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int linhaSelecionada = TableProduto
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane.showMessageDialog(null,
										"Selecione uma linha para alterar!");
							} else {
								Object obj = TableProduto.getValueAt(
										TableProduto.getSelectedRow(), 0);
								int codigo;
								String cd;
								cd = String.valueOf(obj);
								codigo = Integer.parseInt(cd);
								try {
									produtoVo = produtoBo
											.DescobrirProduto(codigo);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								Alterar_Produto inst = new Alterar_Produto(
										produtoVo);
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
					lbTitulo.setText("Cadastro de Produto");
					lbTitulo.setBounds(103, 14, 284, 57);
					lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 26));
					lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/cart_full.png")));
				}
				{
					jButton1 = new JButton();
					PanelPesquisa.add(jButton1);
					jButton1.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/pesquisar.png")));
					jButton1.setBounds(318, 95, 49, 23);
					jButton1.addActionListener(new ActionListener() {

						@Override
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
							.getResource("Icones/cart_add.png")));
					btInserir.setBounds(208, 325, 87, 24);
					btInserir.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							Inserir_Produto inst = new Inserir_Produto();
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
							int linhaSelecionada = TableProduto
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane
										.showMessageDialog(null,
												"Selecione uma linha para visualizar mais detalhes!");
							} else {
								Object obj = TableProduto.getValueAt(
										TableProduto.getSelectedRow(), 0);

								String cd;
								int i;
								cd = String.valueOf(obj);
								i = Integer.parseInt(cd);
								produtoVo = new ProdutoVo();
								try {
									produtoVo = produtoBo.DescobrirProduto(i);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}

								Inserir_Produto inst = new Inserir_Produto(
										produtoVo);
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
							.getResource("Icones/cart_delete.png")));
					btExcluir.setOpaque(false);
					btExcluir.setBounds(393, 325, 88, 24);
					btExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int linhaSelecionada = TableProduto
									.getSelectedRow();
							if (linhaSelecionada < 0) {
								JOptionPane.showMessageDialog(null,
										"Selecione uma linha para excluir!");
							} else {
								if (JOptionPane.showOptionDialog(null,
										"Deseja excluir esse produto?", "",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										null, null) == 0) {
									// para pegar o codigo que está na
									// tabela e apartir dele excluir no
									// BD
									Object obj = TableProduto.getValueAt(
											TableProduto.getSelectedRow(), 0);
									int codigo;
									String cd;
									cd = String.valueOf(obj);
									codigo = Integer.parseInt(cd);

									try {
										produtoBo.excluir(codigo);
									} catch (SQLException e) {
										// TODO Auto-generated catch
										// block
										e.printStackTrace();
									}
									JOptionPane.showMessageDialog(null,
											"Produto excluído com sucesso!");
									atualizaGrid();

								}

							}

						}
					});
				}
			}
			pack();
			this.setSize(508, 393);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<ProdutoVo> ProdutoVo = null;
		produtoBo = new ProdutoBo();
		try {

			ProdutoVo = produtoBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableProdutoModel.setNumRows(0);
		if (ProdutoVo != null) {
			for (ProdutoVo produto : ProdutoVo)
				TableProdutoModel.addRow(produto.toArray());
		}
	}

	private void atualizaGridNome(String nome) {
		List<ProdutoVo> ProdutoVo = null;
		produtoBo = new ProdutoBo();
		try {
			ProdutoVo = produtoBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableProdutoModel.setNumRows(0);
		if (ProdutoVo != null) {
			for (ProdutoVo produto : ProdutoVo)
				TableProdutoModel.addRow(produto.toArray());
		}
	}

}
