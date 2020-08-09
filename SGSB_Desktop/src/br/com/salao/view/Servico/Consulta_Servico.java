package br.com.salao.view.Servico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import br.com.salao.dao.ConnectionFactory;
import br.com.salao.dao.ServicoDAO;
import br.com.salao.vo.ServicoVo;


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
public class Consulta_Servico extends javax.swing.JDialog {
	private JTextField tfNome;
	private JButton btCadastrar;
	private JButton btsair;
	private JLabel lbpesquisar;
	private JLabel lbNome;
	private JButton btVoltar;
	private JTable TabelaServico;
	private JScrollPane ScrollPaneConsulta;
	private JLabel lbConsulta;
	private JPanel Panel;
	private DefaultTableModel TableModel;
	private ServicoDAO daoServico;

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

	public Consulta_Servico(Connection conexao) throws SQLException {
		super();
		daoServico = new ServicoDAO(conexao);
		initGUI();
		atualizaGrid();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Consulta de Serviço");
			this.setModal(true);
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/secador.png")).getImage());
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				{
					lbConsulta = new JLabel();
					Panel.add(lbConsulta);
					lbConsulta.setText("Consulta de Serviço");
					lbConsulta.setBounds(139, 11, 264, 43);
					lbConsulta.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					lbNome = new JLabel();
					Panel.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(23, 64, 46, 19);
				}
				{
					tfNome = new JTextField();
					Panel.add(tfNome);
					tfNome.setBounds(23, 80, 320, 20);
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
					ScrollPaneConsulta.setBounds(22, 113, 443, 159);
					{
						String colunas[] = { "Código", "Nome", "Duração",
								"Descrição", "Preço" };
						TableModel = new DefaultTableModel(colunas, 0) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						TabelaServico = new JTable(TableModel);
						ScrollPaneConsulta.setViewportView(TabelaServico);
						TabelaServico.setModel(TableModel);

						// largura da 1a. coluna (0)
						TabelaServico.getColumnModel().getColumn(0)
								.setPreferredWidth(70);
						TabelaServico.getColumnModel().getColumn(0)
								.setResizable(false);
						// largura da 2a. coluna (1)
						TabelaServico.getColumnModel().getColumn(1)
								.setPreferredWidth(125);
						TabelaServico.getColumnModel().getColumn(1)
								.setResizable(false);
						TabelaServico.getColumnModel().getColumn(2)
								.setPreferredWidth(90);
						TabelaServico.getColumnModel().getColumn(2)
								.setResizable(false);
						TabelaServico.getColumnModel().getColumn(3)
								.setPreferredWidth(200);
						TabelaServico.getColumnModel().getColumn(3)
								.setResizable(false);
						TabelaServico.getColumnModel().getColumn(4)
								.setPreferredWidth(80);
						TabelaServico.getColumnModel().getColumn(4)
								.setResizable(false);

						TabelaServico.setBounds(82, 121, 316, 66);

						// barra de rolagem vertical sempre visÃ­vel
						ScrollPaneConsulta
								.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						// barra de rolagem horizontal sempre oculta
						ScrollPaneConsulta
								.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					}
				}
				{
					btVoltar = new JButton();
					Panel.add(btVoltar);
					btVoltar.setText("Voltar");
					btVoltar.setBounds(292, 283, 96, 24);
					btVoltar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/voltar.png")));
					btVoltar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							
						}
					});
				}
				{
					lbpesquisar = new JLabel();
					Panel.add(lbpesquisar);
					lbpesquisar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/escova_secadorpesquisa.png")));
					lbpesquisar.setBounds(94, 11, 35, 32);
				}
				{
					btsair = new JButton();
					Panel.add(btsair);
					btsair.setText("Sair");
					btsair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/walk.png")));
					btsair.setBounds(394, 283, 71, 24);
					btsair.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
				}
				{
					btCadastrar = new JButton();
					Panel.add(btCadastrar);
					btCadastrar.setText("Cadastrar");
					btCadastrar.setBounds(349, 79, 116, 23);
					btCadastrar
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/Maaiis.png")));
					btCadastrar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {

							Cadastro_de_Serviços_2 inst = new Cadastro_de_Serviços_2(
									ConnectionFactory.getConnection());
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
							dispose();

						}
					});
				}
			}
			pack();
			this.setSize(497, 352);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<ServicoVo> servicos = null;
		try {
			servicos = daoServico.getLista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TableModel.addRow(servico.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<ServicoVo> servicos = null;
		try {
			servicos = daoServico.getListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableModel.setNumRows(0);
		if (servicos != null) {
			for (ServicoVo servico : servicos)
				TableModel.addRow(servico.toArray());
		}
	}

}
