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

import Dados.FrioN;

public class FrioNBD
{

    Connection connection = null;

    public boolean inserirFrioN(FrioN frion) 
    {
    	boolean status = true;
    	
        System.out.println("Inserir produto");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO frion (descricao, marca, quantidade, validade) "
               + "VALUES('"+frion.getDescricao()+"','"+frion.getMarca()+"',"
               + " "+frion.getQuantidade()+",'"+frion.getValidade()+"');";
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

    public boolean atualizarAluno(FrioN frion) 
    {
        System.out.println("Atualizar frio negativo");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE aluno SET nomealuno = '" + frion.getDescricao() + "' WHERE codaluno = " + frion.getCodigo() + ";";
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

    
    public void relatorioFrioN(FrioN frion, DefaultTableModel modelo)      
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclus�o");
       Statement stmt = null;
         
  	        
  	   try
  	   {  		    
  		   stmt = connection.createStatement();
           ResultSet res = stmt.executeQuery("SELECT * FROM frion ORDER BY codigo");
         
  		   while(res.next())
  		   {
  			   frion.setCodigo(res.getInt("codigo"));
  			   frion.setDescricao(res.getString("descricao"));	
  			   frion.setMarca(res.getString("marca"));
			   frion.setQuantidade(res.getInt("quantidade"));	
			   frion.setValidade(res.getString("validade"));
  			   
			   
			   
  			   modelo.addRow(new Object[] {frion.getCodigo(), frion.getDescricao(),
  					   frion.getMarca(),frion.getQuantidade(), frion.getValidade()});		    
	   
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
    
    
    
    public boolean excluirAluno(FrioN frion)
    {
        System.out.println("Excluir frion");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado!! Preparando a exclus�o");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();

            String sql = "DELETE FROM frion WHERE codigo = " + frion.getCodigo() + ";";
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
