package br.com.salao.view.Pagamento;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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
public class Selecionar_Venda extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JRadioButton RbInicial;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JButton btPesquisar;
	private JButton btSelecionar;
	private JButton btSair;
	private JTextField tfDtInicial;
	private JLabel lbDtInicial;
	private JTable TableVendas;
	private JScrollPane ScrollPane;
	private JPanel PanelPeriodo;
	private JRadioButton RbAndamento;
	private JPanel PanelStatus;
	private JLabel lbSelecionarVenda;
	private DefaultTableModel TableVendasModel;

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
				JFrame frame = new JFrame();
				Selecionar_Venda inst = new Selecionar_Venda(frame);
				inst.setVisible(true);
			}
		});
	}

	public Selecionar_Venda(JFrame frame) {
		super(frame);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Selecionar Venda");
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbSelecionarVenda = new JLabel();
					PanelTotal.add(lbSelecionarVenda);
					lbSelecionarVenda.setText("Selecionar Venda");
					lbSelecionarVenda.setBounds(157, 21, 236, 41);
					lbSelecionarVenda.setFont(new java.awt.Font("Lucida Sans",
							0, 24));
				}
				{
					PanelStatus = new JPanel();
					PanelTotal.add(PanelStatus);
					PanelStatus.setBounds(10, 68, 174, 65);
					PanelStatus.setLayout(null);
					PanelStatus.setBorder(BorderFactory
							.createTitledBorder("Status"));
					{
						RbInicial = new JRadioButton();
						PanelStatus.add(RbInicial);
						RbInicial.setText("Inicial");
						RbInicial.setBounds(16, 25, 53, 23);
					}
					{
						RbAndamento = new JRadioButton();
						PanelStatus.add(RbAndamento);
						RbAndamento.setText("Andamento");
						RbAndamento.setBounds(75, 25, 81, 23);
					}
				}
				{
					PanelPeriodo = new JPanel();
					PanelTotal.add(PanelPeriodo);
					PanelPeriodo.setBounds(184, 68, 221, 65);
					PanelPeriodo.setLayout(null);
					PanelPeriodo.setBorder(BorderFactory
							.createTitledBorder("Período"));
					{
						lbDtInicial = new JLabel();
						PanelPeriodo.add(lbDtInicial);
						lbDtInicial.setText("Data Inicial");
						lbDtInicial.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
						lbDtInicial.setBounds(16, 20, 73, 16);
					}
					{
						tfDtInicial = new JTextField();
						PanelPeriodo.add(tfDtInicial);
						tfDtInicial.setBounds(16, 35, 91, 20);
					}
					{
						lbDtFinal = new JLabel();
						PanelPeriodo.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
						lbDtFinal.setBounds(115, 20, 68, 16);
					}
					{
						tfDtFinal = new JTextField();
						PanelPeriodo.add(tfDtFinal);
						tfDtFinal.setBounds(115, 35, 90, 20);
					}
				}
				{
					ScrollPane = new JScrollPane();
					PanelTotal.add(ScrollPane);
					ScrollPane.setBounds(10, 139, 497, 171);
					{

						String colunas[] = { "Data da Venda", "Cliente",
								"Item", "Total" };
						TableVendasModel = new DefaultTableModel(colunas, 0);

						TableVendas = new JTable();
						ScrollPane.setViewportView(TableVendas);
						TableVendas.setModel(TableVendasModel);

						TableVendas.getColumnModel().getColumn(0)
								.setPreferredWidth(15);
						TableVendas.getColumnModel().getColumn(1)
								.setPreferredWidth(40);
						TableVendas.getColumnModel().getColumn(2)
								.setPreferredWidth(50);
						TableVendas.getColumnModel().getColumn(3)
								.setPreferredWidth(15);
						ScrollPane
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre oculta
						ScrollPane
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					}
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(424, 316, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					btSelecionar = new JButton();
					PanelTotal.add(btSelecionar);
					btSelecionar.setText("Selecionar");
					btSelecionar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/hand_point_090.png")));
					btSelecionar.setBounds(10, 316, 101, 25);
				}
				{
					btPesquisar = new JButton();
					PanelTotal.add(btPesquisar);
					btPesquisar.setText("Pesquisar");
					btPesquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisar.setBounds(408, 91, 99, 24);
				}
			}
			this.setSize(533, 394);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
