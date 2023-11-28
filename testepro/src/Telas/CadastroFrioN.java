package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Dados.FrioN;
import Banco.FrioNBD;

public class CadastroFrioN extends JFrame {

    private JLabel contentPane;
    private JTextField campoDescricao; // Alteração aqui
    private JTextField campoMarca; // Alteração aqui
    private JTextField campoQuantidade; // Alteração aqui
    private JTextField campoValidade; // Alteração aqui

    private FrioN frion; // Alteração aqui
    private FrioNBD frionBD; // Alteração aqui

    public CadastroFrioN() {

        frion = new FrioN();
		frionBD = new FrioNBD();
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroFrioN.class.getResource("/imagens/icone frio3.png")));
		setTitle("Cadastro de produto frio negativo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(355, 150, 595, 390);
                setLocationRelativeTo(null);
		contentPane = new JLabel();
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descrição");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 20, 250, 14);
		contentPane.add(lblNewLabel);
		
		campoDescricao = new JTextField();
		campoDescricao.setBounds(31, 40, 300, 20);
		contentPane.add(campoDescricao);
		campoDescricao.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMarca.setBounds(31, 80, 250, 14);
		contentPane.add(lblMarca);
		
		campoMarca = new JTextField();
		campoMarca.setColumns(10);
		campoMarca.setBounds(31, 100, 300, 20);
		contentPane.add(campoMarca);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(31, 140, 97, 14);
		contentPane.add(lblQuantidade);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setColumns(10);
		campoQuantidade.setBounds(31, 160, 97, 20);
		contentPane.add(campoQuantidade);
		
		
		try {
			
			JLabel lblValidade = new JLabel("Data de Validade");
			lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblValidade.setBounds(31, 200, 250, 14);
			contentPane.add(lblValidade);
			
			
			MaskFormatter mascaraValidade = new MaskFormatter("##/##/####");
			JFormattedTextField campoValidade = new JFormattedTextField(mascaraValidade);
			campoValidade.setBounds(31, 220, 136, 20);
			contentPane.add(campoValidade);
			
						
			JButton btnConfirma = new JButton("Confirma");
			btnConfirma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					frion.setDescricao(campoDescricao.getText());								
					frion.setMarca(campoMarca.getText());								
					frion.setQuantidade(Integer.parseInt(campoQuantidade.getText()));																
					frion.setValidade(campoValidade.getText());	
					
					if(frionBD.inserirFrioN(frion))
					{
						JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!!","Sucesso!!!",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Cadastro não realizado!!!","Erro",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			});
			btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnConfirma.setBounds(31, 280, 117, 23);
			contentPane.add(btnConfirma);
			
			JButton btnLimpa = new JButton("Limpar");
			btnLimpa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					campoDescricao.setText("");
					campoMarca.setText("");
					campoQuantidade.setText("");
					campoValidade.setText("");
				}
			});
			btnLimpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLimpa.setBounds(232, 280, 117, 23);
			contentPane.add(btnLimpa);
			
			JButton btnFechar = new JButton("Fechar");
			btnFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnFechar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFechar.setBounds(441, 280, 117, 23);
			contentPane.add(btnFechar);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
                contentPane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo cadastros.png")));
                
		
	}
	
	
}

