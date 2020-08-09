package br.com.salao.view.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
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
public class Inserir_Fornecedor extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel PanelTotal;
	private JTextField tfNome;
	private JLabel lbData;
	private JTextField tfEmpresa;
	private JLabel lbEmpresa;
	private JLabel lbProduto;
	private JTextField tfTelefone;
	private JLabel lbTelefone;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JPanel PanelCadastro;
	private JLabel lbAstData;
	private JTable TableProdutos;
	private JScrollPane ScrollPaneProdutos;
	private JButton btSair;
	private JLabel lbTelefoneast;
	private JLabel lbProdaste;
	private JLabel lbNomeaste;
	private JButton btAddProduto;
	private JButton btPesquisaProduto;
	private JTextField tfProduto;
	private JLabel lbNome;
	private JLabel lbTitulo;
	private JButton btCancelar;
	private JButton btCadastrar;
	private JTextField tfData;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Inserir_Fornecedor inst = new Inserir_Fornecedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Inserir_Fornecedor() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setTitle("Inserir Fornecedor");
				this.setIconImage(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/reseller_account.png")).getImage());
				this.setResizable(false);
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, "Center");
				PanelTotal.setLayout(null);
				PanelTotal.setBounds(0, 0, 483, 581);
				{
					lbTitulo = new JLabel();
					PanelTotal.add(lbTitulo);
					lbTitulo.setText("Inserir Fornecedor");
					lbTitulo.setBounds(101, 20, 280, 52);
					lbTitulo.setFont(new java.awt.Font("Tahoma",0,26));
					lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/reseller_account.png")));
					//lbTitulo.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
				}
				{
					PanelCadastro = new JPanel();
					PanelTotal.add(PanelCadastro);
					PanelCadastro.setLayout(null);
					PanelCadastro.setBounds(23, 78, 430, 301);
					PanelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
					{
						lbCodigo = new JLabel();
						PanelCadastro.add(lbCodigo);
						lbCodigo.setText("Código");
						lbCodigo.setBounds(18, 31, 33, 14);
					}
					{
						lbNome = new JLabel();
						PanelCadastro.add(lbNome);
						lbNome.setText("Nome");
						lbNome.setBounds(81, 31, 27, 14);
					}
					{
						tfCodigo = new JTextField();
						PanelCadastro.add(tfCodigo);
						tfCodigo.setBounds(18, 45, 53, 20);
						tfCodigo.setEditable(false);
						tfCodigo.setText("001");
					}
					{
						tfNome = new JTextField();
						PanelCadastro.add(tfNome);
						tfNome.setBounds(81, 45, 308, 20);
					}
					{
						tfTelefone = new JTextField();
						PanelCadastro.add(tfTelefone);
						tfTelefone.setBounds(19, 90, 178, 20);
					}
					{
						lbTelefone = new JLabel();
						PanelCadastro.add(lbTelefone);
						lbTelefone.setText("Telefone");
						lbTelefone.setBounds(19, 76, 42, 14);
					}
					{
						lbEmpresa = new JLabel();
						PanelCadastro.add(lbEmpresa);
						lbEmpresa.setText("Empresa");
						lbEmpresa.setBounds(18, 126, 50, 14);
					}
					{
						lbProduto = new JLabel();
						PanelCadastro.add(lbProduto);
						lbProduto.setText("Produtos que Fornece");
						lbProduto.setBounds(207, 126, 109, 14);
					}
					{
						lbData = new JLabel();
						PanelCadastro.add(lbData);
						lbData.setText("Data de Passagem");
						lbData.setBounds(207, 76, 91, 14);
					}
					{
						tfData = new JTextField();
						PanelCadastro.add(tfData);
						tfData.setBounds(207, 90, 182, 20);
					}
					{
						tfEmpresa = new JTextField();
						PanelCadastro.add(tfEmpresa);
						tfEmpresa.setBounds(18, 140, 179, 20);
					}
					{
						btCadastrar = new JButton();
						PanelCadastro.add(btCadastrar);
						btCadastrar.setText("Salvar");
						btCadastrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Salvaar.png")));
						btCadastrar.setBounds(222, 270, 83, 24);
						btCadastrar.addActionListener(new ActionListener() {
							
							@Override
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
						btCancelar.setBounds(315, 270, 105, 24);
						btCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evento) {
							}
						});
					}
					{
						tfProduto = new JTextField();
						PanelCadastro.add(tfProduto);
						tfProduto.setBounds(207, 140, 182, 20);
						tfProduto.setEditable(false);
					}
					{
						btPesquisaProduto = new JButton();
						PanelCadastro.add(btPesquisaProduto);
						btPesquisaProduto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
						btPesquisaProduto.setBounds(395, 138, 25, 22);
					}
					{
						btAddProduto = new JButton();
						PanelCadastro.add(btAddProduto);
						btAddProduto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Maaiis.png")));
						btAddProduto.setBounds(395, 183, 25, 22);
					}
					{
						lbNomeaste = new JLabel();
						PanelCadastro.add(lbNomeaste);
						lbNomeaste.setText("*");
						lbNomeaste.setBounds(110, 31, 14, 14);
						lbNomeaste.setForeground(new java.awt.Color(196,0,0));
					}
					{
						lbProdaste = new JLabel();
						PanelCadastro.add(lbProdaste);
						lbProdaste.setText("*");
						lbProdaste.setBounds(316, 126, 10, 14);
						lbProdaste.setForeground(new java.awt.Color(196,0,0));
					}
					{
						lbTelefoneast = new JLabel();
						PanelCadastro.add(lbTelefoneast);
						lbTelefoneast.setText("*");
						lbTelefoneast.setBounds(63, 76, 10, 14);
						lbTelefoneast.setForeground(new java.awt.Color(196,0,0));
					}
					{
						ScrollPaneProdutos = new JScrollPane();
						PanelCadastro.add(ScrollPaneProdutos);
						ScrollPaneProdutos.setBounds(18, 183, 371, 77);
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
						lbAstData.setBounds(298, 76, 10, 14);
						lbAstData.setForeground(new java.awt.Color(196,0,0));
					}
					{
						btSair = new JButton();
						PanelCadastro.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
						btSair.setBounds(16, 270, 81, 24);
						btSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								
							}
						});
					}
				}
			}
			this.setSize(477, 417);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
