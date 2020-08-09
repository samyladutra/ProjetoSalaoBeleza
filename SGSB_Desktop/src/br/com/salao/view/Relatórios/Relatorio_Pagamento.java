package br.com.salao.view.Relatórios;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
public class Relatorio_Pagamento extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbRelatorioPagamento;
	private JLabel lbProfissional;
	private JButton btCancelar;
	private JButton btRelatorio;
	private JButton btSair;
	private JTable TablePagamento;
	private JScrollPane ScrollPane;
	private JButton btFiltrar;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JTextField tfDtInicial;
	private JLabel lbDtInicial;
	private JButton btPesquisarCli;
	private JTextField tfCliente;
	private JLabel lbCliente;
	private JComboBox ComboBoxParcelas;
	private JLabel lbParcelas;
	private JRadioButton RbPagVista;
	private JRadioButton RbPagPrazo;
	private JPanel PanelPeriodo;
	private JButton btPesquisaProf;
	private JTextField tfProfissional;
	private JPanel PanelFiltro;
	private DefaultTableModel TablePagamentoModel;

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
				Relatorio_Pagamento inst = new Relatorio_Pagamento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Relatorio_Pagamento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			this.setTitle("Relatório de Pagamento");
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")).getImage());
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbRelatorioPagamento = new JLabel();
					PanelTotal.add(lbRelatorioPagamento);
					lbRelatorioPagamento.setText("Relatório de Pagamento");
					lbRelatorioPagamento.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")));
					lbRelatorioPagamento.setBounds(155, 25, 319, 40);
					lbRelatorioPagamento.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
				{
					PanelFiltro = new JPanel();
					PanelTotal.add(PanelFiltro);
					PanelFiltro.setBounds(23, 120, 298, 97);
					PanelFiltro.setLayout(null);
					PanelFiltro.setBorder(BorderFactory.createTitledBorder("Exibir"));
					{
						RbPagPrazo = new JRadioButton();
						PanelFiltro.add(RbPagPrazo);
						RbPagPrazo.setText("Pagamento à prazo");
						RbPagPrazo.setBounds(19, 25, 119, 23);
					}
					{
						RbPagVista = new JRadioButton();
						PanelFiltro.add(RbPagVista);
						RbPagVista.setText("Pagamento à vista");
						RbPagVista.setBounds(144, 25, 115, 23);
					}
					{
						lbParcelas = new JLabel();
						PanelFiltro.add(lbParcelas);
						lbParcelas.setText("Parcelas");
						lbParcelas.setBounds(19, 50, 64, 14);
					}
					{
						ComboBoxModel ComboBoxParcelasModel = 
								new DefaultComboBoxModel(
										new String[] { "Parcelas Pagas", "Parcelas Restantes","Todas as parcelas" });
						ComboBoxParcelas = new JComboBox();
						PanelFiltro.add(ComboBoxParcelas);
						ComboBoxParcelas.setModel(ComboBoxParcelasModel);
						ComboBoxParcelas.setBounds(19, 64, 119, 20);
						ComboBoxParcelas.setEnabled(false);
					}
				}
				{
					PanelPeriodo = new JPanel();
					PanelTotal.add(PanelPeriodo);
					PanelPeriodo.setBounds(321, 120, 268, 97);
					PanelPeriodo.setBorder(BorderFactory.createTitledBorder("Período"));
					PanelPeriodo.setLayout(null);
					{
						lbDtInicial = new JLabel();
						PanelPeriodo.add(lbDtInicial);
						lbDtInicial.setText("Data Inicial");
						lbDtInicial.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
						lbDtInicial.setBounds(16, 22, 73, 16);
					}
					{
						tfDtInicial = new JTextField();
						PanelPeriodo.add(tfDtInicial);
						tfDtInicial.setBounds(16, 37, 112, 20);
						tfDtInicial.setText("__/__/____");
					}
					{
						lbDtFinal = new JLabel();
						PanelPeriodo.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setBounds(136, 23, 88, 14);
						lbDtFinal.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calendar.png")));
					}
					{
						tfDtFinal = new JTextField();
						PanelPeriodo.add(tfDtFinal);
						tfDtFinal.setBounds(136, 37, 116, 20);
						tfDtFinal.setText("__/__/____");
					}
					{
						btFiltrar = new JButton();
						PanelPeriodo.add(btFiltrar);
						btFiltrar.setText("Filtrar");
						btFiltrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/filter (2).png")));
						btFiltrar.setBounds(162, 63, 90, 24);
					}
				}
				{
					btPesquisarCli = new JButton();
					PanelTotal.add(btPesquisarCli);
					btPesquisarCli.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisarCli.setBounds(558, 86, 33, 24);
				}
				{
					tfCliente = new JTextField();
					PanelTotal.add(tfCliente);
					tfCliente.setBounds(325, 89, 227, 20);
				}
				{
					lbCliente = new JLabel();
					PanelTotal.add(lbCliente);
					lbCliente.setText("Cliente");
					lbCliente.setBounds(325, 76, 33, 14);
				}
				{
					btPesquisaProf = new JButton();
					PanelTotal.add(btPesquisaProf);
					btPesquisaProf.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisaProf.setBounds(285, 86, 34, 24);
				}
				{
					tfProfissional = new JTextField();
					PanelTotal.add(tfProfissional);
					tfProfissional.setBounds(27, 89, 254, 20);
				}
				{
					lbProfissional = new JLabel();
					PanelTotal.add(lbProfissional);
					lbProfissional.setText("Profissional");
					lbProfissional.setBounds(27, 76, 54, 14);
				}
				{
					ScrollPane = new JScrollPane();
					PanelTotal.add(ScrollPane);
					ScrollPane.setBounds(23, 228, 566, 183);
					{
						String colunas[] = { "Código","Cliente",
								"Valor Total", "Venda" };
						TablePagamentoModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						
						TablePagamento = new JTable();
						ScrollPane.setViewportView(TablePagamento);
						TablePagamento.setModel(TablePagamentoModel);

						TablePagamento.getColumnModel().getColumn(0)
								.setPreferredWidth(10);
						TablePagamento.getColumnModel().getColumn(1)
								.setPreferredWidth(55);
						TablePagamento.getColumnModel().getColumn(2)
								.setPreferredWidth(15);
						TablePagamento.getColumnModel().getColumn(3)
								.setPreferredWidth(20);
					}
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(23, 417, 73, 24);
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
					btRelatorio.setBounds(386, 417, 95, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Retiraar.png")));
					btCancelar.setBounds(487, 417, 102, 24);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {
							tfCliente.setText("");
							tfDtFinal.setText("");
							tfDtInicial.setText("");
							tfProfissional.setText("");
						}
					});
				}
			}
			pack();
			this.setSize(609, 484);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
