package br.com.salao.view.Fornecedor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.salao.bo.ProdutoBo;
import br.com.salao.vo.ProdutoVo;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Selecionar_Produto extends javax.swing.JDialog {
	private JPanel PanelPesquisa;
	private JScrollPane ScrollPane;
	private JButton btListar;
	private JButton jButton1;
	private JTextField tfNomeCadastrado;
	private JButton btSelecionar;
	private JLabel lbSelecionarProduto;
	private JButton btSair;
	private JLabel jLabel1;
	private JTable TableProduto;
	private DefaultTableModel TableProdutoModel;
	private ProdutoBo produtoBo;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				Selecionar_Produto inst = new Selecionar_Produto(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public Selecionar_Produto(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Selecionar Produto");
			}
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
					btListar = new JButton();
					PanelPesquisa.add(btListar);
					btListar.setText("Listar Todos");
					btListar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/document_comment_below.png")));
					btListar.setBounds(373, 94, 111, 24);
					btListar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGrid();
						}
					});
				}
				{
					jButton1 = new JButton();
					PanelPesquisa.add(jButton1);
					jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					jButton1.setBounds(318, 95, 49, 23);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGridNome(tfNomeCadastrado.getText());
							
						}
					});
				}
				{
					btSair = new JButton();
					PanelPesquisa.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(399, 324, 83, 24);
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
				}
				{
					lbSelecionarProduto = new JLabel();
					PanelPesquisa.add(lbSelecionarProduto);
					lbSelecionarProduto.setText("Selecionar Produto");
					lbSelecionarProduto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/cart_full.png")));
					lbSelecionarProduto.setBounds(95, 30, 285, 32);
					lbSelecionarProduto.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
				{
					btSelecionar = new JButton();
					PanelPesquisa.add(btSelecionar);
					btSelecionar.setText("Selecionar");
					btSelecionar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/hand_point_090.png")));
					btSelecionar.setBounds(19, 324, 101, 25);
				}
			}
			this.setSize(508, 393);
		} catch (Exception e) {
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
