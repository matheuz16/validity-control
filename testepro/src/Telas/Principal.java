package Telas;

import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.*;
import javax.swing.*;

import Telas.CadastroFrioP;
import Telas.CadastroFrioN;
import Telas.CadastroSecos;
import Telas.RelatorioFrioN;


import javax.swing.table.DefaultTableModel; 

import java.awt.Toolkit;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Principal extends javax.swing.JFrame 
{

    private Sobre sobre;
    private CadastroFrioP cadastroFrioP;
    private CadastroFrioN cadastroFrioN;
    private CadastroSecos cadastroSecos;
    
    
    
    public Principal() 
    {
    
    sobre = new Sobre();
    cadastroFrioP = new CadastroFrioP();
    cadastroFrioN = new CadastroFrioN();
    	cadastroSecos = new CadastroSecos();
    	
        setLocationRelativeTo(null);
        setBounds(330, 100, 650, 342);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/logo3.png")));
        initComponents();
       jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoprincipal.png")));
                
    }
    

   private void initComponents() 
   {
        
        jLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        relatoriosMenu = new javax.swing.JMenu();
        rel_friopMenuItem = new javax.swing.JMenuItem();
              
        cadastrosMenu = new javax.swing.JMenu();
        cad_friopMenuItem = new javax.swing.JMenuItem();

        retirada_MenuItem = new javax.swing.JMenuItem();
        pesquisaMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        sobreMenuItem = new javax.swing.JMenuItem();
        
        sairMenu = new javax.swing.JMenu();
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validity Control");
        setResizable(false);
       
               
        cadastrosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/contact-new.png"))); 
        cadastrosMenu.setText("Cadastros");
        
        
        cad_friopMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/icone frio2.png"))); 
        cad_friopMenuItem.setText("Frio Positivo");
        cad_friopMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cad_cientesMenuItemMousePressed(evt);
            }
        });
        cadastrosMenu.add(cad_friopMenuItem);



       jMenuBar1.add(cadastrosMenu);
       
       mntmNewMenuItem_2 = new JMenuItem("Frio negativo");
       mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
       	public void mousePressed(MouseEvent e) 
       	{
       		cadastroFrioN.setVisible(true);       		
       	}
       });
       mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/imagens/icone frio3.png")));
       cadastrosMenu.add(mntmNewMenuItem_2);
       
       cad_fornecedoresMenuItem_1 = new JMenuItem();
       cad_fornecedoresMenuItem_1.addMouseListener(new MouseAdapter() {
       	
       	public void mousePressed(MouseEvent e)
       	{
       		cadastroSecos.setVisible(true);
       	}
       });
       cad_fornecedoresMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/imagens/icone secos.png")));
       cad_fornecedoresMenuItem_1.setText("Secos");
       cadastrosMenu.add(cad_fornecedoresMenuItem_1);
       
       

       
        

        retirada_MenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/outbox.png"))); // NOI18N
        retirada_MenuItem.setText("Vendas");
        retirada_MenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                retirada_MenuItemMousePressed(evt);
            }
        });
               
        relatoriosMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/x-office-spreadsheet.png"))); // NOI18N
        relatoriosMenu.setText("Relatórios");

        rel_friopMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/icone frio2.png")));
        rel_friopMenuItem.setText("Frio Positivo");
        rel_friopMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rel_friopMenuItemMousePressed(evt);
            }
        });
        relatoriosMenu.add(rel_friopMenuItem);
      
        jMenuBar1.add(relatoriosMenu);
        
        mntmNewMenuItem = new JMenuItem("Secos");
        mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/imagens/icone secos.png")));
        mntmNewMenuItem.addMouseListener(new MouseAdapter() {
        	public void mousePressed(MouseEvent e) 
        	{
        		rel_SecosMenuItemMousePressed(e);
        		
        	}
        });
        
        mntmNewMenuItem_3 = new JMenuItem("Frio Negativo");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
        	public void mousePressed(MouseEvent e) 
        	{
        		rel_frionMenuItemMousePressed(e);
        	}
        });
        mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/imagens/icone frio3.png")));
        mntmNewMenuItem_3.setSelectedIcon(new ImageIcon(Principal.class.getResource("/imagens/Fornecedores.png")));
        relatoriosMenu.add(mntmNewMenuItem_3);
        relatoriosMenu.add(mntmNewMenuItem);
        
        
        
        
        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/help-browser.png"))); // NOI18N
        helpMenu.setText("Help");
       

        sobreMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("../imagens/info.png"))); // NOI18N
        sobreMenuItem.setText("Sobre");
        sobreMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sobreMenuItemMousePressed(evt);
            }
        });
        helpMenu.add(sobreMenuItem);
        
        jMenuBar1.add(helpMenu);
        
        
        sairMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sair.png"))); 
        sairMenu.setText("Sair");
        sairMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sairMenuMousePressed(evt);
            }
        });
        jMenuBar1.add(sairMenu);
        
        

        setJMenuBar(jMenuBar1);
       
             

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void sobreMenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
        
        sobre.setVisible(true);
        sobre.setLocationRelativeTo(null);
    }

   

    private void cad_cientesMenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
        cadastroFrioP.setVisible(true);
    }



    private void pesquisaMenuMousePressed(java.awt.event.MouseEvent evt) 
    {
        //pesquisa.setVisible(true);
        //pesquisa.setLocationRelativeTo(null);
    }

    private void rel_friopMenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
        new RelatorioFrioP();
        
    }
    
    private void rel_frionMenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
        new RelatorioFrioN();
        
    }
    
    private void rel_SecosMenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
         new RelatorioSecos();
            
    }
    
   
    

    private void retirada_MenuItemMousePressed(java.awt.event.MouseEvent evt) 
    {
       // retirada.setVisible(true);
        //retirada.setLocationRelativeTo(null);
    }

    private void sairMenuMousePressed(java.awt.event.MouseEvent evt) 
    {
        dispose();
    }
    
       
    private javax.swing.JMenuItem cad_friopMenuItem;

    private javax.swing.JMenu cadastrosMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu pesquisaMenu;
    private javax.swing.JMenuItem rel_friopMenuItem;
  
    
    private javax.swing.JMenu relatoriosMenu;
    private javax.swing.JMenuItem retirada_MenuItem;
    private javax.swing.JMenuItem sobreMenuItem;
    
    private javax.swing.JMenu sairMenu;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem cad_fornecedoresMenuItem_1;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
    private JMenuItem mntmNewMenuItem_3;
    private JMenuItem mntmNewMenuItem_4;
    
    

}
