package br.com.salao.view.Produto;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import br.com.salao.bo.MarcaBo;
import br.com.salao.vo.MarcaVo;

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
public class Selecionar_Marca extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JTextField tfNome;
	private JLabel lbNome;
	private JTable TableMarca;
	private JScrollPane ScrollPaneMarcas;
	private JButton btPesquisar;
	private JButton btListarTodas;
	private JButton btSair;
	private JButton btOK;
	private JLabel lbConsultar;
	private MarcaBo mBo;
	private DefaultTableModel TableMarcaModel;

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
				Selecionar_Marca inst = new Selecionar_Marca();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}
	
	public Selecionar_Marca( ) {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setTitle("Selecionar Marca");
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				PanelTotal.setPreferredSize(new java.awt.Dimension(447, 285));
				{
					lbConsultar = new JLabel();
					PanelTotal.add(lbConsultar);
					lbConsultar.setText("Selecionar Marca");
					lbConsultar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/inbox_table.png")));
					lbConsultar.setFont(new java.awt.Font("Lucida Sans",0,24));
					lbConsultar.setBounds(98, 11, 234, 55);
				}
				{
					
					btOK = new JButton();
					PanelTotal.add(btOK);
					btOK.setText("Selecionar");
					btOK.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/hand_point_090.png")));
					btOK.setBounds(10, 242, 102, 24);
					btOK.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Object obj = TableMarca.getValueAt(
									TableMarca.getSelectedRow(), 0);
							
							String cd;
							int i;
							cd = String.valueOf(obj);
							i = Integer.parseInt(cd);
							new MarcaVo();
							try {
								mBo.DescobrirMarca(i);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							dispose();
							
						}
					});
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
					btSair.setBounds(354, 242, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					btListarTodas = new JButton();
					PanelTotal.add(btListarTodas);
					btListarTodas.setText("Listar Todas");
					btListarTodas.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/document_comment_below.png")));
					btListarTodas.setBounds(320, 89, 117, 24);
					btListarTodas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGrid();
						}
					});
				}
				{
					btPesquisar = new JButton();
					PanelTotal.add(btPesquisar);
					btPesquisar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/pesquisar.png")));
					btPesquisar.setBounds(279, 89, 35, 24);
					btPesquisar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGridNome(tfNome.getText());
						}
					});
				}
				{
					ScrollPaneMarcas = new JScrollPane();
					PanelTotal.add(ScrollPaneMarcas);
					ScrollPaneMarcas.setBounds(10, 124, 427, 112);
					{
						String colunas[] = { "Código", "Nome" };
						TableMarcaModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						
						TableMarca = new JTable();
						ScrollPaneMarcas.setViewportView(TableMarca);
						TableMarca.setModel(TableMarcaModel);
						
						TableMarca.getColumnModel().getColumn(0)
						.setPreferredWidth(10);
						TableMarca.getColumnModel().getColumn(1)
						.setPreferredWidth(35);
					}
				}
				{
					lbNome = new JLabel();
					PanelTotal.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(10, 79, 27, 14);
				}
				{
					tfNome = new JTextField();
					PanelTotal.add(tfNome);
					tfNome.setBounds(10, 93, 263, 20);
				}
			}
			this.setSize(467, 320);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void atualizaGrid() {
		List<MarcaVo> MarcaVo = null;
		mBo = new MarcaBo();
		try {

			MarcaVo = mBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableMarcaModel.setNumRows(0);
		if (MarcaVo != null) {
			for (MarcaVo marca : MarcaVo)
				TableMarcaModel.addRow(marca.toArray());
		}
	}

	private void atualizaGridNome(String nome) {
		List<MarcaVo> MarcaVo = null;
		mBo = new MarcaBo();
		try {
			MarcaVo = mBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableMarcaModel.setNumRows(0);
		if (MarcaVo != null) {
			for (MarcaVo marca : MarcaVo)
				TableMarcaModel.addRow(marca.toArray());
		}
	}

}
