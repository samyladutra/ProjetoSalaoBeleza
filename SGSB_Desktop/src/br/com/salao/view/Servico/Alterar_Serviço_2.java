package br.com.salao.view.Servico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class Alterar_Serviço_2 extends javax.swing.JDialog {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel1;
	private JTextField titulo;
	private JLabel lbPreco;
	private JLabel lbservico;
	private JButton btSlavar;
	private JButton btCancelar;
	private JTextArea TextAreaDescricao;
	private JScrollPane jScrollPane1;
	private JTextField tfNome;
	private JLabel lbNome;
	private JComboBox ComboBoxDuração;
	private JLabel lbDuracao;
	private JTextField tfPreco;
	private JLabel lbCodigo;
	private JTextField tfCodigo;
	private JLabel lbDescricao;

	private ServicoDAO daoServico;
	private ServicoVo servico;

	public Alterar_Serviço_2(ServicoVo servico, Connection conexao)
			throws SQLException {
		super();
		this.servico = servico;
		daoServico = new ServicoDAO(conexao);
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setModal(true);
			this.setTitle("Sistema para Salão de Beleza");
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(413, 47));
				{
					titulo = new JTextField();
					jPanel1.add(titulo);
					titulo.setFont(new java.awt.Font("Lucida Calligraphy", 0,
							22));
					titulo.setText("Alterar de Serviço");
					titulo.setEditable(false);
					titulo.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 0, 0));
					titulo.setBounds(113, 11, 219, 45);
				}
				{
					lbDescricao = new JLabel();
					jPanel1.add(lbDescricao);
					lbDescricao.setText("Descrição");
					lbDescricao.setBounds(21, 172, 161, 16);
				}
				{
					tfCodigo = new JTextField();
					jPanel1.add(tfCodigo);
					tfCodigo.setBounds(20, 79, 58, 23);
					tfCodigo.setEditable(false);
					tfCodigo.setText(String.valueOf(servico.getCodigo()));
				}
				{
					lbCodigo = new JLabel();
					jPanel1.add(lbCodigo);
					lbCodigo.setText("Código");
					lbCodigo.setBounds(20, 64, 58, 16);
				}
				{
					lbPreco = new JLabel();
					jPanel1.add(lbPreco);
					lbPreco.setText("Preço");
					lbPreco.setBounds(142, 115, 62, 16);
				}
				{
					tfPreco = new JTextField();
					jPanel1.add(tfPreco);
					tfPreco.setBounds(142, 131, 96, 23);
					tfPreco.setText(String.valueOf(servico.getPreco()));
				}
				{
					lbDuracao = new JLabel();
					jPanel1.add(lbDuracao);
					lbDuracao.setText("Duração");
					lbDuracao.setBounds(21, 115, 121, 16);
				}
				{
					ComboBoxModel DuraçãoModel = new DefaultComboBoxModel(
							new Integer[] { 10, 15, 20, 30, 50, 60,
									80, 100, 120 });
					ComboBoxDuração = new JComboBox();
					jPanel1.add(ComboBoxDuração);
					ComboBoxDuração.setModel(DuraçãoModel);
					ComboBoxDuração.setBounds(21, 131, 94, 23);
					// System.out.println(servico.getDuracao());
					ComboBoxDuração.setSelectedItem(servico
							.getDuracao());
				}
				{
					lbNome = new JLabel();
					jPanel1.add(lbNome);
					lbNome.setText("Nome");
					lbNome.setBounds(100, 62, 53, 21);
				}
				{
					tfNome = new JTextField();
					jPanel1.add(tfNome);
					tfNome.setBounds(100, 80, 265, 21);
					tfNome.setText(servico.getNome());
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(21, 188, 344, 54);
					TextAreaDescricao = new JTextArea();
					jScrollPane1.setViewportView(TextAreaDescricao);
					TextAreaDescricao.setText(servico.getDescricao());

					
					// barra de rolagem vertical sempre visÃ­vel
					jScrollPane1
							.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					// barra de rolagem horizontal sempre oculta
					jScrollPane1
							.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				}
				{
					btCancelar = new JButton();
					jPanel1.add(btCancelar);
					btCancelar.setText("Cancelar");
					btCancelar.setBounds(266, 256, 102, 23);
					btCancelar.setIcon(new ImageIcon(getClass()
							.getClassLoader()
							.getResource("Icones/Retiraar.png")));
					btCancelar.addActionListener(new ActionListener() {
						
						
						public void actionPerformed(ActionEvent arg0) {
						dispose();
							
						}
					});
				}
				{
					btSlavar = new JButton();
					jPanel1.add(btSlavar);
					btSlavar.setText("Salvar");
					btSlavar.setBounds(166, 256, 90, 23);
					btSlavar.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/Salvaar.png")));
					btSlavar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (!tfNome.getText().equals("")
									&& !tfPreco.getText().equals("")
									&& !TextAreaDescricao.getText().equals("")) {
								servico = new ServicoVo(Integer
										.parseInt((tfCodigo.getText())), tfNome
										.getText(), Integer.valueOf(String
										.valueOf(ComboBoxDuração
												.getSelectedItem())), Double
										.parseDouble(tfPreco.getText()),
										TextAreaDescricao.getText());
								try {

									daoServico.altera(servico);
									JOptionPane.showMessageDialog(null,
											"Serviço alterada com sucesso!");
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
					lbservico = new JLabel();
					jPanel1.add(lbservico);
					lbservico.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("Icones/escova_secador.png")));
					lbservico.setBounds(69, 12, 44, 39);
				}
			}
			pack();
			this.setSize(392, 328);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
