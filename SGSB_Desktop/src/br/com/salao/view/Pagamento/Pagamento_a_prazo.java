package br.com.salao.view.Pagamento;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import br.com.salao.view.Venda.Consulta_Vendas;

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
public class Pagamento_a_prazo extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbProfissional;
	private JScrollPane ScrollPaneTableParcelas;
	private JLabel lbQuantParcelas;
	private JPanel PanelPascelasRestantes;
	private JLabel lbTotal;
	private JTextField tfTotal;
	private JComboBox ComboBoxParcelas;
	private JButton btRetirar;
	private JTable TableVendas;
	private JScrollPane ScrollPaneVendas;
	private JPanel PanelVendas;
	private JButton btSair;
	private JTable TableParcRestante;
	private JTextField tfValorRecebido;
	private JLabel lbValorRecebido;
	private JTextField tfTroco;
	private JLabel lbTroco;
	private JButton btPagarParcela;
	private JButton btCancelar;
	private JButton btRegistrar;
	private JButton btSelecionarVenda;
	private JComboBox ComboBoxProfi;
	private JTextField tfDtPagamento;
	private JLabel lbDtPagamento;
	private JLabel lbAstData;
	private JTextField tfCliente;
	private JLabel lbCliente;
	private JLabel lbAstCliente;
	private JButton btPesquisaCliente;
	private JLabel lbControle;
	private DefaultTableModel TableModel;

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
				Pagamento_a_prazo inst = new Pagamento_a_prazo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Pagamento_a_prazo() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Pagamento à prazo");
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbControle = new JLabel();
					PanelTotal.add(lbControle);
					lbControle.setText("Pagamento à Prazo");
					lbControle.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/cash_register.png")));
					lbControle.setBounds(116, 37, 297, 38);
					lbControle.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					btPesquisaCliente = new JButton();
					PanelTotal.add(btPesquisaCliente);
					btPesquisaCliente.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisaCliente.setBounds(431, 100, 24, 23);
				}
				{
					lbAstCliente = new JLabel();
					PanelTotal.add(lbAstCliente);
					lbAstCliente.setText("*");
					lbAstCliente.setForeground(new java.awt.Color(170, 0, 0));
					lbAstCliente.setBounds(192, 84, 10, 16);
				}
				{
					lbCliente = new JLabel();
					PanelTotal.add(lbCliente);
					lbCliente.setText("Cliente");
					lbCliente.setBounds(156, 86, 41, 16);
				}
				{
					tfCliente = new JTextField();
					PanelTotal.add(tfCliente);
					tfCliente.setBounds(156, 101, 269, 21);
				}
				{
					lbAstData = new JLabel();
					PanelTotal.add(lbAstData);
					lbAstData.setText("*");
					lbAstData.setForeground(new java.awt.Color(196, 0, 0));
					lbAstData.setBounds(116, 86, 16, 14);
				}
				{
					lbDtPagamento = new JLabel();
					PanelTotal.add(lbDtPagamento);
					lbDtPagamento.setText("Data do Pagamento");
					lbDtPagamento.setBounds(19, 87, 95, 14);
				}
				{
					tfDtPagamento = new JTextField();
					PanelTotal.add(tfDtPagamento);
					tfDtPagamento.setBounds(19, 101, 127, 21);
					tfDtPagamento.setEditable(false);
				}
				{
					lbProfissional = new JLabel();
					PanelTotal.add(lbProfissional);
					lbProfissional.setText("Profissional");
					lbProfissional.setBounds(21, 131, 67, 14);
				}
				{
					ComboBoxModel ComboBoxProfiModel = new DefaultComboBoxModel(
							new String[] { "Silvia Dutra", "Item Two" });
					ComboBoxProfi = new JComboBox();
					PanelTotal.add(ComboBoxProfi);
					ComboBoxProfi.setModel(ComboBoxProfiModel);
					ComboBoxProfi.setBounds(21, 145, 297, 20);
				}
				{
					btSelecionarVenda = new JButton();
					PanelTotal.add(btSelecionarVenda);
					btSelecionarVenda.setText("Selecionar Venda");
					btSelecionarVenda.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/hand_point_090.png")));
					btSelecionarVenda.setBounds(328, 142, 135, 25);
					btSelecionarVenda.setSize(135, 24);
					btSelecionarVenda.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							Consulta_Vendas inst = new Consulta_Vendas();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
						}
					});
				}
				{
					btRegistrar = new JButton();
					PanelTotal.add(btRegistrar);
					btRegistrar.setText("Registrar");
					btRegistrar
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/Salvaar.png")));
					btRegistrar.setBounds(278, 625, 101, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/retiraar.png")));
					btCancelar.setBounds(385, 625, 95, 24);
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(18, 625, 71, 24);
				}
				{
					PanelVendas = new JPanel();
					PanelTotal.add(PanelVendas);
					PanelVendas.setBorder(BorderFactory
							.createTitledBorder("Vendas"));
					PanelVendas.setLayout(null);
					PanelVendas.setBounds(12, 182, 468, 195);
					{
						ScrollPaneVendas = new JScrollPane();
						PanelVendas.add(ScrollPaneVendas);
						ScrollPaneVendas
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						ScrollPaneVendas
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						ScrollPaneVendas.setBounds(16, 20, 412, 162);
						{
							String colunas[] = { "Data da Venda", "Cliente",
									"Itens", "Total" };
							TableModel = new DefaultTableModel(colunas, 0);

							TableVendas = new JTable();
							ScrollPaneVendas.setViewportView(TableVendas);
							TableVendas.setModel(TableModel);

							TableVendas.getColumnModel().getColumn(0)
									.setPreferredWidth(15);
							TableVendas.getColumnModel().getColumn(1)
									.setPreferredWidth(40);
							TableVendas.getColumnModel().getColumn(2)
									.setPreferredWidth(70);
							TableVendas.getColumnModel().getColumn(3)
									.setPreferredWidth(20);
							ScrollPaneVendas
									.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
							// barra de rolagem horizontal sempre oculta
							ScrollPaneVendas
									.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						}
					}
					{
						btRetirar = new JButton();
						PanelVendas.add(btRetirar);
						btRetirar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/AApagar.png")));
						btRetirar.setBounds(434, 20, 24, 23);
					}
				}
				{
					ComboBoxModel ComboBoxParcelasModel = new DefaultComboBoxModel(
							new String[] { "2x 45,00", "3x 30,00", "4x 22,50",
									"5x 18,00", "6x 15,00" });
					ComboBoxParcelas = new JComboBox();
					PanelTotal.add(ComboBoxParcelas);
					ComboBoxParcelas.setModel(ComboBoxParcelasModel);
					ComboBoxParcelas.setBounds(134, 404, 125, 20);
				}
				{
					lbQuantParcelas = new JLabel();
					PanelTotal.add(lbQuantParcelas);
					lbQuantParcelas.setText("Quantidade de Parcelas");
					lbQuantParcelas.setBounds(134, 390, 114, 14);
				}
				{
					tfTotal = new JTextField();
					PanelTotal.add(tfTotal);
					tfTotal.setEditable(false);
					tfTotal.setBounds(26, 404, 100, 20);
				}
				{
					lbTotal = new JLabel();
					PanelTotal.add(lbTotal);
					lbTotal.setText("Total a pagar");
					lbTotal.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/total_plan_cost.png")));
					lbTotal.setBounds(26, 388, 108, 16);
				}
				{
					PanelPascelasRestantes = new JPanel();
					PanelTotal.add(PanelPascelasRestantes);
					PanelPascelasRestantes.setLayout(null);
					PanelPascelasRestantes.setBounds(18, 438, 462, 176);
					PanelPascelasRestantes.setBorder(BorderFactory
							.createTitledBorder("Parcelas Restantes"));
					{
						ScrollPaneTableParcelas = new JScrollPane();
						PanelPascelasRestantes.add(ScrollPaneTableParcelas);
						ScrollPaneTableParcelas.setBounds(16, 20, 430, 109);
						{
							TableModel TableParcRestanteModel = new DefaultTableModel(
									new String[][] { { "1", "15/08/2013","R$ 30,00" },
											{ "2", "15/09/2013","R$ 30,00" }, {"3","15/10/2013","R$ 30,00"} },
									new String[] { "Parcela", "Data", "Valor" });
							TableParcRestante = new JTable();
							ScrollPaneTableParcelas
									.setViewportView(TableParcRestante);
							TableParcRestante.setModel(TableParcRestanteModel);
						}
					}
					{
						btPagarParcela = new JButton();
						PanelPascelasRestantes.add(btPagarParcela);
						btPagarParcela.setText("Pagar Parcela");
						btPagarParcela.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/money.png")));
						btPagarParcela.setBounds(327, 144, 119, 25);
						btPagarParcela.setSize(119, 24);
						btPagarParcela.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								// pensamento: ActionListener para a pagina de
								// pagamento a vista. Ja que o pagamento da
								// parcela será a vista e nao a prazo novamente.
								// Quando selecionar uma parcela apresentada na
								// tabela aparecer a janela de pagamento a vista

							}
						});
					}
				}
				{
					lbTroco = new JLabel();
					PanelTotal.add(lbTroco);
					lbTroco.setText("Troco");
					lbTroco.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/coins16.png")));
					lbTroco.setBounds(383, 389, 47, 16);
				}
				{
					tfTroco = new JTextField();
					PanelTotal.add(tfTroco);
					tfTroco.setEditable(false);
					tfTroco.setBounds(381, 404, 95, 20);
				}
				{
					lbValorRecebido = new JLabel();
					PanelTotal.add(lbValorRecebido);
					lbValorRecebido.setText("Valor Recebido");
					lbValorRecebido.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/money.png")));
					lbValorRecebido.setBounds(267, 389, 91, 16);
				}
				{
					tfValorRecebido = new JTextField();
					PanelTotal.add(tfValorRecebido);
					tfValorRecebido.setBounds(267, 404, 106, 20);
				}
			}
			pack();
			this.setSize(518, 698);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
