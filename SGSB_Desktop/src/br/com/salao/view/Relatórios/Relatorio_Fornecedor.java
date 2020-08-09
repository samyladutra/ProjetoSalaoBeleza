package br.com.salao.view.Relatórios;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
public class Relatorio_Fornecedor extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JButton btFiltrar;
	private JButton btCancelar;
	private JButton btRelatorio;
	private JButton btSair;
	private JTable TableFornecedor;
	private JScrollPane ScrollPane;
	private JRadioButton RbTodos;
	private JButton btPesquisaProd;
	private JTextField tfProdutoFornecido;
	private JCheckBox CheckBoxVendedor;
	private JPanel PanelFiltro;
	private JLabel lbRelatorioForn;
	private DefaultTableModel TableFornecedorModel;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Relatorio_Fornecedor inst = new Relatorio_Fornecedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Relatorio_Fornecedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Relatório de Fornecedor");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")).getImage());
			this.setResizable(false);
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setPreferredSize(new java.awt.Dimension(544, 396));
				{
					lbRelatorioForn = new JLabel();
					PanelTotal.add(lbRelatorioForn);
					lbRelatorioForn.setText("Relatório de Fornecedor");
					lbRelatorioForn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")));
					lbRelatorioForn.setBounds(88, 34, 342, 42);
					lbRelatorioForn.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
				{
					PanelFiltro = new JPanel();
					PanelTotal.add(PanelFiltro);
					PanelFiltro.setBounds(79, 87, 351, 99);
					PanelFiltro.setLayout(null);
					PanelFiltro.setBorder(BorderFactory.createTitledBorder("Exibir"));
					{
						CheckBoxVendedor = new JCheckBox();
						PanelFiltro.add(CheckBoxVendedor);
						CheckBoxVendedor.setText("Fornece produto:");
						CheckBoxVendedor.setBounds(16, 31, 109, 23);
					}
					{
						tfProdutoFornecido = new JTextField();
						PanelFiltro.add(tfProdutoFornecido);
						tfProdutoFornecido.setBounds(127, 32, 150, 20);
					}
					{
						btPesquisaProd = new JButton();
						PanelFiltro.add(btPesquisaProd);
						btPesquisaProd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
						btPesquisaProd.setBounds(280, 29, 33, 24);
					}
					{
						RbTodos = new JRadioButton();
						PanelFiltro.add(RbTodos);
						RbTodos.setText("Todos");
						RbTodos.setBounds(16, 56, 55, 23);
					}
					{
						btFiltrar = new JButton();
						PanelFiltro.add(btFiltrar);
						btFiltrar.setText("Filtrar");
						btFiltrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/filter (2).png")));
						btFiltrar.setBounds(232, 64, 81, 25);
					}
				}
				{
					ScrollPane = new JScrollPane();
					PanelTotal.add(ScrollPane);
					ScrollPane.setBounds(10, 197, 529, 164);
					{
						String colunas[] = { "Código","Nome",
								"Produtos que revende", "Data de Passagem" };
						TableFornecedorModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						
						TableFornecedor = new JTable();
						ScrollPane.setViewportView(TableFornecedor);
						TableFornecedor.setModel(TableFornecedorModel);

						TableFornecedor.getColumnModel().getColumn(0)
								.setPreferredWidth(10);
						TableFornecedor.getColumnModel().getColumn(1)
								.setPreferredWidth(55);
						TableFornecedor.getColumnModel().getColumn(2)
								.setPreferredWidth(25);
						TableFornecedor.getColumnModel().getColumn(3)
								.setPreferredWidth(20);
					}
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(10, 367, 77, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					btRelatorio = new JButton();
					PanelTotal.add(btRelatorio);
					btRelatorio.setText("Relatório");
					btRelatorio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/page_white_stack.png")));
					btRelatorio.setBounds(343, 367, 95, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Retiraar.png")));
					btCancelar.setBounds(444, 367, 95, 24);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {
						}
					});
				}
			}
			pack();
			this.setSize(561, 435);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
