package br.com.salao.view.Gastos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class Cadastro_Gastos extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbConsultaGastos;
	private JTable TablePesquisa;
	private JScrollPane ScrollPanePesquisa;
	private JButton btPesquisa;
	private JTextField tfDtFinal;
	private JLabel lbDtFinal;
	private JButton btDetalhar;
	private JButton btInserir;
	private JButton btAlterar;
	private JButton btExcluir;
	private JButton btSair;
	private JTextField tfDtInicio;
	private JLabel lbDtInicio;
	private JPanel PanelConsulta;

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
				Cadastro_Gastos inst = new Cadastro_Gastos();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
				
			}
		});
	}
	
	public Cadastro_Gastos( ) {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Icones/calculator.png")).getImage());
				this.setTitle("Cadastro de Gastos");
				{
					lbConsultaGastos = new JLabel();
					PanelTotal.add(lbConsultaGastos);
					lbConsultaGastos.setText("Cadastro de Gastos");
					lbConsultaGastos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/calculator.png")));
					lbConsultaGastos.setBounds(114, 27, 281, 38);
					lbConsultaGastos.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
				{
					PanelConsulta = new JPanel();
					PanelTotal.add(PanelConsulta);
					PanelConsulta.setBorder(BorderFactory.createTitledBorder("Consulta"));
					PanelConsulta.setLayout(null);
					PanelConsulta.setBounds(48, 76, 407, 88);
					{
						lbDtInicio = new JLabel();
						PanelConsulta.add(lbDtInicio);
						lbDtInicio.setText("Data Início");
						lbDtInicio.setBounds(16, 25, 51, 14);
					}
					{
						tfDtInicio = new JTextField();
						PanelConsulta.add(tfDtInicio);
						tfDtInicio.setBounds(16, 39, 122, 20);
					}
					{
						lbDtFinal = new JLabel();
						PanelConsulta.add(lbDtFinal);
						lbDtFinal.setText("Data Final");
						lbDtFinal.setBounds(150, 25, 48, 14);
					}
					{
						tfDtFinal = new JTextField();
						PanelConsulta.add(tfDtFinal);
						tfDtFinal.setBounds(148, 39, 118, 20);
					}
					{
						btPesquisa = new JButton();
						PanelConsulta.add(btPesquisa);
						btPesquisa.setText("Pesquisar");
						btPesquisa.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
						btPesquisa.setBounds(276, 37, 99, 25);
						btPesquisa.setSize(99, 24);
					}
				}
				{
					ScrollPanePesquisa = new JScrollPane();
					PanelTotal.add(ScrollPanePesquisa);
					ScrollPanePesquisa.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					ScrollPanePesquisa.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					ScrollPanePesquisa.setBounds(22, 175, 463, 126);
					{
						
						TableModel TablePesquisaModel = new DefaultTableModel(
								new String[][] {
										{ "Conta de Água", "39,20",
												"12/07/2013" },
										{ "Pagamento ao Fornecedor", "200,00",
												"20/07/2013" },
										{ "Conta de Luz", "190,35",
												"19/07/2013" } }, new String[] {
										"Tipo", "Valor", "Data" });
						TablePesquisa = new JTable();
						ScrollPanePesquisa.setViewportView(TablePesquisa);
						TablePesquisa.setModel(TablePesquisaModel);
					}
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(23, 312, 71, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
							
						}
					});
				}
				{
					btExcluir = new JButton();
					PanelTotal.add(btExcluir);
					btExcluir.setText("Excluir");
					btExcluir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/excluir.png")));
					btExcluir.setBounds(397, 312, 88, 24);
				}
				{
					btAlterar = new JButton();
					PanelTotal.add(btAlterar);
					btAlterar.setText("Alterar");
					btAlterar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/alterar.png")));
					btAlterar.setBounds(306, 312, 85, 24);
					btAlterar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showInputDialog(null, "Digite o código de segurança para alterar esta venda:");
							
						}
					});
				}
				{
					btInserir = new JButton();
					PanelTotal.add(btInserir);
					btInserir.setText("Registrar");
					btInserir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Maaiis.png")));
					btInserir.setBounds(203, 312, 97, 24);
				}
				{
					btDetalhar = new JButton();
					PanelTotal.add(btDetalhar);
					btDetalhar.setText("Detalhar");
					btDetalhar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btDetalhar.setBounds(102, 312, 93, 24);
				}
			}
			this.setSize(513, 389);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
