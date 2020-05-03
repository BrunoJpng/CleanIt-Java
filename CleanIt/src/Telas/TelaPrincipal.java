package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cleanit.CleanItFacade;
import Cleanit.Data;
import Cleanit.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	CleanItFacade fachada = new CleanItFacade();
	Usuario usuario = Usuario.getInstancia();
	Data data = new Data();
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
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
		
		JButton btnLimparCelular = new JButton("Limpar Celular");
		btnLimparCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fachada.LimpaCelular();
				JOptionPane.showMessageDialog(null, "Limpeza realizada em "+ data.getData());
			}
		});
		btnLimparCelular.setBounds(94, 93, 246, 63);
		frame.getContentPane().add(btnLimparCelular);
		
		JButton btnNewButton = new JButton("Histórico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, fachada.verHistorico());
			}
		});
		btnNewButton.setBounds(94, 193, 246, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Celular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, fachada.EstadoCelular());
			}
		});
		btnNewButton_1.setBounds(94, 286, 246, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Próxima Limpeza");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, fachada.ProximaLimpeza());
			}
		});
		btnNewButton_2.setBounds(94, 379, 246, 63);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnDeletarConta = new JButton("Deletar Conta");
		btnDeletarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean a = usuario.ExcluirUsuario(usuario.getEmail());
				if(a == true) {
					TelaLogin tl = new TelaLogin();
					tl.frame.setVisible(true);
				}
				
			}
		});
		btnDeletarConta.setBounds(94, 470, 246, 63);
		frame.getContentPane().add(btnDeletarConta);
	}

}
