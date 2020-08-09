package br.com.salao.view.Relatórios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;

import br.com.salao.bo.ItemBo;
import br.com.salao.bo.ProdutoBo;
import br.com.salao.bo.RelatorioBo;
import br.com.salao.dao.RelatorioDao;
import br.com.salao.vo.Cliente;
import br.com.salao.vo.ItemVo;
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
public class Relatório_Produto extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JRadioButton RbuttonTodos;
	private JRadioButton RbuttonArea;
	private JTextField tfPrecoFinal;
	private JLabel lba;
	private JButton btSair;
	private JTable TableRelatorio;
	private JScrollPane ScrollPane;
	private JButton btFiltrar;
	private JButton btCancelar;
	private JButton btRelatorio;
	private JTextField tfArea;
	private JTextField tfPrecoInicial;
	private JRadioButton RbuttonPreco;
	private JTextField tfNomeMarca;
	private JRadioButton RbuttonMarca;
	private ButtonGroup btGroupFiltro;
	private JPanel PanelFiltro;
	private JLabel lbEmitirRelatorio;
	private DefaultTableModel TableModel;
	private RelatorioBo relatorioBo;
	private ItemBo iBo;
	private ProdutoBo pBo;
	private ProdutoVo pVo;

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
				Relatório_Produto inst = new Relatório_Produto();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Relatório_Produto() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Relatório de Produto");
			this.setResizable(false);
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/blogs32.png")).getImage());
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbEmitirRelatorio = new JLabel();
					PanelTotal.add(lbEmitirRelatorio);
					lbEmitirRelatorio.setText("Relatório de Produtos");
					lbEmitirRelatorio
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/blogs32.png")));
					lbEmitirRelatorio.setBounds(127, 29, 290, 50);
					lbEmitirRelatorio.setFont(new java.awt.Font("Lucida Sans",
							0, 24));
				}
				{
					PanelFiltro = new JPanel();
					PanelTotal.add(PanelFiltro);
					PanelFiltro.setLayout(null);
					PanelFiltro.setBounds(23, 85, 489, 86);
					PanelFiltro.setBorder(BorderFactory
							.createTitledBorder("Filtros"));
					{
						RbuttonMarca = new JRadioButton();
						PanelFiltro.add(RbuttonMarca);
						RbuttonMarca.setText("Marca");
						RbuttonMarca.setBounds(20, 20, 55, 23);
						RbuttonMarca.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								tfNomeMarca.setEnabled(true);

							}
						});
					}
					{
						tfNomeMarca = new JTextField();
						PanelFiltro.add(tfNomeMarca);
						tfNomeMarca.setBounds(89, 21, 153, 20);
						tfNomeMarca.setEnabled(false);
					}
					{
						RbuttonTodos = new JRadioButton();
						PanelFiltro.add(RbuttonTodos);
						RbuttonTodos.setText("Todos");
						RbuttonTodos.setBounds(248, 46, 55, 23);
					}
					{
						RbuttonPreco = new JRadioButton();
						PanelFiltro.add(RbuttonPreco);
						RbuttonPreco.setText("Preço");
						RbuttonPreco.setBounds(20, 48, 53, 23);
					}
					{
						tfPrecoInicial = new JTextField();
						PanelFiltro.add(tfPrecoInicial);
						tfPrecoInicial.setBounds(89, 49, 65, 20);
						tfPrecoInicial.setEnabled(false);
					}
					{
						lba = new JLabel();
						PanelFiltro.add(lba);
						lba.setText("à");
						lba.setBounds(163, 56, 10, 14);
					}
					{
						tfPrecoFinal = new JTextField();
						PanelFiltro.add(tfPrecoFinal);
						tfPrecoFinal.setBounds(177, 49, 65, 20);
						tfPrecoFinal.setEnabled(false);
					}
					{
						RbuttonArea = new JRadioButton();
						PanelFiltro.add(RbuttonArea);
						RbuttonArea.setText("Area de Utilização");
						RbuttonArea.setBounds(248, 20, 111, 23);
					}
					{
						btFiltrar = new JButton();
						btFiltrar.setText("Filtrar");
						btFiltrar.setBounds(380, 51, 90, 24);
						btFiltrar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/filter (2).png")));
						btFiltrar.addActionListener(new ActionFiltrar());
					}
					{
						tfArea = new JTextField();
						PanelFiltro.add(tfArea);
						PanelFiltro.add(btFiltrar);
						tfArea.setBounds(361, 21, 109, 20);
						tfArea.setEnabled(false);
					}
				}
				{
					btRelatorio = new JButton();
					PanelTotal.add(btRelatorio);
					btRelatorio.setText("Relatório");
					btRelatorio.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/page_white_stack.png")));
					btRelatorio.setBounds(316, 400, 95, 24);
					btRelatorio.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							relatorioBo = new RelatorioBo();
							try {
								relatorioBo.GeraRelatorio();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/Retiraar.png")));
					btCancelar.setBounds(417, 400, 95, 24);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {

							tfArea.setText("");
							tfNomeMarca.setText("");
							tfPrecoFinal.setText("");
							tfPrecoInicial.setText("");
						}
					});
				}

				{
					ScrollPane = new JScrollPane();
					ScrollPane.setBounds(23, 182, 489, 207);
					ScrollPane.setViewportView(TableRelatorio);
				}

				{
					String colunas[] = { "Código", "Nome", "Marca", "Preço",
							"Descrição", "Qtd em estoque" };
					TableModel = new DefaultTableModel(colunas, 0) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};

					TableRelatorio = new JTable();
					ScrollPane.setViewportView(TableRelatorio);
					TableRelatorio.setModel(TableModel);

					TableRelatorio.getColumnModel().getColumn(0)
							.setPreferredWidth(10);
					TableRelatorio.getColumnModel().getColumn(1)
							.setPreferredWidth(35);
					TableRelatorio.getColumnModel().getColumn(2)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(3)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(4)
							.setPreferredWidth(15);
					TableRelatorio.getColumnModel().getColumn(5)
							.setPreferredWidth(10);
				}
				{
					btGroupFiltro = new ButtonGroup();
					btGroupFiltro.add(RbuttonArea);
					btGroupFiltro.add(RbuttonMarca);
					btGroupFiltro.add(RbuttonPreco);
					btGroupFiltro.add(RbuttonTodos);
				}

				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					PanelTotal.add(ScrollPane);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(23, 400, 71, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
			}
			pack();
			this.setSize(532, 465);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	
	private class ActionFiltrar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(RbuttonTodos.isSelected()){
				atualizaGrid();
			}
		}
		
	}
	
	
	private void atualizaGrid() {
		List<ProdutoVo> ProdutoVo = null;
		pBo = new ProdutoBo();
		try {
			ProdutoVo = pBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (ProdutoVo != null) {
			for (ProdutoVo produto : ProdutoVo)
				TableModel.addRow(produto.fillsTable());
		}
	}
}
