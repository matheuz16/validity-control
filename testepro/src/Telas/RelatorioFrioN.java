package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;


import Dados.FrioN;
import Banco.FrioNBD;
import java.awt.Toolkit;


public class RelatorioFrioN extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
   
   
   private FrioN frion;
   private FrioNBD frionBD;
   
   
   public RelatorioFrioN()
   {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioFrioN.class.getResource("/imagens/icone frio3.png")));
	   frion = new FrioN();
	   frionBD = new FrioNBD();
           setResizable(false);
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Código");
	   modelo.addColumn("Descricao");
	   modelo.addColumn("Marca");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Validade");
	   
	   
	   
	   frionBD.relatorioFrioN(frion, modelo);
	  
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,200));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,300);
           setLocationRelativeTo(null);
	   setTitle("Relatório dos Produtos de frio negativo");
	   setVisible(true);
           
	   
   }
       
}