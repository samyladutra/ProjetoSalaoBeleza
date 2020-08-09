package br.com.salao.view.Relatórios;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
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
public class Emitir_Relatórios extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JLabel lbDtInicio;
	private JLabel lbDtFim;
	private JLabel lbAstFim;
	private JLabel lbAstInicio;
	private JTextField tfDtFim;
	private JTextField tfDtInicio;
	private JPanel PanelPesquisa;
	private JButton btEntrada_Saida;
	private JButton btProdutoEstoque;
	private JButton btItensVendidos;
	private JButton btClientes;
	private JLabel lbTitulo;

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
				Emitir_Relatórios inst = new Emitir_Relatórios();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Emitir_Relatórios() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbTitulo = new JLabel();
					PanelTotal.add(lbTitulo);
					lbTitulo.setText("Emitir Relatórios");
					lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs32.png")));
					lbTitulo.setBounds(39, 24, 245, 36);
					lbTitulo.setFont(new java.awt.Font("Lucida Sans",0,24));
				}
				{
					btClientes = new JButton();
					PanelTotal.add(btClientes);
					btClientes.setText("<html> Clientes em <br> Débito </html>");
					btClientes.setBounds(49, 167, 115, 65);
					btClientes.setFont(new java.awt.Font("Tahoma",0,14));
					btClientes.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/clienteinadimplente.png")));
				}
				{
					btItensVendidos = new JButton();
					PanelTotal.add(btItensVendidos);
					btItensVendidos.setText("<html> Itens <br> Vendidos</html>");
					btItensVendidos.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/document_valid.png")));
					btItensVendidos.setBounds(179, 167, 113, 65);
					btItensVendidos.setFont(new java.awt.Font("Tahoma",0,14));
				}
				{
					btProdutoEstoque = new JButton();
					PanelTotal.add(btProdutoEstoque);
					btProdutoEstoque.setText("<html> Produtos em <br> Estoque </html>");
					btProdutoEstoque.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/cart_full.png")));
					btProdutoEstoque.setBounds(49, 243, 116, 76);
					btProdutoEstoque.setFont(new java.awt.Font("Tahoma",0,14));
				}
				{
					btEntrada_Saida = new JButton();
					PanelTotal.add(btEntrada_Saida);
					btEntrada_Saida.setText("<html> Entrada e <br> Saída </html>");
					btEntrada_Saida.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/credit.png")));
					btEntrada_Saida.setBounds(179, 243, 115, 76);
					btEntrada_Saida.setFont(new java.awt.Font("Tahoma",0,14));
				}
				{
					PanelPesquisa = new JPanel();
					PanelTotal.add(PanelPesquisa);
					PanelPesquisa.setBounds(23, 70, 298, 78);
					PanelPesquisa.setLayout(null);
					PanelPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
					{
						lbDtInicio = new JLabel();
						PanelPesquisa.add(lbDtInicio);
						lbDtInicio.setText("Data Inicio");
						lbDtInicio.setBounds(16, 26, 51, 14);
					}
					{
						tfDtInicio = new JTextField();
						PanelPesquisa.add(tfDtInicio);
						tfDtInicio.setBounds(16, 40, 121, 20);
					}
					{
						lbDtFim = new JLabel();
						PanelPesquisa.add(lbDtFim);
						lbDtFim.setText("Data Final");
						lbDtFim.setBounds(147, 26, 48, 14);
					}
					{
						tfDtFim = new JTextField();
						PanelPesquisa.add(tfDtFim);
						tfDtFim.setBounds(147, 40, 124, 20);
					}
					{
						lbAstInicio = new JLabel();
						PanelPesquisa.add(lbAstInicio);
						lbAstInicio.setText("*");
						lbAstInicio.setBounds(69, 26, 10, 14);
						lbAstInicio.setForeground(new java.awt.Color(196,0,0));
					}
					{
						lbAstFim = new JLabel();
						PanelPesquisa.add(lbAstFim);
						lbAstFim.setText("*");
						lbAstFim.setBounds(199, 26, 10, 14);
						lbAstFim.setForeground(new java.awt.Color(196,0,0));
					}
				}
			}
			pack();
			this.setSize(347, 371);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
