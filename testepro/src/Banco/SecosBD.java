package Banco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dados.Secos;

public class SecosBD
{

    Connection connection = null;

    public boolean inserirSecos(Secos secos) 
    {
    	boolean status = true;
    	
        System.out.println("Inserir Produtos Secos");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO secos (descricao,marca,quantidade,validade) "
               + "VALUES('"+secos.getDescricao()+"','"+secos.getMarca()+"',"
               + " "+secos.getQuantidade()+",'"+secos.getValidade()+"');";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            status = true;
            
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            status = false;
        }
        finally
        {
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
                status = false;
            }
        }
        
        return status;
    } 

    public boolean atualizarAluno(Secos secos) 
    {
        System.out.println("Atualizar Produto");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE aluno SET nomealuno = '" + secos.getDescricao() + "' WHERE codaluno = " + secos.getCodigo() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        finally
        {
            try 
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    } 

    
    public void relatorioSecos(Secos secos, DefaultTableModel modelo)      
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclus�o");
       Statement stmt = null;
         
  	        
  	   try
  	   {  		    
  		   stmt = connection.createStatement();
           ResultSet res = stmt.executeQuery("SELECT * FROM secos ORDER BY codigo");
         
  		   while(res.next())
  		   {
  			   secos.setCodigo(res.getInt("codigo"));
  			   secos.setDescricao(res.getString("descricao"));	
  			   secos.setMarca(res.getString("marca"));
			   secos.setQuantidade(res.getInt("quantidade"));
			   secos.setValidade(res.getString("validade"));
			   
  			   modelo.addRow(new Object[] {secos.getCodigo(), secos.getDescricao(),
  					   secos.getMarca(),secos.getQuantidade(),
  					   secos.getValidade()});		    
	   
  		   }
  	   }
  	   catch(SQLException ex)
  	   {
  		   System.out.println("Erro SQL: " + ex.getMessage());
  	   }
  	   finally 
       {
         try
         {
             stmt.close();
             connection.close();
         }
         catch (SQLException e)
         {
             System.out.println("Erro ao desconectar" + e.getMessage());
         }
     }
  	
    	
    }
    
    
    
    public boolean excluirAluno(Secos secos)
    {
        System.out.println("Excluir produto");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado!! Preparando a exclus�o");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();

            String sql = "DELETE FROM aluno WHERE codaluno = " + secos.getCodigo() + ";";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
            return true;
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        finally 
        {
            try
            {
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
}