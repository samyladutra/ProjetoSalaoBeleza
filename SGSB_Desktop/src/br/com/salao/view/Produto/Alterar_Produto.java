package br.com.salao.view.Produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import br.com.salao.bo.MarcaBo;
import br.com.salao.bo.ProdutoBo;
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
public class Alterar_Produto extends javax.swing.JDialog {
	private JPanel PanelTotal;
	private JTextField tfNome;
	private JLabel lbPreco;
	private JButton btSlavar;
	private JButton btCancelar;
	private JTextArea TextAreaDesc;
	private JLabel lbDescricao;
	private JScrollPane ScrollPaneDesc;
	private JRadioButton RadioButtonMaq;
	private JRadioButton RadioButtonCab;
	private JLabel lbNomeAst;
	private JLabel lbPrecoAst;
	private JLabel lbAstQuant;
	private JLabel lbAreaAst;
	private JButton btSair;
	private JComboBox ComboBoxMarca;
	private JButton btPesquisa;
	private JLabel jLabel1;
	private JLabel lbMarcaAst;
	private JTextField tfQuantidade;
	private JLabel lbQuantidade;
	private JRadioButton RadioButtonDep;
	private JRadioButton RadioButtonMani;
	private ButtonGroup buttonGroupArea;
	private JLabel lbArea;
	private JTextField tfPreco;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JLabel lbAlterar;
	private JLabel lbIcone;
	private MarcaBo mBo;

	private String area;

	private ProdutoVo produto;
	private ProdutoBo pBo;

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

	public Alterar_Produto(ProdutoVo produto) {
		super();
		this.produto = produto;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("Alterar Produto");
				this.setIconImage(new ImageIcon(getClass().getClassLoader()
						.getResource("Icones/cart_edit.png")).getImage());
			}
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, "Center");
				PanelTotal.setLayout(null);
				PanelTotal.setBounds(10, 11, 531, 572);
				PanelTotal.setPreferredSize(new java.awt.Dimension(531, 572));

				{
					lbIcone = new JLabel();
					PanelTotal.add(lbIcone);
					lbIcone.setBounds(85, 18, 47, 49);
					lbIcone.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/cart_edit32.png")));
				}
				{
					lbAlterar = new JLabel();
					PanelTotal.add(lbAlterar);
					lbAlterar.setText("Alterar Produto");
					lbAlterar.setBounds(131, 23, 223, 44);
					lbAlterar.setFont(new java.awt.Font("Tahoma", 0, 26));
				}
				{
					lbCodigo = new JLabel();
					PanelTotal.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(10, 77, 33, 14);
				}
				{
					tfCodigo = new JTextField();
					PanelTotal.add(tfCodigo);
					tfCodigo.setBounds(10, 91, 49, 20);
					tfCodigo.setEditable(false);
					tfCodigo.setText(String.valueOf(produto.getCdProduto()));
				}
				{
					lbNome = new JLabel();
					PanelTotal.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(71, 77, 27, 14);

				}
				{
					tfNome = new JTextField();
					PanelTotal.add(tfNome);
					tfNome.setBounds(69, 91, 288, 20);
					tfNome.setText(produto.getNmProduto());
				}
				{
					lbPreco = new JLabel();
					PanelTotal.add(lbPreco);
					lbPreco.setText("Preço");
					lbPreco.setBounds(226, 124, 27, 14);
				}
				{
					tfPreco = new JTextField();
					PanelTotal.add(tfPreco);
					tfPreco.setBounds(226, 138, 63, 20);
					tfPreco.setText(String.valueOf(produto.getPreco()).replace(
							".", ","));
				}
				{

					RadioButtonMani = new JRadioButton();
					RadioButtonMani
							.setText("<html>\r\nManicure/\r\n<br>\r\nPedicure\r\n<html>");
					RadioButtonMani.setBounds(112, 199, 69, 23);
					PanelTotal.add(RadioButtonMani);
				}

				{

					RadioButtonDep = new JRadioButton();
					RadioButtonDep.setText("Depilação");
					RadioButtonDep.setBounds(280, 199, 73, 23);
					PanelTotal.add(RadioButtonDep);
				}
				{
					RadioButtonCab = new JRadioButton();
					RadioButtonCab.setText("Cabeleireira");
					RadioButtonCab.setBounds(14, 199, 83, 23);
					PanelTotal.add(RadioButtonCab);
				}
				{
					RadioButtonMaq = new JRadioButton();
					RadioButtonMaq.setText("Maquiagem");
					RadioButtonMaq.setBounds(190, 199, 79, 23);
					PanelTotal.add(RadioButtonMaq);
				}
				{
					lbArea = new JLabel();
					PanelTotal.add(lbArea);
					lbArea.setText("Area de Utilização");
					lbArea.setBounds(11, 171, 86, 14);
					area = produto.getArea();
					System.out.println("(Produto_Alterar - Area:"
							+ produto.getArea());
					if (area.equals("Mani/Pedi")) {
						RadioButtonMani.setSelected(true);
					} else {
						if (area.equals("Depilação")) {
							RadioButtonDep.setSelected(true);
						} else {
							if (area.equals("Maquiagem")) {
								RadioButtonMaq.setSelected(true);
							} else {
								if (area.equals("Cabeleireira")) {
									RadioButtonCab.setSelected(true);
								}
							}
						}
					}

					buttonGroupArea = new ButtonGroup();
					buttonGroupArea.add(RadioButtonMani);
					buttonGroupArea.add(RadioButtonCab);
					buttonGroupArea.add(RadioButtonDep);
					buttonGroupArea.add(RadioButtonMaq);
					{
						ScrollPaneDesc = new JScrollPane();
						PanelTotal.add(ScrollPaneDesc);
						ScrollPaneDesc.setBounds(10, 257, 351, 87);
						{
							TextAreaDesc = new JTextArea();
							ScrollPaneDesc.setViewportView(TextAreaDesc);
							TextAreaDesc.setText(produto.getDescricao());
						}
					}
					{
						lbDescricao = new JLabel();
						PanelTotal.add(lbDescricao);
						lbDescricao.setText("Descrição");
						lbDescricao.setBounds(10, 239, 67, 14);
					}
					{
						btCancelar = new JButton();
						PanelTotal.add(btCancelar);
						btCancelar.setText("Cancelar");
						btCancelar.setBounds(258, 355, 103, 24);
						btCancelar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/retiraar.png")));
						btCancelar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								if ((tfNome.equals(produto.getNmProduto()))
										&& (ComboBoxMarca.getSelectedItem()
												.equals(produto.getMarca()))
										&& (tfPreco.equals(produto.getPreco()))
										&& (TextAreaDesc.equals(produto
												.getDescricao()))
										&& (area.equals(produto.getArea()))) {
									dispose();
								} else {
									if (JOptionPane
											.showOptionDialog(
													null,
													"Alteração não concluída. Deseja sair mesmo assim?",
													"",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													null, null, null) == 0) {
										dispose();
									}
								}
							}
						});
					}
					{
						btSlavar = new JButton();
						PanelTotal.add(btSlavar);
						btSlavar.setText("Salvar");
						btSlavar.setBounds(168, 355, 84, 24);
						btSlavar.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/Salvaar.png")));
						btSlavar.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String mensagem;

								if (RadioButtonCab.isSelected()) {
									area = "Cabeleireira";
								} else {

									if (RadioButtonDep.isSelected()) {
										area = "Depilacao";
									} else {
										if (RadioButtonMani.isSelected()) {
											area = "Mani/Pedi";
										} else {
											if (RadioButtonMaq.isSelected()) {
												area = "Maquiagem";
											}
										}
									}
								}
								pBo = new ProdutoBo();
								produto.setCdProduto(Integer.parseInt(tfCodigo
										.getText()));
								produto.setNmProduto(tfNome.getText());
								produto.setMarca(String.valueOf(ComboBoxMarca
										.getSelectedItem()));
								produto.setPreco(Double.parseDouble(tfPreco
										.getText().replace(",", ".")));
								produto.setArea(area);
								produto.setDescricao(TextAreaDesc.getText());
								produto.setQuantidade(Integer
										.parseInt(tfQuantidade.getText()));
								mensagem = pBo.verifica(produto);
								if (mensagem.equals("")) {
									try {
										pBo.alterar(produto);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}

									JOptionPane.showMessageDialog(null,
											"Alterações feitas");
								} else {
									JOptionPane.showMessageDialog(null,
											mensagem);
								}
								dispose();
							}
						});
					}
					{
						lbQuantidade = new JLabel();
						PanelTotal.add(lbQuantidade);
						lbQuantidade.setText("Quantidade");
						lbQuantidade.setBounds(295, 124, 56, 14);
					}
					{
						tfQuantidade = new JTextField();
						PanelTotal.add(tfQuantidade);
						tfQuantidade.setBounds(295, 138, 63, 20);
						tfQuantidade.setText(String.valueOf(produto
								.getQuantidade()));
					}
					{
						lbMarcaAst = new JLabel();
						PanelTotal.add(lbMarcaAst);
						lbMarcaAst.setText("*");
						lbMarcaAst.setForeground(new java.awt.Color(196, 0, 0));
						lbMarcaAst.setBounds(46, 121, 9, 14);
					}
					{
						jLabel1 = new JLabel();
						PanelTotal.add(jLabel1);
						jLabel1.setText("Marca");
						jLabel1.setBounds(12, 122, 32, 14);
					}
					{
						btPesquisa = new JButton();
						PanelTotal.add(btPesquisa);
						btPesquisa.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/pesquisar.png")));
						btPesquisa.setBounds(190, 135, 29, 24);
						btPesquisa.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								Selecionar_Marca inst = new Selecionar_Marca();
								inst.setVisible(true);
								inst.setLocationRelativeTo(null);
							}
						});
					}
					{

						ComboBoxMarca = new JComboBox();
						mBo = new MarcaBo();

						List<MarcaVo> listaMarca = mBo.Lista();

						ComboBoxMarca.addItem(produto.getMarca());
						for (MarcaVo m : listaMarca) {
							ComboBoxMarca.addItem(m);
						}
						AutoCompleteDecorator.decorate(ComboBoxMarca);
						PanelTotal.add(ComboBoxMarca);

						ComboBoxMarca.setEditable(true);
						ComboBoxMarca.setBounds(10, 137, 170, 20);

					}
					{
						btSair = new JButton();
						PanelTotal.add(btSair);
						btSair.setText("Sair");
						btSair.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource(
										"Icones/door_out.png")));
						btSair.setBounds(10, 355, 81, 24);
						btSair.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								Cadastro_Produto inst = new Cadastro_Produto();
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);

							}
						});
					}
					{
						lbAreaAst = new JLabel();
						PanelTotal.add(lbAreaAst);
						lbAreaAst.setText("*");
						lbAreaAst.setForeground(new java.awt.Color(196, 0, 0));
						lbAreaAst.setBounds(97, 169, 15, 18);
					}
					{
						lbAstQuant = new JLabel();
						PanelTotal.add(lbAstQuant);
						lbAstQuant.setText("*");
						lbAstQuant.setForeground(new java.awt.Color(196, 0, 0));
						lbAstQuant.setBounds(352, 120, 13, 20);
					}
					{
						lbPrecoAst = new JLabel();
						PanelTotal.add(lbPrecoAst);
						lbPrecoAst.setText("*");
						lbPrecoAst.setForeground(new java.awt.Color(196, 0, 0));
						lbPrecoAst.setBounds(255, 122, 12, 17);
					}
					{
						lbNomeAst = new JLabel();
						PanelTotal.add(lbNomeAst);
						lbNomeAst.setText("*");
						lbNomeAst.setForeground(new java.awt.Color(196, 0, 0));
						lbNomeAst.setBounds(99, 78, 13, 12);
					}
				}
			}
			this.setSize(395, 436);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
