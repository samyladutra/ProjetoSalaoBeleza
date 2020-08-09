package br.com.salao.view.Pagamento;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class Selecionar_Pagamento extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JLabel lbPagamento;
	private JButton btPgparcela;
	private JButton btPgvista;

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
				Selecionar_Pagamento inst = new Selecionar_Pagamento();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}
	
	public Selecionar_Pagamento() {
		super();
		initGUI();
	}
	private void initGUI() {
		try {
			{
				this.setTitle("Tipo de Pagamento");
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setLayout(null);
				{
					lbPagamento = new JLabel();
					PanelTotal.add(lbPagamento);
					lbPagamento.setText("Tipo de Pagamento");
					lbPagamento.setBounds(29, 29, 268, 29);
					lbPagamento.setFont(new java.awt.Font("Tahoma",0,26));
					lbPagamento.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/card_money.png")));
				}
				{
					btPgvista = new JButton();
					PanelTotal.add(btPgvista);
					btPgvista.setText("<html>Pagamento <br>\r\nà vista\r\n</html>");
					btPgvista.setBounds(24, 86, 127, 65);
					btPgvista.setFont(new java.awt.Font("Tahoma",0,14));
					btPgvista.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/credit.png")));
				}
				{
					btPgparcela = new JButton();
					PanelTotal.add(btPgparcela);
					btPgparcela.setText("<html>Pagamento <br>\r\nà prazo\r\n</html>");
					btPgparcela.setBounds(167, 86, 130, 65);
					btPgparcela.setFont(new java.awt.Font("Tahoma",0,14));
					btPgparcela.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/creditcards.png")));
				}
			}
			this.setSize(335, 212);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
