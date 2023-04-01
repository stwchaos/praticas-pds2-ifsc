package lista1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Tela extends JFrame {

	private String user = "root", pwd = "aluno", banco = "banco";
	private Connection conexao;
	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtCidade;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][445.00px][grow]", "[grow][500.00px][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[grow][318px,grow][grow]", "[200px][grow][][][][][][][grow][][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Ellie Williams ");
		panel.add(lblNewLabel, "cell 1 0,alignx left,aligny top");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(Tela.class.getResource("/lista1/ellieIcon (2).png")));
		
		JLabel lblNewLabel_1 = new JLabel("Registre um produto na dispensa");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, "cell 1 2,alignx center,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Produto");
		panel.add(lblNewLabel_3, "cell 1 3");
		
		txtProduto = new JTextField();
		panel.add(txtProduto, "cell 1 4,grow");
		txtProduto.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço");
		panel.add(lblNewLabel_2, "cell 1 5");
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+banco+"?serverTimezone=UTC", user, pwd);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String cidade = null, produto = null;
				Double preco = null;
				
				if(!txtCidade.getText().isBlank()) {
					cidade = txtCidade.getText();
				}
				if(!txtProduto.getText().isBlank()) {
					produto = txtProduto.getText();
				}
				if(!txtPreco.getText().isBlank()) {
					preco = Double.valueOf(txtPreco.getText());
				}
								
				try {
					String query = "INSERT INTO produtos (cidade, produto, preco) VALUES (?, ?, ?);";
					PreparedStatement stm = conexao.prepareStatement(query);
					
					stm.setString (1, cidade);
					stm.setString (2, produto);
					stm.setDouble (3, preco);
					stm.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		panel.add(txtPreco, "cell 1 6,growx");
		
		JLabel lblNewLabel_3_1 = new JLabel("Cidade");
		panel.add(lblNewLabel_3_1, "cell 1 7");
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		panel.add(txtCidade, "cell 1 8,growx");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton, "cell 1 10,alignx center,aligny bottom");
		
		JButton btnLista = new JButton("Acessar lista");
		btnLista.setForeground(Color.WHITE);
		btnLista.setBackground(Color.BLACK);
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					TelaJTable telaTabela = new TelaJTable();
					telaTabela.setLocationRelativeTo(null);
					telaTabela.setVisible(true);
			}
		});
		panel.add(btnLista, "cell 1 12,alignx center,aligny center");
		
		
	}
}
