package br.com.salao.view.Relatórios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

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
public class Relatório_Gastos extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JTextField tfValor1;
	private JCheckBox CheckBoxValor;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JButton btFiltrar;
	private JButton btCancelar;
	private JButton btRelatorio;
	private JButton btSair;
	private JTable TableGasto;
	private JScrollPane ScrollPane;
	private JTextField tfValor2;
	private JLabel lba;
	private JTextField tfDtInicial;
	private JLabel lbDtInicial;
	private JPanel PanelPeriodo;
	private JTextField tfTipo;
	private JCheckBox CheckBoxTipo;
	private ButtonGroup btGroup;
	private JPanel PanelFiltro;
	private JLabel lbRelatorioGastos;
	private DefaultTableModel TableGastoModel;

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
				Relatório_Gastos inst = new Relatório_Gastos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Relatório_Gastos() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Relatório de Gastos");
			this.setResizable(false);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")).getImage());
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbRelatorioGastos = new JLabel();
					PanelTotal.add(lbRelatorioGastos);
					lbRelatorioGastos.setText("Relatório de Gastos");
					lbRelatorioGastos
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/blogs32.png")));
					lbRelatorioGastos.setBounds(178, 22, 295, 42);
					lbRelatorioGastos.setFont(new java.awt.Font("Lucida Sans",
							0, 24));
				}
				{
					PanelPeriodo = new JPanel();
					PanelPeriodo.setBounds(279, 75, 331, 92);
					PanelPeriodo.setLayout(null);
					PanelPeriodo
							.setBorder(BorderFactory.createTitledBorder("Período"));
				}
				{
					PanelFiltro = new JPanel();
					PanelTotal.add(PanelFiltro);
					PanelTotal.add(PanelPeriodo);
					{
						ScrollPane = new JScrollPane();
						PanelTotal.add(ScrollPane);
						ScrollPane.setBounds(10, 178, 595, 136);
						{
							String colunas[] = { "Código", "Tipo", "Valor",
									"Data" };
							TableGastoModel = new DefaultTableModel(colunas, 0) {
								@Override
								public boolean isCellEditable(int row, int column) {
									return false;
								}
							};
							
							TableGasto = new JTable();
							ScrollPane.setViewportView(TableGasto);
							TableGasto.setModel(TableGastoModel);

							TableGasto.getColumnModel().getColumn(0)
									.setPreferredWidth(10);
							TableGasto.getColumnModel().getColumn(1)
									.setPreferredWidth(35);
							TableGasto.getColumnModel().getColumn(2)
									.setPreferredWidth(15);
							TableGasto.getColumnModel().getColumn(3)
									.setPreferredWidth(20);
						}
					}
					{
						btSair = new JButton();
						PanelTotal.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
						btSair.setBounds(10, 325, 71, 24);
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
						btRelatorio.setBounds(409, 325, 95, 24);
					}
					{
						btCancelar = new JButton();
						PanelTotal.add(btCancelar);
						btCancelar.setText("Cancelar");
						btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Retiraar.png")));
						btCancelar.setBounds(510, 325, 95, 24);
						btCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evento) {
								tfDtFinal.setText("");
								tfDtInicial.setText("");
								tfTipo.setText("");
								tfValor1.setText("");
								tfValor2.setText("");
							}
						});
					}
					{
						lbDtInicial = new JLabel();
						PanelPeriodo.add(lbDtInicial);
						lbDtInicial.setText("Data Inicial");
						lbDtInicial.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
						lbDtInicial.setBounds(16, 32, 73, 16);
					}
					{
						tfDtInicial = new JTextField();
						PanelPeriodo.add(tfDtInicial);
						tfDtInicial.setBounds(16, 47, 102, 20);
					}
					{
						lbDtFinal = new JLabel();
						PanelPeriodo.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
						lbDtFinal.setBounds(126, 32, 68, 16);
					}
					{
						tfDtFinal = new JTextField();
						PanelPeriodo.add(tfDtFinal);
						tfDtFinal.setBounds(126, 47, 105, 20);
					}
					{
						btFiltrar = new JButton();
						PanelPeriodo.add(btFiltrar);
						btFiltrar.setText("Filtrar");
						btFiltrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/filter (2).png")));
						btFiltrar.setBounds(241, 46, 81, 25);
						btFiltrar.setSize(81, 24);
					}
					PanelFiltro.setBounds(10, 75, 263, 92);
					PanelFiltro.setLayout(null);
					PanelFiltro.setBorder(BorderFactory
							.createTitledBorder("Filtros"));
					{
						CheckBoxTipo = new JCheckBox();
						PanelFiltro.add(CheckBoxTipo);
						CheckBoxTipo.setText("Tipo do gasto:");
						CheckBoxTipo.setBounds(6, 26, 96, 23);
					}
					{
						tfTipo = new JTextField();
						PanelFiltro.add(tfTipo);
						tfTipo.setBounds(104, 26, 148, 22);
					}
					{
						CheckBoxValor = new JCheckBox();
						PanelFiltro.add(CheckBoxValor);
						CheckBoxValor.setText("Valor");
						CheckBoxValor.setBounds(6, 56, 49, 23);
					}
					{
						tfValor1 = new JTextField();
						PanelFiltro.add(tfValor1);
						tfValor1.setBounds(104, 57, 67, 20);
					}
					{
						lba = new JLabel();
						PanelFiltro.add(lba);
						lba.setText("à");
						lba.setBounds(175, 64, 10, 14);
					}
					{
						tfValor2 = new JTextField();
						PanelFiltro.add(tfValor2);
						tfValor2.setBounds(185, 57, 62, 20);
						tfValor2.setSize(67, 20);
					}
				}
			}
			pack();
			this.setSize(631, 398);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
