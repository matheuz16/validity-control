package Telas;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;


public class Sobre extends javax.swing.JFrame 
{

    
    public Sobre() 
    {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/imagens/equipe2.png")));
        initComponents();
    }

    
    private void initComponents() 
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setForeground(java.awt.Color.lightGray);
        setLocationRelativeTo(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); 
        jLabel1.setText("Desenvolvido por: Matheus Gomes");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel5.setText("Versao: 1.0");

        jLabel6.setIcon(new ImageIcon(Sobre.class.getResource("/imagens/Equipe.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel5)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(46)
        					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(34)
        					.addComponent(jLabel1)))
        			.addGap(37)
        			.addComponent(jLabel5)
        			.addGap(30))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    

}
