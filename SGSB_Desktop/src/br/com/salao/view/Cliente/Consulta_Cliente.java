package br.com.salao.view.Cliente;

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

import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.view.Pagina_Inicial_correta;
import br.com.salao.vo.Cliente;


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
public class Consulta_Cliente extends javax.swing.JDialog {
	private JPanel Panel;
	private JTextField tfNome;
	private JButton btCadastrar;
	private JLabel lbuser;
	private JButton btSair;
	private JLabel lbNome;
	private JScrollPane ScrollPaneConsulta;
	private JLabel lbConsulta;
	private DefaultTableModel TableModel;
	private JButton btVoltar;

	private ClienteDAO dao;
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
	 * 
	 * @throws SQLException
	 */

	public Consulta_Cliente(Connection conexao) throws SQLException {

		super();
		dao = new ClienteDAO(conexao);
		initGUI();
		atualizaGrid();
	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Consulta de Cliente");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/userMOD.png")).getImage());
			this.setDefaultLookAndFeelDecorated(true);
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				{
					lbConsulta = new JLabel();
					Panel.add(lbConsulta);
					lbConsulta.setText("Consulta de Cliente");
					lbConsulta.setBounds(153, 3, 256, 64);
					lbConsulta.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					lbNome = new JLabel();
					Panel.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(21, 55, 34, 19);
				}
				{
					tfNome = new JTextField();
					Panel.add(tfNome);
					tfNome.setBounds(21, 73, 345, 20);
					tfNome.getDocument().addDocumentListener(
							new DocumentListener() {

								@Override
								public void removeUpdate(
										DocumentEvent e) {
									atualizaGrid(tfNome
											.getText());
								}

								@Override
								public void insertUpdate(
										DocumentEvent e) {
									atualizaGrid(tfNome
											.getText());
								}

								@Override
								public void changedUpdate(
										DocumentEvent e) {
									atualizaGrid(tfNome
											.getText());
								}
							});

				}
				{
					ScrollPaneConsulta = new JScrollPane();
					Panel.add(ScrollPaneConsulta);
					ScrollPaneConsulta.setBounds(21, 102, 460, 146);
					ScrollPaneConsulta.getHorizontalScrollBar().setEnabled(
							false);
					{
						String colunas[] = { "CÛdigo", "Nome", "Telefone",
								"Cidade", "Sexo" };
						TableModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						JTable TableCliente = new JTable();
						ScrollPaneConsulta.setViewportView(TableCliente);
						TableCliente.setModel(TableModel);

						TableCliente.getColumnModel().getColumn(0)
								.setPreferredWidth(15);
						TableCliente.getColumnModel().getColumn(1)
								.setPreferredWidth(35);
						TableCliente.getColumnModel().getColumn(2)
								.setPreferredWidth(35);
						TableCliente.getColumnModel().getColumn(3)
								.setPreferredWidth(150);

						TableCliente.getColumnModel().getColumn(4)
								.setPreferredWidth(15);

						// barra de rolagem vertical sempre vis√≠vel
						ScrollPaneConsulta
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre visivel
						ScrollPaneConsulta
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

					}
				}
				{
					btVoltar = new JButton();
					Panel.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setBounds(286, 262, 93, 25);
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Cadastro_Cliente cc = new Cadastro_Cliente(
									ConnectionFactory
											.getConnection());
							cc.setLocationRelativeTo(null);
							cc.setVisible(true);
							dispose();
							
						}
					});
					/*btVoltar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
					*/
				}
				{
					lbuser = new JLabel();
					Panel.add(lbuser);
					lbuser.setBounds(109, 11, 34, 34);
					lbuser.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/userMOD.png")));
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btSair.setBounds(393, 262, 88, 25);
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
					btCadastrar = new JButton();
					Panel.add(btCadastrar);
					btCadastrar.setText("Cadastrar");
					btCadastrar.setBounds(371, 72, 110, 23);
					btCadastrar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/user_add16.png")));
					btCadastrar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Cadastro_Cliente cc = new Cadastro_Cliente(
									ConnectionFactory
											.getConnection());
							cc.setLocationRelativeTo(null);
							cc.setVisible(true);
							dispose();
							
						}
					});
				}
			}
			pack();
			this.setSize(514, 334);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<Cliente> Cliente = null;
		try {
			Cliente = dao.getLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableModel.addRow(cliente.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<Cliente> Cliente = null;
		try {
			Cliente = dao.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableModel.addRow(cliente.toArray());
		}
	}

}
