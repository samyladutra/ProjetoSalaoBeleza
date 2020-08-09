package br.com.salao.view.Gastos;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
public class Alterar_Gastos extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JTextField tfData;
	private JLabel lbObservacoes;
	private JLabel lbAstValor;
	private JLabel lbCodigo;
	private JLabel lbAlterarGasto;
	private JButton btPesquisaProfForn;
	private JTextField tfNome;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbAstData;
	private JButton btCancelar;
	private JButton btRegistrar;
	private JTextArea TextAreaObservacao;
	private JScrollPane ScrollPaneObs;
	private JLabel lbData;
	private JTextField tfValor;
	private JLabel lbValor;
	private JComboBox ComboBoxGasto;
	private JLabel lbGasto;

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
				JFrame frame = new JFrame();
				Alterar_Gastos inst = new Alterar_Gastos(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public Alterar_Gastos(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Alterar Gasto");
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setBounds(16, 81, 444, 261);
				{
					lbGasto = new JLabel();
					PanelTotal.add(lbGasto);
					lbGasto.setText("Tipo de Gasto");
					lbGasto.setBounds(20, 135, 72, 14);
				}
				{
					ComboBoxModel ComboBoxGastoModel = 
							new DefaultComboBoxModel(
									new String[] { "Conta de Telefone", "Item Two" });
					ComboBoxGasto = new JComboBox();
					PanelTotal.add(ComboBoxGasto);
					ComboBoxGasto.setModel(ComboBoxGastoModel);
					ComboBoxGasto.setBounds(20, 149, 196, 20);
				}
				{
					lbValor = new JLabel();
					PanelTotal.add(lbValor);
					lbValor.setText("Valor");
					lbValor.setBounds(82, 92, 24, 14);
				}
				{
					tfValor = new JTextField();
					PanelTotal.add(tfValor);
					tfValor.setBounds(82, 106, 83, 20);
				}
				{
					lbData = new JLabel();
					PanelTotal.add(lbData);
					lbData.setText("Data");
					lbData.setBounds(173, 93, 23, 14);
				}
				{
					tfData = new JTextField();
					PanelTotal.add(tfData);
					tfData.setBounds(173, 106, 108, 20);
				}
				{
					lbObservacoes = new JLabel();
					PanelTotal.add(lbObservacoes);
					lbObservacoes.setText("Observações");
					lbObservacoes.setBounds(20, 179, 63, 14);
				}
				{
					ScrollPaneObs = new JScrollPane();
					PanelTotal.add(ScrollPaneObs);
					ScrollPaneObs.setBounds(20, 193, 426, 91);
					{
						TextAreaObservacao = new JTextArea();
						ScrollPaneObs.setViewportView(TextAreaObservacao);
					}
				}
				{
					btRegistrar = new JButton();
					PanelTotal.add(btRegistrar);
					btRegistrar.setText("Salvar");
					btRegistrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Salvaar.png")));
					btRegistrar.setBounds(248, 295, 97, 24);
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/retiraar.png")));
					btCancelar.setBounds(351, 295, 95, 24);
				}
				{
					lbAstValor = new JLabel();
					PanelTotal.add(lbAstValor);
					lbAstValor.setText("*");
					lbAstValor.setForeground(new java.awt.Color(196,0,0));
					lbAstValor.setBounds(108, 92, 10, 14);
				}
				{
					lbAstData = new JLabel();
					PanelTotal.add(lbAstData);
					lbAstData.setText("*");
					lbAstData.setForeground(new java.awt.Color(196,0,0));
					lbAstData.setBounds(197, 93, 10, 14);
				}
				{
					lbCodigo = new JLabel();
					PanelTotal.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(21, 91, 33, 14);
				}
				{
					tfCodigo = new JTextField();
					PanelTotal.add(tfCodigo);
					tfCodigo.setText("004");
					tfCodigo.setEditable(false);
					tfCodigo.setBounds(20, 106, 52, 20);
				}
				{
					lbNome = new JLabel();
					PanelTotal.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(224, 135, 27, 14);
				}
				{
					tfNome = new JTextField();
					PanelTotal.add(tfNome);
					tfNome.setEnabled(false);
					tfNome.setBounds(224, 149, 190, 20);
				}
				{
					btPesquisaProfForn = new JButton();
					PanelTotal.add(btPesquisaProfForn);
					btPesquisaProfForn.setEnabled(false);
					btPesquisaProfForn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisaProfForn.setBounds(420, 147, 26, 23);
				}
				{
					lbAlterarGasto = new JLabel();
					PanelTotal.add(lbAlterarGasto);
					lbAlterarGasto.setText("Alterar Gasto");
					lbAlterarGasto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/application_form_edit.png")));
					lbAlterarGasto.setBounds(132, 35, 240, 37);
					lbAlterarGasto.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
			}
			this.setSize(476, 371);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
