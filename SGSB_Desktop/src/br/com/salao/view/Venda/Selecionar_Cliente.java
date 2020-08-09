package br.com.salao.view.Venda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import br.com.salao.bo.ClienteBo;
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
public class Selecionar_Cliente extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JButton btSair;
	private JButton btSelecionar;
	private JTable TableCliente;
	private JScrollPane ScrollPane;
	private JButton btListarTodos;
	private JButton btPesquisarCli;
	private JTextField tfNmCliente;
	private JLabel lbNmCliente;
	private JLabel lbSelecionarCli;
	private DefaultTableModel TableClienteModel;
	private ClienteBo cliBo;
	private Cliente cliVo;
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
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Selecionar_Cliente inst = new Selecionar_Cliente();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Selecionar_Cliente() {
		super();
		initGUI();
	}

	public Selecionar_Cliente(String NmCliente) {
		this();
		atualizaGrid(NmCliente);
	}

	private void initGUI() {
		try {
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbSelecionarCli = new JLabel();
					PanelTotal.add(lbSelecionarCli);
					lbSelecionarCli.setText("Selecionar Cliente");
					lbSelecionarCli.setBounds(118, 26, 231, 34);
					lbSelecionarCli.setFont(new java.awt.Font("Lucida Sans", 0,
							24));
					lbSelecionarCli.setToolTipText("Selecionar Cliente");
				}
				{
					lbNmCliente = new JLabel();
					PanelTotal.add(lbNmCliente);
					lbNmCliente.setText("Nome do cliente");
					lbNmCliente.setBounds(10, 68, 76, 14);
				}
				{
					tfNmCliente = new JTextField();
					PanelTotal.add(tfNmCliente);
					tfNmCliente.setBounds(10, 82, 271, 20);
					tfNmCliente.addKeyListener(new KeyListener() {

						@Override
						// clicou-soltou
						public void keyTyped(KeyEvent arg0) {

						}

						@Override
						// quando o botao é solto
						public void keyReleased(KeyEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						// quando o botao é pressionado
						public void keyPressed(KeyEvent s) {
							if (s.getKeyCode() == 10) {
								atualizaGrid(tfNmCliente.getText());
							}

						}
					});

				}
				{
					btPesquisarCli = new JButton();
					PanelTotal.add(btPesquisarCli);
					btPesquisarCli.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisarCli.setBounds(287, 78, 41, 24);
					btPesquisarCli.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if (tfNmCliente.getText().equals("")) {
								JOptionPane.showMessageDialog(null,
										"Digite o nome do cliente.");
							} else {

								atualizaGrid(tfNmCliente.getText());
							}

						}
					});
				}
				{
					btListarTodos = new JButton();
					PanelTotal.add(btListarTodos);
					btListarTodos.setText("Listar Todos");
					btListarTodos.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/document_comment_below.png")));
					btListarTodos.setBounds(334, 78, 111, 24);
					btListarTodos.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							atualizaGrid();

						}
					});
				}
				{
					ScrollPane = new JScrollPane();
					PanelTotal.add(ScrollPane);
					ScrollPane.setBounds(10, 108, 435, 187);
					{
						String colunas[] = { "Código", "Nome", "Telefone",
								"CPF", "E-mail" };
						TableClienteModel = new DefaultTableModel(colunas, 0) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};

						TableCliente = new JTable();
						ScrollPane.setViewportView(TableCliente);
						TableCliente.setModel(TableClienteModel);

						TableCliente.getColumnModel().getColumn(0)
								.setPreferredWidth(10);
						TableCliente.getColumnModel().getColumn(1)
								.setPreferredWidth(35);
						TableCliente.getColumnModel().getColumn(2)
								.setPreferredWidth(15);
						TableCliente.getColumnModel().getColumn(3)
								.setPreferredWidth(13);
						TableCliente.getColumnModel().getColumn(4)
								.setPreferredWidth(70);
					}
				}
				{
					btSelecionar = new JButton();
					PanelTotal.add(btSelecionar);
					btSelecionar.setText("Selecionar");
					btSelecionar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/hand_point_090.png")));
					btSelecionar.setBounds(10, 301, 101, 25);
					btSelecionar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Object obj = TableCliente.getValueAt(
									TableCliente.getSelectedRow(), 0);

							String cd;
							int i;
							cd = String.valueOf(obj);
							i = Integer.parseInt(cd);
							new Cliente();
							try {

								cliVo = cliBo.DescobrirCliente(i);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							Consulta_Vendas.tfCliente.setText(cliVo.getNome());
							Consulta_Vendas.tfCdCliente.setText(String
									.valueOf(cliVo.getCodigo()));
							dispose();

						}
					});
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(362, 301, 83, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
			}
			this.setSize(468, 371);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void atualizaGrid() {
		List<Cliente> Cliente = null;
		cliBo = new ClienteBo();
		try {
			Cliente = cliBo.Lista();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableClienteModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableClienteModel.addRow(cliente.toArray());
		}
	}

	private void atualizaGrid(String nome) {
		List<Cliente> Cliente = null;
		cliBo = new ClienteBo();
		try {
			Cliente = cliBo.ListaPorNome(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		TableClienteModel.setNumRows(0);
		if (Cliente != null) {
			for (Cliente cliente : Cliente)
				TableClienteModel.addRow(cliente.toArray());
		}
	}

}
