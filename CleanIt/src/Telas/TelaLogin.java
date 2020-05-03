package Telas;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Cleanit.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class TelaLogin {

	JFrame frame;
	private JTextField textLogin;
	private JLabel lblSenha;
	private JPasswordField textSenha;
	private JButton btnEntrar;
	private Usuario usuario = Usuario.getInstancia();
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(80, 221, 46, 20);
		frame.getContentPane().add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(80, 246, 275, 40);
		frame.getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(80, 304, 46, 20);
		frame.getContentPane().add(lblSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(79, 329, 276, 40);
		frame.getContentPane().add(textSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (usuario.Login(textLogin.getText(), new String(textSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem-vindo!");
					TelaPrincipal tp = new TelaPrincipal();
					tp.frame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Dados Incorretos!");
				}
			}
		});
		btnEntrar.setBounds(134, 398, 179, 40);
		frame.getContentPane().add(btnEntrar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telacadastro = new TelaCadastro();
				telacadastro.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCadastrar.setBounds(134, 482, 179, 40);
		frame.getContentPane().add(btnCadastrar);
	}
}
