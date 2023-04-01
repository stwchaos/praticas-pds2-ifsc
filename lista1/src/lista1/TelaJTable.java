package lista1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JButton;

public class TelaJTable extends JFrame {

	private Connection conexao;
	private JPanel contentPane;
	private JTable listaPessoas;
	private DefaultTableModel modelo;
	
	private final String DATABASE = "produtos";;
	String user = "root";
	String pwd = "aluno";
	private JButton btnNewButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJTable frame = new TelaJTable();
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
	public TelaJTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][579px][grow]", "[grow][331px][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 1,grow");
		
		listaPessoas = new JTable(modelo);
		scrollPane.setViewportView(listaPessoas);
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Produto", "Preço", "Cidade" });
		listaPessoas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"produto", "preco, cidade"
				}
			));
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String query = "SELECT preco, produto FROM produtos;";
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				modelo.addRow(new Object[] { rs.getLong("preco"), rs.getString("produto"), rs.getString("cidade")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		listaPessoas.setModel(modelo);
		
		btnNewButton = new JButton("Voltar");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					Tela telaPadrao = new Tela();
					telaPadrao.setLocationRelativeTo(null);
					telaPadrao.setVisible(true);
			}
		});
		contentPane.add(btnNewButton, "cell 0 2,alignx left,aligny bottom");
	}
}