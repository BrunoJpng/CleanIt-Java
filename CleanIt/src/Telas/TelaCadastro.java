package Telas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Cleanit.Usuario;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro {

	JFrame frame;
	private JTextField textNome;
	private JTextField textEmail;
	private JPasswordField textSenha;
	private JPasswordField textConfirmaSenha;
	private Usuario usuario = Usuario.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(80, 100, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(80, 125, 275, 40);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(80, 170, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(80, 195, 275, 40);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(80, 246, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(80, 316, 152, 14);
		frame.getContentPane().add(lblConfirmarSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome, email, senha, confirmasenha;
				nome = textNome.getText();
				email = textEmail.getText();
				senha = new String(textSenha.getPassword());
				confirmasenha = new String(textConfirmaSenha.getPassword());
				if(senha.equals(confirmasenha)) {
					
					usuario.CadastrarUsuario(nome,email,senha);
					JOptionPane.showMessageDialog(null, textNome.getText()+" cadastrado!");
					
					usuario.Login(email,senha);
					TelaPrincipal tp = new TelaPrincipal();
					tp.frame.setVisible(true);
					frame.setVisible(false);
				}	
				else {
					JOptionPane.showMessageDialog(null, "Dados Inválidos!");
				}
			}
		});
		btnCadastrar.setBounds(119, 445, 190, 47);
		frame.getContentPane().add(btnCadastrar);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(80, 271, 275, 40);
		frame.getContentPane().add(textSenha);
		
		textConfirmaSenha = new JPasswordField();
		textConfirmaSenha.setBounds(80, 341, 275, 40);
		frame.getContentPane().add(textConfirmaSenha);
	}

}
