package br.com.salao.view.Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import br.com.salao.dao.CidadeDAO;
import br.com.salao.dao.ClienteDAO;
import br.com.salao.dao.ConnectionFactory;
import br.com.salao.vo.Cidade;
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
public class Alterar_Cliente extends javax.swing.JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JLabel lbAlterar;
	private JTextField tfNome;
	private JLabel lbEmail;
	private JTextField tfCPF;
	private JLabel lbCPF;
	private JTextField tfTelefone;
	private JLabel lbTelefone;
	private JLabel lbSexo;
	private JLabel lbBairro;
	private JRadioButton jRadioButton1;
	private JRadioButton RadioButton;
	private ButtonGroup buttonGroupSexo;
	private JLabel lbcliente;
	private JButton btSalvar;
	private JButton btCancelar;
	private JTextField tfComplemento;
	private JTextField tfRua;
	private JLabel lbComplemento;
	private JTextField tfNum;
	private JLabel lbNum;
	private JLabel lbRua;
	private JTextField tfBairro;
	private JComboBox ComboBoxCidade;
	private JLabel lbCidade;
	private JTextField tfEmail;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private String sexo;

	private Cliente cliente;
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
	 */

	public Alterar_Cliente(Cliente cliente) {
		super();
		this.cliente = cliente;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Alterar Cliente");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/user_edit.png")).getImage());
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					lbAlterar = new JLabel();
					jPanel1.add(lbAlterar);
					lbAlterar.setText("Alterar Cliente");
					lbAlterar.setBounds(118, 11, 171, 36);
					lbAlterar.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					lbCodigo = new JLabel();
					jPanel1.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(10, 56, 42, 14);
				}
				{
					tfCodigo = new JTextField();
					jPanel1.add(tfCodigo);
					tfCodigo.setBounds(10, 70, 42, 20);
					tfCodigo.setEnabled(false);
					tfCodigo.setText(String.valueOf(cliente.getCodigo()));
				}
				{
					lbNome = new JLabel();
					jPanel1.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(62, 54, 47, 19);
				}
				{
					tfNome = new JTextField();
					jPanel1.add(tfNome);
					tfNome.setBounds(62, 70, 233, 20);
					tfNome.setText(cliente.getNome());
				}
				{
					lbSexo = new JLabel();
					jPanel1.add(lbSexo);
					lbSexo.setText("Sexo");
					lbSexo.setBounds(305, 55, 48, 17);
				}
				{
					lbTelefone = new JLabel();
					jPanel1.add(lbTelefone);
					lbTelefone.setText("Telefone");
					lbTelefone.setBounds(10, 107, 42, 14);
				}
				{
					tfTelefone = new JTextField();
					jPanel1.add(tfTelefone);
					tfTelefone.setBounds(12, 121, 88, 20);
					tfTelefone.setText(String.valueOf(cliente.getTelefone()));
				}
				{
					lbCPF = new JLabel();
					jPanel1.add(lbCPF);
					lbCPF.setText("CPF");
					lbCPF.setBounds(110, 105, 53, 14);
				}
				{
					tfCPF = new JTextField();
					jPanel1.add(tfCPF);
					tfCPF.setBounds(110, 119, 96, 20);
					tfCPF.setText(String.valueOf(cliente.getCpf()));
				}
				{
					lbEmail = new JLabel();
					jPanel1.add(lbEmail);
					lbEmail.setText("Email");
					lbEmail.setBounds(216, 105, 51, 14);
				}
				{
					tfEmail = new JTextField();
					jPanel1.add(tfEmail);
					tfEmail.setBounds(216, 119, 167, 20);
					tfEmail.setText(cliente.getEmail());
				}
				{
					lbCidade = new JLabel();
					jPanel1.add(lbCidade);
					lbCidade.setText("Cidade");
					lbCidade.setBounds(218, 157, 66, 14);
				}
				{
					CidadeDAO dao = new CidadeDAO(
							ConnectionFactory.getConnection());
					ComboBoxCidade = new JComboBox();
					// pegando uma lista de cidade
					List<Cidade> cids = dao.getLista();

					for (Cidade c : cids)
						ComboBoxCidade.addItem(c);
					jPanel1.add(ComboBoxCidade);
					ComboBoxCidade.setBounds(218, 170, 165, 20);
					/*
					 * CidadeDAO dao = new CidadeDAO(
					 * ConnectionFactory.getConnection()); ComboboxCidade = new
					 * JComboBox(); // pegando uma lista de cidade List<Cidade>
					 * cids = dao.getLista();
					 * 
					 * for (Cidade c : cids) ComboboxCidade.addItem(c);
					 * 
					 * jPanel1.add(ComboboxCidade); //
					 * ComboboxCidade.setModel(ComboboxCidadeModel);
					 * ComboboxCidade.setBounds(235, 121, 173, 20);
					 */
				}
				{
					lbBairro = new JLabel();
					jPanel1.add(lbBairro);
					lbBairro.setText("Bairro");
					lbBairro.setBounds(12, 157, 57, 14);
				}
				{
					tfBairro = new JTextField();
					jPanel1.add(tfBairro);
					tfBairro.setBounds(10, 170, 198, 20);
					tfBairro.setText(cliente.getBairro());
				}
				{
					lbRua = new JLabel();
					jPanel1.add(lbRua);
					lbRua.setText("Rua");
					lbRua.setBounds(10, 206, 27, 14);
				}
				{
					tfRua = new JTextField();
					jPanel1.add(tfRua);
					tfRua.setBounds(10, 220, 198, 20);
					tfRua.setText(cliente.getRua());
				}
				{
					lbNum = new JLabel();
					jPanel1.add(lbNum);
					lbNum.setText("Numero");
					lbNum.setBounds(218, 207, 37, 14);
				}
				{
					tfNum = new JTextField();
					jPanel1.add(tfNum);
					tfNum.setBounds(218, 220, 56, 20);
					tfNum.setText(String.valueOf(cliente.getNumero()));
				}
				{
					lbComplemento = new JLabel();
					jPanel1.add(lbComplemento);
					lbComplemento.setText("Complemento");
					lbComplemento.setBounds(284, 207, 65, 14);
				}
				{
					tfComplemento = new JTextField();
					jPanel1.add(tfComplemento);
					tfComplemento.setBounds(284, 220, 99, 20);
					System.out.println(cliente.getComplemento());
					tfComplemento.setText(cliente.getComplemento());
				}
				{
					btCancelar = new JButton();
					jPanel1.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setBounds(279, 262, 104, 23);
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/Retiraar.png")));
					btCancelar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
				{
					RadioButton = new JRadioButton();
					jPanel1.add(RadioButton);
					RadioButton.setText("F");
					RadioButton.setBounds(301, 69, 31, 23);

					jRadioButton1 = new JRadioButton();
					jPanel1.add(jRadioButton1);
					jRadioButton1.setText("M");
					jRadioButton1.setBounds(337, 69, 33, 23);

					sexo = cliente.getSexo();
					if (sexo.equals("F")) {
						RadioButton.setSelected(true);
					} else {
						if (sexo.equals("M")) {
							jRadioButton1.setSelected(true);
						}
					}
				}

				buttonGroupSexo = new ButtonGroup();
				buttonGroupSexo.add(jRadioButton1);
				buttonGroupSexo.add(RadioButton);
				{
					btSalvar = new JButton();
					jPanel1.add(btSalvar);
					btSalvar.setText("Salvar");
					btSalvar.setBounds(175, 262, 94, 23);
					btSalvar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/Salvaar.png")));
					btSalvar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent evento) {

							String sexo = null;
							if (RadioButton.isSelected()) {
								sexo = "F";
							} else {
								if (jRadioButton1.isSelected()) {
									sexo = "M";
								}
							}

							if (!tfNome.getText().equals("")) {
								cliente.setCodigo(Long.parseLong(tfCodigo
										.getText()));
								cliente.setNome(tfNome.getText());
								cliente.setSexo(sexo);
								cliente.setTelefone(Integer.parseInt(tfTelefone
										.getText()));
								cliente.setCpf(Integer.parseInt(tfCPF.getText()));
								cliente.setEmail(tfEmail.getText());
								cliente.setBairro(tfBairro.getText());
								cliente.setRua(tfRua.getText());
								cliente.setNumero(Integer.parseInt(tfNum
										.getText()));
								cliente.setComplemento(tfComplemento.getText());
								Cidade str = new Cidade();
								str = (Cidade) ComboBoxCidade.getSelectedItem();
								cliente.setCidade(str);
								try {
									System.out.println(cliente.getCodigo());
									dao.altera(cliente);
									JOptionPane.showMessageDialog(null,
											"Alterações feitas!");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}

							} else {
								JOptionPane.showMessageDialog(null,
										"Erro! Campo não preenchido", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}

							/*
							 * if (!tfNome.getText().equals("")) {
							 * cidade.setNome(tfNome.getText()); String str =
							 * String.valueOf(tfUF.getSelectedItem());
							 * cidade.setEstado(str);
							 * 
							 * String str =
							 * String.valueOf(ComboBoxCidade.getSelectedItem());
							 * cliente.setCidade(str); try {
							 * System.out.println(cidade.getCodigo());
							 * dao.altera(cidade);
							 * JOptionPane.showMessageDialog(null,
							 * "Cidade alterada com sucesso!"); } catch
							 * (SQLException e1) { e1.printStackTrace(); }
							 * 
							 * } else { JOptionPane.showMessageDialog(null,
							 * "Erro! Campo não preenchido", "Erro",
							 * JOptionPane.ERROR_MESSAGE); }
							 */
							dispose();
						}

					});
				}
				{
					lbcliente = new JLabel();
					jPanel1.add(lbcliente);
					lbcliente.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/user_edit.png")));
					lbcliente.setBounds(71, 11, 37, 32);
				}

			}
			pack();
			this.setSize(409, 335);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
