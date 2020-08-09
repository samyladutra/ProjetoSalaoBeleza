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
public class Pagamento_a_vista extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbPagamento;
	private JTextField tfTotal;
	private JLabel lbTotal;
	private JTable TableVendas;
	private JScrollPane ScrollPaneVendas;
	private JPanel PanelVendas;
	private JButton btSelecionarVenda;
	private JComboBox ComboBoxProfi;
	private JLabel lbProfissional;
	private JButton btCancelar;
	private JButton btRegistrar;
	private JTextField tfTroco;
	private JLabel lbTroco;
	private JTextField tfValorRecebido;
	private JLabel lbValorRecebido;
	private JButton btPesquisaCliente;
	private JTextField tfCliente;
	private JLabel lbCliente;
	private JLabel lbAstCliente;
	private JButton btRetirar;
	private JLabel lbAstData;
	private JTextField tfDtPagamento;
	private JLabel lbDtPagamento;
	private DefaultTableModel TableModel;
	private JButton btSair;

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
				Pagamento_a_vista inst = new Pagamento_a_vista();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Pagamento_a_vista() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Icones/cash_register.png")).getImage());
			this.setTitle("Pagamento à vista");
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setPreferredSize(new java.awt.Dimension(468, 332));
				{
					lbPagamento = new JLabel();
					PanelTotal.add(lbPagamento);
					lbPagamento.setText("Pagamento à Vista");
					lbPagamento.setFont(new java.awt.Font("Lucida Sans",0,24));
					lbPagamento.setBounds(116, 23, 262, 52);
					lbPagamento.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/cash_register.png")));
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
					ComboBoxModel ComboBoxProfiModel = 
							new DefaultComboBoxModel(
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
					btSelecionarVenda.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/hand_point_090.png")));
					btSelecionarVenda.setBounds(328, 142, 135, 25);
					btSelecionarVenda.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							Consulta_Vendas inst = new Consulta_Vendas();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
						}
					});
				}
				{
					PanelVendas = new JPanel();
					PanelTotal.add(PanelVendas);
					PanelVendas.setLayout(null);
					PanelVendas.setBounds(12, 182, 468, 195);
					PanelVendas.setBorder(BorderFactory.createTitledBorder("Vendas"));
					{
						ScrollPaneVendas = new JScrollPane();
						PanelVendas.add(ScrollPaneVendas);
						ScrollPaneVendas.setBounds(16, 20, 412, 162);
						{
							

							String colunas[] = { "Data da Venda", "Cliente",
							"Itens","Total" };
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
						btRetirar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/AApagar.png")));
						btRetirar.setBounds(434, 20, 24, 23);
					}
				}
				{
					lbTotal = new JLabel();
					PanelTotal.add(lbTotal);
					lbTotal.setText("Total a pagar");
					lbTotal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/total_plan_cost.png")));
					lbTotal.setBounds(33, 388, 108, 16);
				}
				{
					tfTotal = new JTextField();
					PanelTotal.add(tfTotal);
					tfTotal.setBounds(33, 404, 108, 20);
					tfTotal.setEditable(false);
				}
				{
					lbAstData = new JLabel();
					PanelTotal.add(lbAstData);
					lbAstData.setText("*");
					lbAstData.setBounds(116, 87, 10, 14);
					lbAstData.setForeground(new java.awt.Color(196,0,0));
				}
				{
					lbAstCliente = new JLabel();
					PanelTotal.add(lbAstCliente);
					lbAstCliente.setText("*");
					lbAstCliente.setBounds(192, 86, 10, 17);
					lbAstCliente.setForeground(new java.awt.Color(170,0,0));
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
					btPesquisaCliente = new JButton();
					PanelTotal.add(btPesquisaCliente);
					btPesquisaCliente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisaCliente.setBounds(431, 100, 24, 23);
				}
				{
					lbValorRecebido = new JLabel();
					PanelTotal.add(lbValorRecebido);
					lbValorRecebido.setText("Valor Recebido");
					lbValorRecebido.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/money.png")));
					lbValorRecebido.setBounds(151, 389, 91, 16);
				}
				{
					tfValorRecebido = new JTextField();
					PanelTotal.add(tfValorRecebido);
					tfValorRecebido.setBounds(151, 404, 106, 20);
				}
				{
					lbTroco = new JLabel();
					PanelTotal.add(lbTroco);
					lbTroco.setText("Troco");
					lbTroco.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/coins16.png")));
					lbTroco.setBounds(269, 389, 47, 16);
				}
				{
					tfTroco = new JTextField();
					PanelTotal.add(tfTroco);
					tfTroco.setBounds(267, 404, 95, 20);
					tfTroco.setEditable(false);
				}
				{
					btRegistrar = new JButton();
					PanelTotal.add(btRegistrar);
					btRegistrar.setText("Registrar");
					btRegistrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Salvaar.png")));
					btRegistrar.setBounds(117, 440, 99, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/retiraar.png")));
					btCancelar.setBounds(224, 440, 99, 24);
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(33, 440, 74, 24);
				}
			}
			pack();
			this.setSize(508, 529);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
