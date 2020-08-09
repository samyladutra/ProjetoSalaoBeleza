package br.com.salao.view.Venda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import br.com.salao.bo.ProdutoBo;
import br.com.salao.bo.ServicoBo;
import br.com.salao.vo.ProdutoVo;
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
public class Selecionar_Item extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JRadioButton RbProduto;
	private JTextField tfNomeItem;
	private JButton btPesquisaItem;
	private JLabel lbNmItem;
	private JButton btSair;
	private JButton btSelecionar;
	private JTable TableItens;
	private JScrollPane ScrollPane;
	private JButton btListarTodos;
	private JRadioButton RbServico;
	private JLabel lbSelecionarItens;
	private DefaultTableModel TableItemModel;
	private ProdutoBo produtoBo;
	private ServicoBo sBo;
	private ProdutoVo pVo;
	private ServicoVo sVo;
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
				Selecionar_Item inst = new Selecionar_Item();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Selecionar_Item() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Selecionar Ítens");
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbSelecionarItens = new JLabel();
					PanelTotal.add(lbSelecionarItens);
					lbSelecionarItens.setText("Selecionar Ítens");
					lbSelecionarItens.setBounds(117, 23, 200, 39);
					lbSelecionarItens.setFont(new java.awt.Font("Lucida Sans",
							0, 24));
				}
				{
					RbProduto = new JRadioButton();
					PanelTotal.add(RbProduto);
					RbProduto.setText("Produto");
					RbProduto.setBounds(10, 74, 63, 23);
				}
				{
					RbServico = new JRadioButton();
					PanelTotal.add(RbServico);
					RbServico.setText("Serviço");
					RbServico.setBounds(79, 74, 61, 23);
				}
				ButtonGroup btGroup = new ButtonGroup();
				btGroup.add(RbProduto);
				btGroup.add(RbServico);
				{
					tfNomeItem = new JTextField();
					PanelTotal.add(tfNomeItem);
					tfNomeItem.setBounds(10, 114, 251, 20);
					tfNomeItem.addKeyListener(new KeyListener() {

						@Override
						// clicou-soltou
						public void keyTyped(KeyEvent arg0) {

						}

						@Override
						// quando o botao é solto
						public void keyReleased(KeyEvent arg0) {

						}

						@Override
						// quando o botao é pressionado
						public void keyPressed(KeyEvent s) {
							if (s.getKeyCode() == 10) {
								if (RbProduto.isSelected()) {
									if (tfNomeItem.getText().equals("")) {
										JOptionPane.showMessageDialog(null,
												"Digite o nome do Produto");
									} else {
										atualizaGridNomeProduto(tfNomeItem
												.getText());
									}
								} else {
									if (RbServico.isSelected()) {
										if (tfNomeItem.getText().equals("")) {
											JOptionPane.showMessageDialog(null,
													"Digite o nome do Serviço");
										} else {
											atualizaGridNomeServico(tfNomeItem
													.getText());
										}
									}
								}
							}

						}
					});
				}
				{
					btPesquisaItem = new JButton();
					PanelTotal.add(btPesquisaItem);
					btPesquisaItem.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisaItem.setBounds(267, 111, 39, 24);
					btPesquisaItem.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if (RbProduto.isSelected()) {
								if (tfNomeItem.getText().equals("")) {
									JOptionPane.showMessageDialog(null,
											"Digite o nome do Produto");
								} else {
									atualizaGridNomeProduto(tfNomeItem
											.getText());
								}
							} else {
								if (RbServico.isSelected()) {
									if (tfNomeItem.getText().equals("")) {
										JOptionPane.showMessageDialog(null,
												"Digite o nome do Serviço");
									} else {
										atualizaGridNomeServico(tfNomeItem
												.getText());
									}

								} else {
									JOptionPane
											.showMessageDialog(null,
													"Selecione o tipo do ítem desejado!");
								}
							}

						}
					});
				}
				{
					btListarTodos = new JButton();
					PanelTotal.add(btListarTodos);
					btListarTodos.setText("Listar Todos");
					btListarTodos.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/document_comment_below.png")));
					btListarTodos.setBounds(312, 111, 111, 24);
					btListarTodos.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if ((RbProduto.isSelected())
									|| (RbServico.isSelected())) {

								if (RbProduto.isSelected()) {
									atualizaGridProduto();
								} else {
									if (RbServico.isSelected()) {
										atualizaGridServico();

									}
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Selecione o tipo de ítem primeiro");

							}
						}
					});
				}
				{
					ScrollPane = new JScrollPane();
					PanelTotal.add(ScrollPane);
					ScrollPane.setBounds(10, 145, 413, 148);
				}
				{
					btSelecionar = new JButton();
					PanelTotal.add(btSelecionar);
					btSelecionar.setText("Selecionar");
					btSelecionar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/hand_point_090.png")));
					btSelecionar.setBounds(10, 299, 101, 24);
					btSelecionar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Object obj = TableItens.getValueAt(
									TableItens.getSelectedRow(), 0);

							String cd;
							int i;
							cd = String.valueOf(obj);
							i = Integer.parseInt(cd);
							if (RbProduto.isSelected()) {
								pVo = new ProdutoVo();
								try {
									pVo = produtoBo.DescobrirProduto(i);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								// Venda_Itens.tfCdItem.setText(String.valueOf(pVo
								// .getCdProduto()));
								// Venda_Itens.tfProduto.setText(pVo
								// .getNmProduto());
							} else {
								sVo = new ServicoVo();
								try {
									sVo = sBo.DescobreServico(i);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								// Venda_Itens.tfCdItem.setText(String.valueOf(sVo
								// .getCodigo()));
								// Venda_Itens.tfProduto.setText(sVo.getNome());
							}
							dispose();

						}
					});
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(338, 299, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
				{
					lbNmItem = new JLabel();
					PanelTotal.add(lbNmItem);
					lbNmItem.setText("Nome");
					lbNmItem.setBounds(10, 99, 27, 14);
				}
			}
			this.setSize(451, 372);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void atualizaGridProduto() {
		reformulaTableProduto();
		List<ProdutoVo> ProdutoVo = null;
		produtoBo = new ProdutoBo();
		try {

			ProdutoVo = produtoBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableItemModel.setNumRows(0);
		if (ProdutoVo != null) {
			for (ProdutoVo produto : ProdutoVo)
				TableItemModel.addRow(produto.toArray());
		}
	}

	private void atualizaGridNomeProduto(String nome) {
		reformulaTableProduto();
		List<ProdutoVo> ProdutoVo = null;
		produtoBo = new ProdutoBo();
		try {
			ProdutoVo = produtoBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableItemModel.setNumRows(0);
		if (ProdutoVo != null) {
			for (ProdutoVo produto : ProdutoVo)
				TableItemModel.addRow(produto.toArray());
		}
	}

	private void atualizaGridServico() {
		reformulaTableServico();
		List<ServicoVo> servicos = null;
		sBo = new ServicoBo();
		try {
			servicos = sBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableItemModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TableItemModel.addRow(servico.toArray());
		}
	}

	private void atualizaGridNomeServico(String nome) {
		reformulaTableServico();
		List<ServicoVo> servicos = null;
		sBo = new ServicoBo();
		try {
			servicos = sBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableItemModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TableItemModel.addRow(servico.toArray());
		}
	}

	private void reformulaTableServico() {
		String colunas[] = { "Código", "Nome", "Duração (min)", "Preço" };
		TableItemModel = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		TableItens = new JTable();
		ScrollPane.setViewportView(TableItens);
		TableItens.setModel(TableItemModel);

		TableItens.getColumnModel().getColumn(0).setPreferredWidth(10);
		TableItens.getColumnModel().getColumn(1).setPreferredWidth(50);
		TableItens.getColumnModel().getColumn(2).setPreferredWidth(15);
		TableItens.getColumnModel().getColumn(3).setPreferredWidth(20);
		TableItens.setPreferredSize(new java.awt.Dimension(413, 147));
	}

	private void reformulaTableProduto() {
		String colunas[] = { "Código", "Nome", "Descrição", "Preço" };
		TableItemModel = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		TableItens = new JTable();
		ScrollPane.setViewportView(TableItens);
		TableItens.setModel(TableItemModel);

		TableItens.getColumnModel().getColumn(0).setPreferredWidth(10);
		TableItens.getColumnModel().getColumn(1).setPreferredWidth(35);
		TableItens.getColumnModel().getColumn(2).setPreferredWidth(75);
		TableItens.getColumnModel().getColumn(3).setPreferredWidth(13);

	}

	/*
	 * private void atualizaGridItem() { List<ItemVo> itens = null; iBo = new
	 * ItemBo(); try { itens = iBo.ListaItem(); } catch (SQLException e) {
	 * e.printStackTrace(); } TableItemModel.setNumRows(0); if (itens != null) {
	 * for (ItemVo item : itens) TableItemModel.addRow(item.toArray()); } }
	 */
}
