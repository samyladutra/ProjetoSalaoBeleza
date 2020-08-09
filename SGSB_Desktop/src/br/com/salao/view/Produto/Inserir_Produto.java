package br.com.salao.view.Produto;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import br.com.salao.bo.MarcaBo;
import br.com.salao.bo.ProdutoBo;
import br.com.salao.dao.ConnectionFactory;
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
public class Inserir_Produto extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ButtonGroup buttonGroupArea;
	private JPanel PanelCadastro;
	private JRadioButton RadioButtonCab;
	private JComboBox ComboBoxMarca;
	private JLabel lbAstQuant;
	private JLabel lbTitulo;
	private JLabel btQuantidade;
	private JTextField tfQuantidade;
	private JButton btSair;
	private JButton btPesquisa;
	private JLabel lbAreaAst;
	private JLabel lbPrecoAst;
	private JLabel lbMarcaAst;
	private JLabel lbNomeAst;
	private JRadioButton RadioButtonMaq;
	private JRadioButton RadioButtonDep;
	private JRadioButton RadioButtonManPed;
	private JTextArea TextAreaDesc;
	private JScrollPane ScrollPaneDesc;
	private JLabel lbDescricao;
	private JTextField tfPreco;
	private JLabel lbPreco;
	private JButton btCancelar;
	private JButton btCadastrar;
	private JLabel lbMarca;
	private JLabel lbTipo;
	private JTextField tfNome;
	private JTextField tfCodigo;
	private JLabel lbNome;
	private JLabel lbCodigo;
	private ProdutoBo produtoBo;
	private ProdutoVo produtoVo;
	private MarcaVo mVo;
	private MarcaBo mBo;

	// public static String marca;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Inserir_Produto inst = new Inserir_Produto();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Inserir_Produto() {
		super();
		initGUI();
	}

	public Inserir_Produto(ProdutoVo produto) {
		System.out.println("PRODUTO: - "
				+ String.valueOf(produto.getCdProduto()));
		tfCodigo.setText(String.valueOf(produto.getCdProduto()));
		tfNome.setText(produto.getNmProduto());
		tfPreco.setText(String.valueOf(produto.getPreco()));
		TextAreaDesc.setText(produto.getDescricao());
	}

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				this.setResizable(false);
				this.setIconImage(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/cart_put.png")).getImage());
				this.setTitle("Inserir Produto");
				{
					PanelCadastro = new JPanel();
					getContentPane().add(PanelCadastro);
					PanelCadastro.setBorder(BorderFactory
							.createTitledBorder("Cadastro"));
					PanelCadastro.setLayout(null);
					PanelCadastro.setBounds(8, 79, 392, 350);
					buttonGroupArea = new ButtonGroup();

					// TALVEZ colocar o botao que permita cadastrar mais uma
					// vez. TALVEZ
					/*
					 * { btNovo = new JButton(); PanelCadastro.add(btNovo);
					 * btNovo.setText("Novo"); btNovo.setIcon(new
					 * ImageIcon(getClass
					 * ().getClassLoader().getResource("Icones/cart_add.png"
					 * ))); btNovo.setBounds(157, 208, 77, 25);
					 * btNovo.setSize(77, 23); btNovo.addActionListener(new
					 * ActionListener() {
					 * 
					 * @Override public void actionPerformed(ActionEvent e) {
					 * btNovo.setEnabled(false); btCadastrar.setEnabled(true);
					 * 
					 * tfCodigo.setText(null); btCadastrar.setText(null);
					 * tfNome.setText(null); tfMarca.setText(null);
					 * tfPreco.setText(null); RadioButtonCab.setSelected(false);
					 * RadioButtonDep.setSelected(false);
					 * RadioButtonManPed.setSelected(false);
					 * RadioButtonMaq.setSelected(false);
					 * TextAreaDesc.setText(null);
					 * 
					 * tfNome.setEditable(true); tfMarca.setEditable(true);
					 * tfPreco.setEditable(true);
					 * RadioButtonCab.setEnabled(true);
					 * RadioButtonDep.setEnabled(true);
					 * RadioButtonManPed.setEnabled(true);
					 * RadioButtonMaq.setEnabled(true);
					 * TextAreaDesc.setEditable(true); } }); }
					 */
				}
				{
					ScrollPaneDesc = new JScrollPane();
					PanelCadastro.add(ScrollPaneDesc);
					ScrollPaneDesc.setBounds(16, 202, 364, 99);
					{
						TextAreaDesc = new JTextArea();
						ScrollPaneDesc.setViewportView(TextAreaDesc);
						TextAreaDesc.setPreferredSize(new java.awt.Dimension(347, 95));
					}
				}
				{
					buttonGroupArea.add(RadioButtonCab);
					buttonGroupArea.add(RadioButtonDep);
					buttonGroupArea.add(RadioButtonManPed);
					buttonGroupArea.add(RadioButtonMaq);
				}
				{
					ComboBoxMarca = new JComboBox();
					PanelCadastro.add(ComboBoxMarca);
					mBo = new MarcaBo();

					List<MarcaVo> listaMarca = mBo.Lista();

					ComboBoxMarca.addItem("");
					for (MarcaVo m : listaMarca) {
						ComboBoxMarca.addItem(m);
					}
					AutoCompleteDecorator.decorate(ComboBoxMarca);
					ComboBoxMarca.setBounds(16, 91, 170, 20);
					ComboBoxMarca.setEditable(true);
				}
				{
					lbAstQuant = new JLabel();
					PanelCadastro.add(lbAstQuant);
					lbAstQuant.setText("*");
					lbAstQuant.setBounds(370, 78, 10, 14);
					lbAstQuant.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					btQuantidade = new JLabel();
					PanelCadastro.add(btQuantidade);
					btQuantidade.setText("Quantidade");
					btQuantidade.setBounds(312, 78, 56, 14);
				}
				{
					tfQuantidade = new JTextField();
					PanelCadastro.add(tfQuantidade);
					tfQuantidade.setBounds(312, 93, 68, 20);
				}
				{
					btSair = new JButton();
					PanelCadastro.add(btSair);
					btSair.setText("Sair");
					btSair.setBounds(16, 312, 81, 24);
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();
							Cadastro_Produto inst = new Cadastro_Produto();
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
							
						}
					});
				}
				{
					btPesquisa = new JButton();
					PanelCadastro.add(btPesquisa);
					btPesquisa.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/pesquisar.png")));
					btPesquisa.setBounds(192, 90, 29, 24);
					btPesquisa.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Selecionar_Marca inst = new Selecionar_Marca();
							inst.setVisible(true);
							inst.setLocationRelativeTo(null);
						}
					});
				}
				{
					lbAreaAst = new JLabel();
					PanelCadastro.add(lbAreaAst);
					lbAreaAst.setText("*");
					lbAreaAst.setBounds(103, 122, 10, 14);
					lbAreaAst.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					lbPrecoAst = new JLabel();
					PanelCadastro.add(lbPrecoAst);
					lbPrecoAst.setText("*");
					lbPrecoAst.setBounds(257, 82, 10, 14);
					lbPrecoAst.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					lbMarcaAst = new JLabel();
					PanelCadastro.add(lbMarcaAst);
					lbMarcaAst.setText("*");
					lbMarcaAst.setBounds(49, 77, 10, 14);
					lbMarcaAst.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					lbNomeAst = new JLabel();
					PanelCadastro.add(lbNomeAst);
					lbNomeAst.setText("*");
					lbNomeAst.setBounds(112, 31, 10, 14);
					lbNomeAst.setForeground(new java.awt.Color(196, 0, 0));
				}
				{
					RadioButtonMaq = new JRadioButton();
					PanelCadastro.add(RadioButtonMaq);
					RadioButtonMaq.setText("Maquiagem");
					RadioButtonMaq.setBounds(202, 150, 79, 23);
				}
				{
					RadioButtonCab = new JRadioButton();
					PanelCadastro.add(RadioButtonCab);
					RadioButtonCab.setText("Cabeleireira");
					RadioButtonCab.setBounds(16, 150, 83, 23);
				}
				{
					RadioButtonDep = new JRadioButton();
					PanelCadastro.add(RadioButtonDep);
					RadioButtonDep.setText("Depilação");
					RadioButtonDep.setBounds(302, 150, 71, 23);
				}
				{
					RadioButtonManPed = new JRadioButton();
					PanelCadastro.add(RadioButtonManPed);
					RadioButtonManPed
					.setText("<html>\r\nManicure/\r\n<br>\r\nPedicure\r\n</html>");
					RadioButtonManPed.setBounds(113, 146, 69, 27);
				}
				{
					lbDescricao = new JLabel();
					PanelCadastro.add(lbDescricao);
					lbDescricao.setText("Descrição");
					lbDescricao.setBounds(16, 188, 65, 14);
				}
				{
					tfPreco = new JTextField();
					PanelCadastro.add(tfPreco);
					tfPreco.setBounds(228, 93, 74, 20);
				}
				{
					lbPreco = new JLabel();
					PanelCadastro.add(lbPreco);
					lbPreco.setText("Preço");
					lbPreco.setBounds(228, 80, 29, 14);
				}
				{
					btCancelar = new JButton();
					PanelCadastro.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/Retiraar.png")));
					btCancelar.setBounds(275, 312, 105, 24);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {
							btCadastrar.setEnabled(true);
							
							tfNome.setText(null);
							ComboBoxMarca.setSelectedItem("");
							tfPreco.setText(null);
							RadioButtonCab.setSelected(false);
							RadioButtonDep.setSelected(false);
							RadioButtonManPed.setSelected(false);
							RadioButtonMaq.setSelected(false);
							TextAreaDesc.setText(null);
							
							long id = 0;
							try {
								id = produtoBo.ProximoId();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							tfCodigo.setText(String.valueOf(id));
							tfNome.setEditable(true);
							ComboBoxMarca.setEditable(true);
							tfPreco.setEditable(true);
							RadioButtonCab.setEnabled(true);
							RadioButtonDep.setEnabled(true);
							RadioButtonManPed.setEnabled(true);
							RadioButtonMaq.setEnabled(true);
							TextAreaDesc.setEditable(true);
						}
					});
				}
				{
					btCadastrar = new JButton();
					PanelCadastro.add(btCadastrar);
					btCadastrar.setText("Salvar");
					btCadastrar.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/Salvaar.png")));
					btCadastrar.setBounds(176, 312, 89, 24);
					btCadastrar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							String mensagem;
							
							String area = null;
							
							if (RadioButtonCab.isSelected()) {
								area = "Cabeleireira";
							} else {
								if (RadioButtonDep.isSelected()) {
									area = "Depilação";
								} else {
									if (RadioButtonManPed.isSelected()) {
										area = "Mani/Pedi";
									} else {
										if (RadioButtonMaq.isSelected()) {
											area = "Maquiagem";
										}
									}
								}
							}
							
							// mensagem é uma variavel que armazena a
							// mensagem de verificação. Se ela for !=
							// null significa que os campos estão ok. Se
							// nao, é que existe algo errado.
							
							produtoVo = new ProdutoVo(Integer
									.parseInt(tfCodigo.getText()), tfNome
									.getText(), String
									.valueOf(ComboBoxMarca
											.getSelectedItem()), Double
											.parseDouble(tfPreco.getText().replace(
													",", ".")), area, TextAreaDesc
													.getText(), Integer
													.parseInt(tfQuantidade.getText()));
									System.out
									.println("Quantidade de produto em estoque: "
											+ produtoVo.getQuantidade());
									produtoBo = new ProdutoBo();
									mensagem = produtoBo.verifica(produtoVo);
									if (mensagem.equals("")) {
										try {
											produtoBo.incluir(produtoVo);
										} catch (NumberFormatException e) {
											e.printStackTrace();
										} catch (SQLException e) {
											e.printStackTrace();
										}
										
										JOptionPane.showMessageDialog(null,
												"Produto inserido com sucesso!");
										
										tfNome.setText("");
										ComboBoxMarca.setSelectedItem("");
										tfPreco.setText("");
										TextAreaDesc.setText("");
										tfQuantidade.setText("");
										try {
											tfCodigo.setText(String
													.valueOf(produtoBo.ProximoId()));
										} catch (SQLException e1) {
											e1.printStackTrace();
										}
										// pesquisar como tirar o rddiobuttom
										// selecionado
										
										if (RadioButtonCab.isSelected()) {
											RadioButtonCab.setSelected(false);
										} else {
											if (RadioButtonDep.isSelected()) {
												RadioButtonDep.setSelected(false);
											} else {
												if (RadioButtonManPed.isSelected()) {
													RadioButtonMaq
													.setSelected(false);
												} else {
													if (RadioButtonMaq.isSelected()) {
														RadioButtonMaq
														.setSelected(false);
													}
												}
											}
										}
									} else {
										JOptionPane.showMessageDialog(null,
												mensagem);
									}
									
						}
					});
				}
				{
					lbMarca = new JLabel();
					PanelCadastro.add(lbMarca);
					lbMarca.setText("Marca");
					lbMarca.setBounds(18, 77, 32, 14);
				}
				{
					lbTipo = new JLabel();
					PanelCadastro.add(lbTipo);
					lbTipo.setText("Área de Utilização");
					lbTipo.setBounds(16, 122, 88, 14);
				}
				{
					tfNome = new JTextField();
					PanelCadastro.add(tfNome);
					tfNome.setBounds(83, 45, 297, 20);
				}
				{
					tfCodigo = new JTextField();
					PanelCadastro.add(tfCodigo);
					tfCodigo.setEditable(false);
					tfCodigo.setBounds(18, 45, 53, 20);
					ProdutoBo pBo = new ProdutoBo();
					long id = pBo.ProximoId();
					tfCodigo.setText(String.valueOf(id));
				}
				{
					lbNome = new JLabel();
					PanelCadastro.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(83, 31, 27, 14);
				}
				{
					lbCodigo = new JLabel();
					PanelCadastro.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(18, 31, 33, 14);
				}
			}
			{
				lbTitulo = new JLabel();
				getContentPane().add(lbTitulo);
				lbTitulo.setText("Inserir Produto");
				lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 26));
				lbTitulo.setBounds(98, 21, 235, 52);
				lbTitulo.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/cart_put.png")));
			}
			this.setSize(416, 467);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
