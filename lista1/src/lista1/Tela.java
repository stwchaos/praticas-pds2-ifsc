package lista1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtUsuario;

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
		panel.setLayout(new MigLayout("", "[grow][318px,grow][grow]", "[200px][grow][][][][][][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Ellie Williams ");
		panel.add(lblNewLabel, "cell 1 0,alignx left,aligny top");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(Tela.class.getResource("/lista1/ellieIcon (2).png")));
		
		JLabel lblNewLabel_1 = new JLabel("Confirme seu login");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		panel.add(lblNewLabel_1, "cell 1 2,alignx center,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("usuario");
		lblNewLabel_3.setIcon(new ImageIcon(Tela.class.getResource("/lista1/user_icon.png")));
		panel.add(lblNewLabel_3, "cell 1 3");
		
		txtUsuario = new JTextField();
		panel.add(txtUsuario, "cell 1 4,grow");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("senha");
		lblNewLabel_2.setIcon(new ImageIcon(Tela.class.getResource("/lista1/lock_icon.png")));
		panel.add(lblNewLabel_2, "cell 1 5");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 1 6,grow");
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		panel.add(btnNewButton, "cell 1 8,alignx center,aligny bottom");
	}
}
