package br.com.salao.view.Gastos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
public class Registrar_Gastos extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JTextField tfData;
	private JLabel lbData;
	private JTextField tfValor;
	private JLabel lbValor;
	private JComboBox ComboBoxGasto;
	private JLabel lbGasto;
	private JTextArea TextAreaObservacao;
	private JScrollPane ScrollPaneObs;
	private JLabel lbObservacoes;
	private JButton btCancelar;
	private JLabel lbAstValor;
	private JLabel lbCodigo;
	private JButton btPesquisaProfForn;
	private JLabel lbNome;
	private JButton btSair;
	private JComboBox ComboBoxNmProf_Forn;
	private JButton btAddTipoGasto;
	private JButton btMaisNome;
	private JLabel lbAstNome;
	private JTextField tfCodigo;
	private JLabel lbAstData;
	private JLabel lbRegistro;
	private JButton btRegistrar;

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
				Registrar_Gastos inst = new Registrar_Gastos();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Registrar_Gastos() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/cash_terminal.png")).getImage());
			this.setTitle("Registrar Gastos");
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal);
				PanelTotal.setLayout(null);
				PanelTotal.setBounds(16, 81, 351, 326);
				PanelTotal.setBorder(BorderFactory
						.createTitledBorder("Registro"));
				{
					lbGasto = new JLabel();
					PanelTotal.add(lbGasto);
					lbGasto.setText("Tipo de Gasto");
					lbGasto.setBounds(9, 70, 72, 14);
				}
				{
					ComboBoxModel ComboBoxGastoModel = new DefaultComboBoxModel(
							new String[] { "Conta de Água", "Conta de Luz",
									"Conta de Telefone",
									"Pagamento ao Profissional",
									"Pagamento ao Fornecedor" });
					ComboBoxGasto = new JComboBox();
					PanelTotal.add(ComboBoxGasto);
					ComboBoxGasto.setModel(ComboBoxGastoModel);
					ComboBoxGasto.setBounds(9, 84, 289, 20);
				}
				{
					lbValor = new JLabel();
					PanelTotal.add(lbValor);
					lbValor.setText("Valor");
					lbValor.setBounds(71, 27, 24, 14);
				}
				{
					tfValor = new JTextField();
					PanelTotal.add(tfValor);
					tfValor.setBounds(71, 41, 83, 20);
				}
				{
					lbData = new JLabel();
					PanelTotal.add(lbData);
					lbData.setText("Data");
					lbData.setBounds(162, 28, 23, 14);
				}
				{
					tfData = new JTextField();
					PanelTotal.add(tfData);
					tfData.setBounds(162, 41, 108, 20);
				}
				{
					lbObservacoes = new JLabel();
					PanelTotal.add(lbObservacoes);
					lbObservacoes.setText("Observações");
					lbObservacoes.setBounds(11, 160, 63, 14);
				}
				{
					ScrollPaneObs = new JScrollPane();
					PanelTotal.add(ScrollPaneObs);
					ScrollPaneObs.setBounds(11, 174, 320, 91);
					{
						TextAreaObservacao = new JTextArea();
						ScrollPaneObs.setViewportView(TextAreaObservacao);
					}
				}
				{
					btRegistrar = new JButton();
					PanelTotal.add(btRegistrar);
					btRegistrar.setText("Registrar");
					btRegistrar
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/Salvaar.png")));
					btRegistrar.setBounds(133, 276, 97, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setBounds(236, 276, 95, 24);
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/retiraar.png")));
				}
				{
					lbAstValor = new JLabel();
					PanelTotal.add(lbAstValor);
					lbAstValor.setText("*");
					lbAstValor.setBounds(97, 27, 10, 14);
					lbAstValor.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					lbAstData = new JLabel();
					PanelTotal.add(lbAstData);
					lbAstData.setText("*");
					lbAstData.setBounds(186, 28, 10, 14);
					lbAstData.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					lbCodigo = new JLabel();
					PanelTotal.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(10, 26, 33, 14);
				}
				{
					tfCodigo = new JTextField();
					PanelTotal.add(tfCodigo);
					tfCodigo.setBounds(9, 41, 52, 20);
					tfCodigo.setEditable(false);
					tfCodigo.setText("004");
				}
				{
					lbNome = new JLabel();
					PanelTotal.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(11, 116, 27, 14);
					lbNome.setEnabled(false);
				}
				{
					btPesquisaProfForn = new JButton();
					PanelTotal.add(btPesquisaProfForn);
					btPesquisaProfForn.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisaProfForn.setBounds(271, 128, 26, 23);
					btPesquisaProfForn.setEnabled(false);
				}
				{
					lbAstNome = new JLabel();
					PanelTotal.add(lbAstNome);
					lbAstNome.setText("*");
					lbAstNome.setBounds(39, 114, 10, 14);
					lbAstNome.setForeground(new java.awt.Color(196,0,0));
					lbAstNome.setEnabled(false);
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(11, 276, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					btMaisNome = new JButton();
					PanelTotal.add(btMaisNome);
					btMaisNome.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Maaiis.png")));
					btMaisNome.setBounds(300, 128, 28, 23);
					btMaisNome.setEnabled(false);
				}
				{
					btAddTipoGasto = new JButton();
					PanelTotal.add(btAddTipoGasto);
					btAddTipoGasto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Maaiis.png")));
					btAddTipoGasto.setBounds(304, 83, 24, 23);
				}
				{
					ComboBoxModel ComboBoxNmProf_FornModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					ComboBoxNmProf_Forn = new JComboBox();
					PanelTotal.add(ComboBoxNmProf_Forn);
					ComboBoxNmProf_Forn.setModel(ComboBoxNmProf_FornModel);
					ComboBoxNmProf_Forn.setBounds(11, 129, 256, 20);
					ComboBoxNmProf_Forn.setEnabled(false);
				}
			}
			{
				lbRegistro = new JLabel();
				getContentPane().add(lbRegistro);
				lbRegistro.setText("Registrar Gastos");
				lbRegistro.setBounds(70, 22, 232, 40);
				lbRegistro.setFont(new java.awt.Font("Tahoma", 0, 22));
				lbRegistro.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/cash_terminal.png")));
			}
			pack();
			this.setSize(393, 450);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
