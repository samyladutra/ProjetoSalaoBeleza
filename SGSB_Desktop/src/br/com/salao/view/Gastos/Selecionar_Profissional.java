package br.com.salao.view.Gastos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
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
public class Selecionar_Profissional extends javax.swing.JDialog {
	private JPanel Panel;
	private JTextField tfNmProfissional;
	private JButton btSelecionar;
	private JButton btSair;
	private JTable TableItens;
	private JScrollPane ScrollPane;
	private JButton btPesquisaLista;
	private JButton btPesquisa;
	private JLabel btNome;
	private JLabel btSelecionarProf;

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
				Selecionar_Profissional inst = new Selecionar_Profissional(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public Selecionar_Profissional(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				{
					btSelecionarProf = new JLabel();
					Panel.add(btSelecionarProf);
					btSelecionarProf.setText("Selecionar Profissional");
					btSelecionarProf.setBounds(100, 25, 244, 49);
					btSelecionarProf.setFont(new java.awt.Font("Tahoma",0,24));
				}
				{
					btNome = new JLabel();
					Panel.add(btNome);
					btNome.setText("Nome do Profissional");
					btNome.setBounds(10, 85, 134, 14);
				}
				{
					tfNmProfissional = new JTextField();
					Panel.add(tfNmProfissional);
					tfNmProfissional.setBounds(10, 99, 270, 20);
				}
				{
					btPesquisa = new JButton();
					Panel.add(btPesquisa);
					btPesquisa.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisa.setBounds(286, 96, 43, 24);
				}
				{
					btPesquisaLista = new JButton();
					Panel.add(btPesquisaLista);
					btPesquisaLista.setText("Listar Todos");
					btPesquisaLista.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/blogs.png")));
					btPesquisaLista.setBounds(334, 96, 111, 24);
				}
				{
					ScrollPane = new JScrollPane();
					Panel.add(ScrollPane);
					ScrollPane.setBounds(10, 131, 435, 165);
					{
						TableModel TableItensModel = 
								new DefaultTableModel(
										new String[][] { { "One", "Two" }, { "Three", "Four" } },
										new String[] { "Column 1", "Column 2" });
						TableItens = new JTable();
						ScrollPane.setViewportView(TableItens);
						TableItens.setModel(TableItensModel);
					}
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(362, 303, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					btSelecionar = new JButton();
					Panel.add(btSelecionar);
					btSelecionar.setText("Selecionar");
					btSelecionar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/hand_point_090.png")));
					btSelecionar.setBounds(10, 303, 101, 25);
					btSelecionar.setSize(101, 24);
				}
			}
			this.setSize(475, 372);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
