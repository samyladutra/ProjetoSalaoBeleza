package br.com.salao.view.Cidade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


import br.com.salao.dao.CidadeDAO;
import br.com.salao.view.Pagina_Inicial_correta;
import br.com.salao.vo.Cidade;


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
public class Consulta_Cidade extends javax.swing.JDialog {
	private JPanel Panel;
	private JTextField tfNome;
	private JButton btVoltar;
	private JButton btSair;
	private JScrollPane ScrollPaneConsulta;
	private JLabel lbNome;
	private JLabel lbConsulta;
	private JLabel lbicon;

	private DefaultTableModel TableModel;
	private JButton btExibirTodas;
	private JTable TableCidade;
	private CidadeDAO dao;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Consulta_Cidade(Connection conexao) throws SQLException  {
		super();
		dao = new CidadeDAO(conexao);
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Consulta de Cidade");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/buildingpesquisa.png")).getImage());
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				{
					lbicon = new JLabel();
					Panel.add(lbicon);
					lbicon.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/buildingpesquisa.png")));
					lbicon.setBounds(77, 24, 32, 32);
				}
				{
					lbConsulta = new JLabel();
					Panel.add(lbConsulta);
					lbConsulta.setText("Consulta de Cidade");
					lbConsulta.setBounds(123, 31, 227, 25);
					lbConsulta.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					lbNome = new JLabel();
					Panel.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(24, 75, 32, 14);
				}
				{
					tfNome = new JTextField();
					Panel.add(tfNome);
					tfNome.setBounds(24, 89, 281, 20);
					tfNome.getDocument().addDocumentListener(
							new DocumentListener() {

								@Override
								public void removeUpdate(DocumentEvent e) {
									atualizaGrid(tfNome.getText());
								}

								@Override
								public void insertUpdate(DocumentEvent e) {
									atualizaGrid(tfNome.getText());
								}

								@Override
								public void changedUpdate(DocumentEvent e) {
									atualizaGrid(tfNome.getText());
								}
							});
				}
				{
					ScrollPaneConsulta = new JScrollPane();
					Panel.add(ScrollPaneConsulta);
					ScrollPaneConsulta.setBounds(24, 122, 403, 114);
					ScrollPaneConsulta.getHorizontalScrollBar().setEnabled(
							false);
					{
						String colunas[] = { "CÛdigo", "Nome", "UF" };
						TableModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						TableCidade = new JTable();
						ScrollPaneConsulta.setViewportView(TableCidade);
						TableCidade.setModel(TableModel);
						// largura da 1a. coluna (0)
						TableCidade.getColumnModel().getColumn(0)
								.setPreferredWidth(80);
						TableCidade.getColumnModel().getColumn(0)
								.setResizable(false);
						// largura da 2a. coluna (1)
						TableCidade.getColumnModel().getColumn(1)
								.setPreferredWidth(200);
						TableCidade.getColumnModel().getColumn(1)
								.setResizable(false);
						TableCidade.getColumnModel().getColumn(2)
								.setPreferredWidth(80);
						TableCidade.getColumnModel().getColumn(2)
								.setResizable(false);
						TableCidade.setBounds(82, 121, 316, 66);

						// barra de rolagem vertical sempre vis√≠vel
						ScrollPaneConsulta
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre oculta
						ScrollPaneConsulta
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

					}
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btSair.setBounds(348, 247, 79, 24);
					btSair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							Pagina_Inicial_correta p = new Pagina_Inicial_correta();
							p.setLocationRelativeTo(null);
							p.setVisible(true);
							dispose();

						}
					});
				}
				{
					btVoltar = new JButton();
					Panel.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.setBounds(254, 247, 81, 24);
					/*btVoltar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Cadastro_Cidade inst = new Cadastro_Cidade(ConnectionFactory
									.getConnection());
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
							dispose();
							
						}
					});
					*/
				}
				{
					btExibirTodas = new JButton();
					Panel.add(btExibirTodas);
					btExibirTodas.setText("Exibir Todas");
					btExibirTodas.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/Listar.png")));
					btExibirTodas.setBounds(315, 87, 112, 24);
					btExibirTodas.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							atualizaGrid();
						}
					});
				}
			}
			pack();
			this.setSize(461, 325);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<Cidade> cidades = null;
		try {
			cidades = dao.getLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (cidades != null) {
			for (Cidade cidade : cidades)
				TableModel.addRow(cidade.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<Cidade> cidades = null;
		try {
			cidades = dao.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (cidades != null) {
			for (Cidade cidade : cidades)
				TableModel.addRow(cidade.toArray());
		}
	}
	
	/*private void atualizaGridCd(int codigo){
		List<Cidade> cidades = null;
		try {
			cidades = dao.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (cidades != null) {
			for (Cidade cidade : cidades)
				TableModel.addRow(cidade.toArray());
		}
	}
	
	*/

}
