package br.com.salao.view.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class Fornecedor_Alterar extends javax.swing.JDialog {
	private JPanel PanelCadastro;
	private JLabel lbAlterar;
	private JLabel lbAstData;
	private JTable TableProdutos;
	private JScrollPane ScrollPaneProdutos;
	private JLabel lbTelefoneast;
	private JLabel lbProdaste;
	private JLabel lbNomeaste;
	private JButton btAddProduto;
	private JButton btPesquisaProduto;
	private JTextField tfProduto;
	private JButton btCancelar;
	private JButton btCadastrar;
	private JTextField tfEmpresa;
	private JTextField tfData;
	private JLabel lbData;
	private JLabel lbProduto;
	private JLabel lbEmpresa;
	private JLabel lbTelefone;
	private JTextField tfTelefone;
	private JTextField tfNome;
	private JTextField tfCodigo;
	private JLabel lbNome;
	private JLabel lbCodigo;

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
				Fornecedor_Alterar inst = new Fornecedor_Alterar();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}
	
	public Fornecedor_Alterar() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				{
					PanelCadastro = new JPanel();
					getContentPane().add(PanelCadastro);
					PanelCadastro.setLayout(null);
					PanelCadastro.setBounds(10, 5, 443, 359);
					{
						lbCodigo = new JLabel();
						PanelCadastro.add(lbCodigo);
						lbCodigo.setText("Código");
						lbCodigo.setBounds(17, 76, 33, 14);
					}
					{
						lbNome = new JLabel();
						PanelCadastro.add(lbNome);
						lbNome.setText("Nome");
						lbNome.setBounds(80, 76, 27, 14);
					}
					{
						tfCodigo = new JTextField();
						PanelCadastro.add(tfCodigo);
						tfCodigo.setText("001");
						tfCodigo.setEditable(false);
						tfCodigo.setBounds(17, 90, 53, 20);
					}
					{
						tfNome = new JTextField();
						PanelCadastro.add(tfNome);
						tfNome.setBounds(80, 90, 308, 20);
					}
					{
						tfTelefone = new JTextField();
						PanelCadastro.add(tfTelefone);
						tfTelefone.setBounds(18, 135, 178, 20);
					}
					{
						lbTelefone = new JLabel();
						PanelCadastro.add(lbTelefone);
						lbTelefone.setText("Telefone");
						lbTelefone.setBounds(18, 121, 42, 14);
					}
					{
						lbEmpresa = new JLabel();
						PanelCadastro.add(lbEmpresa);
						lbEmpresa.setText("Empresa");
						lbEmpresa.setBounds(17, 171, 50, 14);
					}
					{
						lbProduto = new JLabel();
						PanelCadastro.add(lbProduto);
						lbProduto.setText("Produtos que Fornece");
						lbProduto.setBounds(206, 171, 109, 14);
					}
					{
						lbData = new JLabel();
						PanelCadastro.add(lbData);
						lbData.setText("Data de Passagem");
						lbData.setBounds(206, 121, 91, 14);
					}
					{
						tfData = new JTextField();
						PanelCadastro.add(tfData);
						tfData.setBounds(206, 135, 182, 20);
					}
					{
						tfEmpresa = new JTextField();
						PanelCadastro.add(tfEmpresa);
						tfEmpresa.setBounds(17, 185, 179, 20);
					}
					{
						btCadastrar = new JButton();
						PanelCadastro.add(btCadastrar);
						btCadastrar.setText("Salvar");
						btCadastrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Salvaar.png")));
						btCadastrar.setBounds(221, 316, 83, 23);
						btCadastrar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado.");
								
							}
						});
					}
					{
						btCancelar = new JButton();
						PanelCadastro.add(btCancelar);
						btCancelar.setText("Cancelar");
						btCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Retiraar.png")));
						btCancelar.setBounds(314, 316, 105, 23);
						btCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evento) {
								dispose();
							}
						});
					}
					{
						tfProduto = new JTextField();
						PanelCadastro.add(tfProduto);
						tfProduto.setBounds(206, 185, 182, 20);
						tfProduto.setEditable(false);
					}
					{
						btPesquisaProduto = new JButton();
						PanelCadastro.add(btPesquisaProduto);
						btPesquisaProduto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
						btPesquisaProduto.setBounds(394, 183, 25, 22);
					}
					{
						btAddProduto = new JButton();
						PanelCadastro.add(btAddProduto);
						btAddProduto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Maaiis.png")));
						btAddProduto.setBounds(394, 228, 25, 22);
					}
					{
						lbNomeaste = new JLabel();
						PanelCadastro.add(lbNomeaste);
						lbNomeaste.setText("*");
						lbNomeaste.setForeground(new java.awt.Color(196,0,0));
						lbNomeaste.setBounds(109, 76, 14, 14);
					}
					{
						lbProdaste = new JLabel();
						PanelCadastro.add(lbProdaste);
						lbProdaste.setText("*");
						lbProdaste.setForeground(new java.awt.Color(196,0,0));
						lbProdaste.setBounds(315, 171, 10, 14);
					}
					{
						lbTelefoneast = new JLabel();
						PanelCadastro.add(lbTelefoneast);
						lbTelefoneast.setText("*");
						lbTelefoneast.setForeground(new java.awt.Color(196,0,0));
						lbTelefoneast.setBounds(62, 121, 10, 14);
					}
					{
						ScrollPaneProdutos = new JScrollPane();
						PanelCadastro.add(ScrollPaneProdutos);
						ScrollPaneProdutos.setBounds(17, 228, 371, 77);
						{
						
							TableModel TableProdutosModel = 
									new DefaultTableModel(
											new String[][] { { "1", "Shampoo","40,00","Cabeleireira" }},
											new String[] { "Código", "Nome","Valor","Área de Utilização" });
							TableProdutos = new JTable();
							ScrollPaneProdutos.setViewportView(TableProdutos);
							TableProdutos.setModel(TableProdutosModel);
						}
					}
					{
						lbAstData = new JLabel();
						PanelCadastro.add(lbAstData);
						lbAstData.setText("*");
						lbAstData.setForeground(new java.awt.Color(196,0,0));
						lbAstData.setBounds(297, 121, 10, 14);
					}
					{
						lbAlterar = new JLabel();
						PanelCadastro.add(lbAlterar);
						lbAlterar.setText("Alterar Fornecedor");
						lbAlterar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/reseller_account.png")));
						lbAlterar.setBounds(80, 17, 270, 40);
						lbAlterar.setFont(new java.awt.Font("Lucida Sans",0,24));
					}
				}
			}
			this.setSize(479, 402);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
