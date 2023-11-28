package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;


import Dados.FrioP;
import Banco.FrioPBD;
import java.awt.Toolkit;


public class RelatorioFrioP extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   
   
   private FrioP friop;
   private FrioPBD friopBD;
   
   
   public RelatorioFrioP()
   {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioFrioP.class.getResource("/imagens/icone frio2.png")));
	   friop = new FrioP();
	   friopBD = new FrioPBD();
           setResizable(false);
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Código");
	   modelo.addColumn("Descricao");
	   modelo.addColumn("Marca");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Validade");
	   
	   
	   
	   friopBD.relatorioFrioP(friop, modelo);
	  
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,200));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,300);
           setLocationRelativeTo(null);
	   setTitle("Relatório dos Produtos de frio positivo");
	   setVisible(true);
	   
   }
       
}
