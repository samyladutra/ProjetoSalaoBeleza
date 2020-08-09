package br.com.salao.view.Fornecedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class Cadastro_Fornecedor extends javax.swing.JFrame {
	private JPanel Panel;
	private JTextField tfNome;
	private JTable TableFornecedor;
	private JScrollPane ScrollPane;
	private JButton btListartodos;
	private JButton btPesquisa;
	private JLabel lbNome;
	private JLabel lbTitulo;
	private DefaultTableModel TableModel;
	private JButton btSair;
	private JButton btInserir;
	private JButton btEscluir;
	private JButton jButton1;
	private JButton btVisualizar;

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
				Cadastro_Fornecedor inst = new Cadastro_Fornecedor();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Cadastro_Fornecedor() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Cadastro de Fornecedor");
				{
					Panel = new JPanel();
					getContentPane().add(Panel);
					Panel.setLayout(null);
					Panel.setBounds(0, 0, 500, 332);
					{
						lbTitulo = new JLabel();
						Panel.add(lbTitulo);
						lbTitulo.setText("Cadastro de Fornecedor");
						lbTitulo.setBounds(109, 12, 302, 55);
						lbTitulo.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/reseller_account_template.png")));
						lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 24));
					}
					{
						lbNome = new JLabel();
						Panel.add(lbNome);
						lbNome.setText("Nome do Fornecedor");
						lbNome.setBounds(10, 73, 149, 14);
					}
					{
						tfNome = new JTextField();
						Panel.add(tfNome);
						tfNome.setBounds(10, 87, 320, 20);
					}
					{
						btPesquisa = new JButton();
						Panel.add(btPesquisa);
						btPesquisa.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btPesquisa.setBounds(336, 85, 35, 24);
					}
					{
						btListartodos = new JButton();
						Panel.add(btListartodos);
						btListartodos.setText("Listar Todos");
						btListartodos.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/document_comment_below.png")));
						btListartodos.setBounds(377, 85, 111, 24);
					}
					{
						ScrollPane = new JScrollPane();
						Panel.add(ScrollPane);
						ScrollPane.setBounds(10, 118, 478, 166);
						{

							TableModel TableModel = new DefaultTableModel(
									new String[][] { { "1", "Willian",
											"(31)87336579", "25/08/2013",
											"Shampoo" } }, new String[] {
											"Código", "Nome", "Telefone",
											"Data Passagem", "Produto" });
							TableFornecedor = new JTable();
							ScrollPane.setViewportView(TableFornecedor);
							TableFornecedor.setModel(TableModel);

							/*
							 * String colunas[] = { "Nome", "Telefone",
							 * "Empresa", "Produto", "Data de Passagem" };
							 * TableModel = new DefaultTableModel(colunas, 0) {
							 * 
							 * @Override public boolean isCellEditable(int row,
							 * int column) { return false; } };
							 * 
							 * TableFornecedor = new JTable();
							 * ScrollPane.setViewportView(TableFornecedor);
							 * TableFornecedor.setModel(TableModel);
							 * 
							 * TableFornecedor.getColumnModel().getColumn(0)
							 * .setPreferredWidth(45);
							 * TableFornecedor.getColumnModel().getColumn(1)
							 * .setPreferredWidth(15);
							 * TableFornecedor.getColumnModel().getColumn(2)
							 * .setPreferredWidth(20);
							 * TableFornecedor.getColumnModel().getColumn(3)
							 * .setPreferredWidth(15);
							 * TableFornecedor.getColumnModel().getColumn(4)
							 * .setPreferredWidth(25);
							 */
						}
					}
					{
						btVisualizar = new JButton();
						Panel.add(btVisualizar);
						btVisualizar.setText("Detalhar");
						btVisualizar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btVisualizar.setBounds(99, 300, 97, 24);
					}
					{
						jButton1 = new JButton();
						Panel.add(jButton1);
						jButton1.setText("Alterar");
						jButton1.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/alterar.png")));
						jButton1.setBounds(402, 300, 86, 24);
						jButton1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Fornecedor_Alterar inst = new Fornecedor_Alterar();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}
						});
					}
					{
						btEscluir = new JButton();
						Panel.add(btEscluir);
						btEscluir.setText("Excluir");
						btEscluir.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/AApagar.png")));
						btEscluir.setBounds(310, 300, 86, 24);
						btEscluir.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if (JOptionPane.showOptionDialog(null,
										"Deseja excluir esse produto?", "",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										null, null) == 0) {
									JOptionPane.showMessageDialog(null,
											"Fornecedor Excluído com sucesso!");
								}

							}
						});
					}
					{
						btInserir = new JButton();
						Panel.add(btInserir);
						btInserir.setText("Inserir");
						btInserir.setBounds(204, 300, 100, 24);
						btInserir.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/reseller_account (2).png")));
					}
					{
						btSair = new JButton();
						Panel.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/door_out.png")));
						btSair.setBounds(10, 300, 83, 24);
						btSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();

							}
						});
					}
				}
			}
			this.setSize(516, 381);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
