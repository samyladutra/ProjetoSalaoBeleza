package br.com.salao.view.Marca;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.salao.bo.MarcaBo;
import br.com.salao.bo.ProdutoBo;
import br.com.salao.view.Produto.Inserir_Produto;
import br.com.salao.view.Produto.Alterar_Produto;
import br.com.salao.vo.MarcaVo;
import br.com.salao.vo.ProdutoVo;

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
public class Marca_Consulta extends javax.swing.JDialog {
	private JPanel Panel;
	private JTextField tfNome;
	private JButton btInserir;
	private JButton btAlterar;
	private JButton btExcluir;
	private JTable TableMarca;
	private JButton btSair;
	private JScrollPane ScrollPaneMarcas;
	private JButton btListarTodas;
	private JButton btPesquisar;
	private JLabel lbNome;
	private JLabel lbConsultar;
	private MarcaVo mVo;
	private MarcaBo mBo;
	private DefaultTableModel TableMarcaModel;
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
				Marca_Consulta inst = new Marca_Consulta();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Marca_Consulta() {
		super();
		initGUI();
	}

	public Marca_Consulta(int i) {
		atualizaGrid();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Cadastro de Marca");
				{
					Panel = new JPanel();
					getContentPane().add(Panel, BorderLayout.CENTER);
					Panel.setLayout(null);
					Panel.setPreferredSize(new java.awt.Dimension(402, 265));
					{
						lbConsultar = new JLabel();
						Panel.add(lbConsultar);
						lbConsultar.setText("Cadastro de Marca");
						lbConsultar.setBounds(53, 18, 271, 55);
						lbConsultar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/inbox_table.png")));
						lbConsultar
						.setFont(new java.awt.Font("Lucida Sans", 0, 24));
					}
					{
						tfNome = new JTextField();
						Panel.add(tfNome);
						tfNome.setBounds(10, 98, 206, 20);
						tfNome.getDocument().addDocumentListener(
								new DocumentListener() {
									
									@Override
									public void removeUpdate(DocumentEvent e) {
										atualizaGridNome(tfNome.getText());
										
									}
									
									@Override
									public void insertUpdate(DocumentEvent e) {
										atualizaGridNome(tfNome.getText());
										
									}
									
									@Override
									public void changedUpdate(DocumentEvent e) {
										atualizaGridNome(tfNome.getText());
										
									}
								});
					}
					{
						lbNome = new JLabel();
						Panel.add(lbNome);
						lbNome.setText("Nome");
						lbNome.setBounds(10, 84, 27, 14);
					}
					{
						btPesquisar = new JButton();
						Panel.add(btPesquisar);
						btPesquisar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btPesquisar.setBounds(220, 96, 35, 24);
						btPesquisar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								atualizaGridNome(tfNome.getText());
							}
						});
					}
					{
						btListarTodas = new JButton();
						Panel.add(btListarTodas);
						btListarTodas.setText("Listar Todas");
						btListarTodas.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/document_comment_below.png")));
						btListarTodas.setBounds(258, 96, 110, 24);
						btListarTodas.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								atualizaGrid();
							}
						});
					}
					{
						ScrollPaneMarcas = new JScrollPane();
						Panel.add(ScrollPaneMarcas);
						ScrollPaneMarcas.setBounds(10, 129, 356, 112);
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
						btExcluir = new JButton();
						Panel.add(btExcluir);
						btExcluir.setText("Excluir");
						btExcluir.setIcon(new ImageIcon(getClass().getClassLoader()
								.getResource("Icones/excluir.png")));
						btExcluir.setBounds(192, 247, 83, 24);
						btExcluir.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								int linhaSelecionada = TableMarca.getSelectedRow();
								if (linhaSelecionada < 0) {
									JOptionPane.showMessageDialog(null,
											"Selecione uma linha para excluir!");
								} else {
									if (JOptionPane.showOptionDialog(null,
											"Deseja excluir esse produto?", "",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE, null,
													null, null) == 0) {
										// para pegar o codigo que está na
										// tabela e apartir dele excluir no
										// BD
										Object obj = TableMarca.getValueAt(
												TableMarca.getSelectedRow(), 0);
										int codigo;
										String cd;
										cd = String.valueOf(obj);
										codigo = Integer.parseInt(cd);
										
										try {
											mBo.excluir(codigo);
										} catch (SQLException e) {
											// TODO Auto-generated catch
											// block
											e.printStackTrace();
										}
										JOptionPane.showMessageDialog(null,
												"Produto excluído com sucesso!");
										atualizaGrid();
										
									}
								}
								
							}
						});
					}
					{
						btAlterar = new JButton();
						Panel.add(btAlterar);
						btAlterar.setText("Alterar");
						btAlterar.setIcon(new ImageIcon(getClass().getClassLoader()
								.getResource("Icones/alterar.png")));
						btAlterar.setBounds(281, 247, 85, 24);
						btAlterar.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								int linhaSelecionada = TableMarca.getSelectedRow();
								if (linhaSelecionada < 0) {
									JOptionPane.showMessageDialog(null,
											"Selecione uma linha para alterar!");
								} else {
									Object obj = TableMarca.getValueAt(
											TableMarca.getSelectedRow(), 0);
									int codigo;
									String cd;
									cd = String.valueOf(obj);
									codigo = Integer.parseInt(cd);
									try {
										mVo = mBo.DescobrirMarca(codigo);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									
									Marca_Inserir inst = new Marca_Inserir(mVo);
									inst.setLocationRelativeTo(null);
									inst.setVisible(true);
									atualizaGrid();
								}
								
							}
						});
					}
					{
						btInserir = new JButton();
						Panel.add(btInserir);
						btInserir.setText("Inserir");
						btInserir.setIcon(new ImageIcon(getClass().getClassLoader()
								.getResource("Icones/Maaiis.png")));
						btInserir.setBounds(100, 247, 86, 24);
						btInserir.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								
								Marca_Inserir inst = new Marca_Inserir();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}
						});
					}
					{
						btSair = new JButton();
						Panel.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Icones/door_out.png")));
						btSair.setBounds(11, 247, 83, 24);
						btSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								
							}
						});
					}
				}
			}
			this.setSize(395, 325);
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
