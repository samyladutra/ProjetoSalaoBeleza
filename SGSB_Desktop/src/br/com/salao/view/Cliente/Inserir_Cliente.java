package br.com.salao.view.Cliente;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import br.com.salao.bo.CidadeBo;
import br.com.salao.bo.ClienteBo;
import br.com.salao.vo.Cidade;
import br.com.salao.vo.Cliente;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.axis.i18n.RB;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

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
public class Inserir_Cliente extends javax.swing.JFrame {
	private JPanel PanelTotal;
	private JTextField tfRua;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbBairro;
	private JButton btSair;
	private JTextField tfNome;
	private JRadioButton radioButtonF;
	private JRadioButton radioButtonM;
	private JLabel lbSexo;
	private JTextField tfEmail;
	private JLabel lbEmail;
	private JTextField tfCPF;
	private JLabel lbCPF;
	private JTextField tfTelefone;
	private JLabel lbTelefone;
	private JTextField tfBairro;
	private JLabel lbCidade;
	private JButton btPesquisaCid;
	private JButton btCancelar;
	private JButton btCadastrar;
	private JTextField tfComplemento;
	private JTextField tfNum;
	private JLabel lbNum;
	private JLabel lbComplemento;
	private JComboBox ComboboxCidade;
	private JLabel lbRua;
	private JLabel lbInserirCliente;
	private Cliente cVo;
	private ClienteBo cBo;
	private CidadeBo cidBo;

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

	public Inserir_Cliente() {
		super();
		initGUI();
	}

	public Inserir_Cliente(Cliente cli) {
		// implementar esse construtor para permitir ação no "Detalhes"
		super();
		cVo.setNome(cli.getNome());
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Inserir Cliente");
			this.setIconImage(new ImageIcon(getClass().getClassLoader()
					.getResource("Icones/user_add.png")).getImage());
			{
				PanelTotal = new JPanel();
				getContentPane().add(PanelTotal, BorderLayout.CENTER);
				PanelTotal.setLayout(null);
				{
					lbInserirCliente = new JLabel();
					PanelTotal.add(lbInserirCliente);
					lbInserirCliente.setText("Inserir Cliente");
					lbInserirCliente.setBounds(113, 21, 227, 49);
					lbInserirCliente
							.setFont(new java.awt.Font("Tahoma", 0, 26));
					lbInserirCliente.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/user_add.png")));
				}
				{
					lbRua = new JLabel();
					PanelTotal.add(lbRua);
					lbRua.setText("Rua");
					lbRua.setBounds(19, 229, 38, 14);
				}
				{
					tfRua = new JTextField();
					PanelTotal.add(tfRua);
					tfRua.setBounds(19, 243, 216, 20);
				}
				{

					ComboboxCidade = new JComboBox();
					cidBo = new CidadeBo();

					List<Cidade> listaCid = cidBo.Lista();
					ComboboxCidade.addItem("");
					for (Cidade c : listaCid) {
						ComboboxCidade.addItem(c);
					}

					AutoCompleteDecorator.decorate(ComboboxCidade);
					PanelTotal.add(ComboboxCidade);

					ComboboxCidade.setBounds(244, 191, 173, 20);
					ComboboxCidade.setEditable(true);
				}
				{
					lbComplemento = new JLabel();
					PanelTotal.add(lbComplemento);
					lbComplemento.setText("Complemento");
					lbComplemento.setBounds(304, 229, 74, 14);
				}
				{
					lbNum = new JLabel();
					PanelTotal.add(lbNum);
					lbNum.setText("Numero");
					lbNum.setBounds(247, 229, 47, 14);
				}
				{
					tfNum = new JTextField();
					PanelTotal.add(tfNum);
					tfNum.setBounds(247, 243, 47, 20);
				}
				{
					tfComplemento = new JTextField();
					PanelTotal.add(tfComplemento);
					tfComplemento.setBounds(304, 243, 145, 20);
				}
				{
					btCadastrar = new JButton();
					PanelTotal.add(btCadastrar);
					btCadastrar.setText("Cadastrar");
					btCadastrar
							.setIcon(new ImageIcon(getClass().getClassLoader()
									.getResource("Icones/Salvaar.png")));
					btCadastrar.setBounds(223, 283, 108, 24);
					btCadastrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {

							String sexo = null;
							if (radioButtonF.isSelected()) {
								sexo = "F";
							} else {
								if (radioButtonM.isSelected()) {
									sexo = "M";
								}
							}

							cVo = new Cliente(
									Long.parseLong(tfCodigo.getText()), tfNome
											.getText(), sexo, Integer
											.parseInt(tfTelefone.getText()),
									Integer.parseInt(tfCPF.getText()), tfEmail
											.getText(), (Cidade) ComboboxCidade
											.getSelectedItem(), tfBairro
											.getText(), tfRua.getText(),
									Integer.parseInt(tfNum.getText()),
									tfComplemento.getText());
							String mensagem;
							mensagem = cBo.VerificaDados(cVo);

							if (mensagem.equals("")) {
								try {
									cBo.incluir(cVo);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,
										"Cliente cadastrado com sucesso!");

								ComboboxCidade.setSelectedItem("");
								try {
									tfCodigo.setText(String.valueOf(cBo
											.ProximoId()));
								} catch (SQLException e) {
									e.printStackTrace();
								}
								tfNome.setText("");
								tfBairro.setText("");
								tfComplemento.setText("");
								tfNum.setText("");
								tfCPF.setText("");
								tfRua.setText("");
								tfTelefone.setText("");
								tfEmail.setText("");

							} else {
								JOptionPane.showMessageDialog(null, mensagem,
										"Erro", JOptionPane.ERROR_MESSAGE);
							}

						}
					});
				}
				{
					btCancelar = new JButton();
					PanelTotal.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/Retiraar.png")));
					btCancelar.setBounds(340, 281, 109, 25);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evento) {
							tfBairro.setText("");
							tfComplemento.setText("");
							tfCPF.setText("");
							tfEmail.setText("");
							tfNome.setText("");
							tfNum.setText("");
							tfRua.setText("");
							tfTelefone.setText("");
							ComboboxCidade.addItem("");
						}
					});
				}
				{
					btPesquisaCid = new JButton();
					PanelTotal.add(btPesquisaCid);
					btPesquisaCid.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource(
									"Icones/building_add16x16.png")));
					btPesquisaCid.setBounds(425, 187, 26, 24);
					btPesquisaCid.addActionListener(new AddCidade());
				}
				{
					lbCidade = new JLabel();
					PanelTotal.add(lbCidade);
					lbCidade.setText("Cidade");
					lbCidade.setBounds(245, 177, 99, 14);
				}
				{
					tfBairro = new JTextField();
					PanelTotal.add(tfBairro);
					tfBairro.setBounds(19, 191, 215, 20);
				}
				{
					lbBairro = new JLabel();
					PanelTotal.add(lbBairro);
					lbBairro.setText("Bairro");
					lbBairro.setBounds(19, 178, 61, 14);
				}
				{
					lbTelefone = new JLabel();
					PanelTotal.add(lbTelefone);
					lbTelefone.setText("Telefone");
					lbTelefone.setBounds(19, 132, 84, 14);
				}
				{
					tfTelefone = new JTextField();
					PanelTotal.add(tfTelefone);
					tfTelefone.setBounds(19, 146, 104, 20);
				}
				{
					lbCPF = new JLabel();
					PanelTotal.add(lbCPF);
					lbCPF.setText("CPF");
					lbCPF.setBounds(138, 132, 29, 14);
				}
				{
					tfCPF = new JTextField();
					PanelTotal.add(tfCPF);
					tfCPF.setBounds(133, 146, 102, 20);
				}
				{
					lbEmail = new JLabel();
					PanelTotal.add(lbEmail);
					lbEmail.setText("Email");
					lbEmail.setBounds(245, 132, 88, 14);
				}
				{
					tfEmail = new JTextField();
					PanelTotal.add(tfEmail);
					tfEmail.setBounds(245, 146, 204, 20);
				}
				{
					lbSexo = new JLabel();
					PanelTotal.add(lbSexo);
					lbSexo.setText("Sexo");
					lbSexo.setBounds(370, 81, 65, 14);
				}
				{
					radioButtonM = new JRadioButton();
					PanelTotal.add(radioButtonM);
					radioButtonM.setText("M");
					radioButtonM.setBounds(416, 94, 33, 23);
				}
				{
					radioButtonF = new JRadioButton();
					PanelTotal.add(radioButtonF);
					radioButtonF.setText("F");
					radioButtonF.setBounds(370, 94, 31, 23);
					radioButtonF.setSelected(true);
				}
				{
					tfNome = new JTextField();
					PanelTotal.add(tfNome);
					tfNome.setBounds(82, 95, 273, 20);
				}
				{
					lbNome = new JLabel();
					PanelTotal.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(82, 81, 73, 14);
				}
				{
					lbCodigo = new JLabel();
					PanelTotal.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(19, 81, 53, 14);
				}
				{
					tfCodigo = new JTextField();
					PanelTotal.add(tfCodigo);
					tfCodigo.setEnabled(false);
					tfCodigo.setBounds(19, 95, 53, 20);
					cBo = new ClienteBo();
					tfCodigo.setText(String.valueOf(cBo.ProximoId()));
				}
				{
					btSair = new JButton();
					PanelTotal.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(19, 282, 83, 23);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
			}
			pack();
			this.setSize(482, 365);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class AddCidade implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Cidade c = new Cidade();
			c = cidBo.ChamaTelaInserir();
			ComboboxCidade.addItem(c);

		}
	}

	public Cliente getCliente() {
		return cVo;
	}

}
