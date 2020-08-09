package br.com.salao.view.Cidade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import br.com.salao.dao.CidadeDAO;
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
public class Alterar_Cidade extends javax.swing.JDialog {
	private JPanel jPanel1;
	private JLabel lbicone;
	private JTextField tfNome;
	private JButton btSalvar;
	private JButton btCancelar;
	private JLabel lbUF;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbcodigo;
	private JLabel lbAlterarCid;

	private Cidade cidade;
	private CidadeDAO dao;

	private JComboBox tfUF;

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
	public Alterar_Cidade(Cidade cidade, Connection conexao) {
		super();
		this.cidade = cidade;
		try {
			dao = new CidadeDAO(conexao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setModal(true);
			this.setTitle("Alterar Cidade");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					lbicone = new JLabel();
					jPanel1.add(lbicone);
					lbicone.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/building_edit.png")));
					lbicone.setBounds(47, 26, 32, 32);
				}
				{
					lbAlterarCid = new JLabel();
					jPanel1.add(lbAlterarCid);
					lbAlterarCid.setText("Alterar Cidade");
					lbAlterarCid.setBounds(89, 16, 228, 56);
					lbAlterarCid
							.setFont(new java.awt.Font("Lucida Sans", 0, 24));
				}
				{
					lbcodigo = new JLabel();
					jPanel1.add(lbcodigo);
					lbcodigo.setText("Código");
					lbcodigo.setBounds(22, 83, 33, 14);
				}
				{
					tfCodigo = new JTextField();
					jPanel1.add(tfCodigo);
					tfCodigo.setEnabled(false);
					tfCodigo.setBounds(22, 97, 38, 22);
					long x = cidade.getCodigo();
					String aux = "" + x;
					tfCodigo.setText(aux);
				}
				{
					lbNome = new JLabel();
					jPanel1.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(70, 85, 27, 14);
				}
				{
					tfNome = new JTextField();
					jPanel1.add(tfNome);
					tfNome.setBounds(70, 98, 170, 20);
					tfNome.setText(cidade.getNome());
				}
				{
					lbUF = new JLabel();
					jPanel1.add(lbUF);
					lbUF.setText("UF");
					lbUF.setBounds(252, 83, 13, 14);
				}
				{
					btCancelar = new JButton();
					jPanel1.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setBounds(205, 188, 104, 23);
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/retiraar.png")));
					btCancelar.setSize(104, 24);
					btCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
				}
				{
					btSalvar = new JButton();
					jPanel1.add(btSalvar);
					btSalvar.setText("Salvar");
					btSalvar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/Salvaar.png")));
					btSalvar.setBounds(115, 188, 83, 25);
					btSalvar.setSize(83, 24);
					btSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (!tfNome.getText().equals("")) {
								cidade.setNome(tfNome.getText());
								String str = String.valueOf(tfUF.getSelectedItem());
								cidade.setEstado(str);
								try {
									System.out.println(cidade.getCodigo());
									dao.altera(cidade);
									JOptionPane.showMessageDialog(null,
											"Cidade alterada com sucesso!");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}

							} else {
								JOptionPane.showMessageDialog(null,
										"Erro! Campo não preenchido", "Erro",
										JOptionPane.ERROR_MESSAGE);
							}
							dispose();
						}
					});
				}
				{
					tfUF = new JComboBox(new String[] { "AC", "AP", "AL", "AM",
							"BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS",
							"MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN",
							"RO", "RR", "RS", "SC", "SE", "SP", "TO" });
					jPanel1.add(tfUF);
					tfUF.setBounds(252, 97, 45, 22);
					tfUF.setSelectedItem(cidade.getEstado());
				}
			}
			pack();
			this.setSize(336, 262);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
}
