package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;



import Banco.AcessoBD;
import Dados.Login; 
import java.awt.Toolkit;

public class TelaLogin extends JFrame {

	private JLabel contentPane;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
        private javax.swing.JLabel jLabel2;
	
        private Principal principal;

	

	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagens/logo3.png")));
		
		principal = new Principal();
                
                setResizable(false);
                setTitle("Bem vindo ao Validy Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(355, 150, 650, 342);
                setLocationRelativeTo(null);
		contentPane = new JLabel();
		contentPane.setBorder(new EmptyBorder(20, -275, 70, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome;
				String senha;
				
				AcessoBD acesso = new AcessoBD();
				Login login = new Login();
				
				nome = campoLogin.getText();
				senha = campoSenha.getText();
				
				login.setNome(nome);
				login.setSenha(senha);
				
				if(acesso.verificaAcesso(login) == true)
				{
					principal.setVisible(true);
                                        dispose();
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Erro nos dados informados", "Erro", JOptionPane.ERROR_MESSAGE);
				}
								
			}
		});
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConfirma.setBounds(55, 231, 123, 23);
		contentPane.add(btnConfirma);
		
		JButton btnCancela = new JButton("Cancela");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnCancela.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancela.setBounds(242, 231, 123, 23);
		contentPane.add(btnCancela);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(55, 30, 176, 25);
		contentPane.add(lblNewLabel);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(55, 66, 259, 20);
		contentPane.add(campoLogin);
		campoLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(55, 113, 176, 25);
		contentPane.add(lblSenha);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(55, 163, 259, 20);
		contentPane.add(campoSenha);
                contentPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo login.png")));
                
                
                
                
                
	}
}
