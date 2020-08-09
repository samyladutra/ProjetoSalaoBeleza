package br.com.salao.view.Marca;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.salao.bo.MarcaBo;
import br.com.salao.vo.MarcaVo;

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
public class Marca_Inserir extends javax.swing.JFrame {
	private JPanel Panel;
	private JLabel lbMarca;
	private JTextField tfNome;
	private JButton btSair;
	private JButton btCancelar;
	private JButton btSalvar;
	private JLabel lbNome;
	private JTextField tfCodigo;
	private JLabel lbCodigo;
	private MarcaBo mBo;
	private MarcaVo mVo;
	private int contAltera;

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
				Marca_Inserir inst = new Marca_Inserir();
				inst.setVisible(true);
				inst.setLocationRelativeTo(null);
			}
		});
	}

	public Marca_Inserir() {
		super();
		initGUI();
	}

	public Marca_Inserir(MarcaVo marca) {
		mVo = new MarcaVo();
		mVo = marca;
		tfNome.setText(mVo.getNmMarca());
		tfCodigo.setText(String.valueOf(mVo.getCdMarca()));
		// sinal de que a tela foi iniciada para uma alteração.
		contAltera++;
	}

	private void initGUI() {
		try {
			{
				Panel = new JPanel();
				getContentPane().add(Panel, BorderLayout.CENTER);
				Panel.setLayout(null);
				{
					lbMarca = new JLabel();
					Panel.add(lbMarca);
					lbMarca.setText("Inserir Marca");
					lbMarca.setBounds(36, 21, 208, 48);
					lbMarca.setFont(new java.awt.Font("Lucida Sans", 0, 24));
					lbMarca.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/inbox_table.png")));
				}
				{
					lbCodigo = new JLabel();
					Panel.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(10, 80, 33, 14);
				}
				{
					tfCodigo = new JTextField();
					Panel.add(tfCodigo);
					tfCodigo.setBounds(10, 94, 58, 20);
					tfCodigo.setEditable(false);
					mBo = new MarcaBo();
					long cd = mBo.ProximoId();
					tfCodigo.setText(String.valueOf(cd));
				}
				{
					lbNome = new JLabel();
					Panel.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(82, 80, 27, 14);
				}
				{
					tfNome = new JTextField();
					Panel.add(tfNome);
					tfNome.setBounds(82, 94, 188, 20);
				}
				{
					btSalvar = new JButton();
					Panel.add(btSalvar);
					btSalvar.setText("Salvar");
					btSalvar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/Salvaar.png")));
					btSalvar.setBounds(10, 134, 83, 24);
					btSalvar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							if (contAltera == 0) {
								mVo = new MarcaVo();
								mVo.setNmMarca(tfNome.getText());
								mVo.setCdMarca(Integer.parseInt(tfCodigo
										.getText()));
								try {
									mBo = new MarcaBo();
									mBo.incluir(mVo);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,
										"Marca Inserida!");
								try {
									tfCodigo.setText(String.valueOf(mBo
											.ProximoId()));
								} catch (SQLException e) {
									e.printStackTrace();
								}
								tfNome.setText("");

							} else {
								mBo = new MarcaBo();
								try {
									mBo.alterar(mVo);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,
										"Alterações feitas!");
							}
						}
					});
				}
				{
					btCancelar = new JButton();
					Panel.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/retiraar.png")));
					btCancelar.setBounds(99, 134, 95, 24);
					btCancelar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							tfNome.setText("");

						}
					});
				}
				{
					btSair = new JButton();
					Panel.add(btSair);
					btSair.setText("Sair");
					btSair.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/door_out.png")));
					btSair.setBounds(200, 134, 70, 24);
					btSair.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();

						}
					});
				}
			}
			this.setSize(300, 215);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
