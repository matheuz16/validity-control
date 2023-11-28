package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;


import Dados.Secos;
import Banco.SecosBD;
import java.awt.Toolkit;


public class RelatorioSecos extends JFrame
{
   private DefaultTableModel modelo;
   private JTable tabela;
  
   
   private  Secos secos;
   private SecosBD secosBD;
   
   
   public RelatorioSecos()
   {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioSecos.class.getResource("/imagens/Remedio.png")));
	   secos = new Secos();
	   secosBD = new SecosBD();
           setResizable(false);
	   
	   
	   modelo = new DefaultTableModel();
	   tabela = new JTable(modelo);
	   
	   modelo.addColumn("Código");
	   modelo.addColumn("Descrição");
	   modelo.addColumn("Marca");
	   modelo.addColumn("Quantidade");
	   modelo.addColumn("Validade");
	  	   
	   secosBD.relatorioSecos(secos, modelo);
	  
	   
	   tabela.setPreferredScrollableViewportSize(new Dimension(700,200));
	   Container c = getContentPane();
	   c.setLayout(new FlowLayout());
	   JScrollPane scarollPane = new JScrollPane(tabela);
	   c.add(scarollPane);
	   setSize(800,300);
           setLocationRelativeTo(null);
	   setTitle("Relatório de Medicamentos");
	   setVisible(true);
	   
   }
       
}