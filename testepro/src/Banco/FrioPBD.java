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

import Dados.FrioP;

public class FrioPBD
{

    Connection connection = null;

    public boolean inserirFrioP(FrioP friop) 
    {
    	boolean status = true;
    	
        System.out.println("Inserir Produto");
        
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para inserir");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "INSERT INTO friop (descricao,marca,quantidade,validade) "
               + "VALUES('"+friop.getDescricao()+"','"+friop.getMarca()+"',"
               + " "+friop.getQuantidade()+",'"+friop.getValidade()+"');";
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

    public boolean atualizarAluno(FrioP friop) 
    {
        System.out.println("Atualizar Produto");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado e pronto para atualizar");
        Statement stmt = null;
    
        try
        {
            stmt = connection.createStatement();

            String sql = "UPDATE aluno SET nomealuno = '" + friop.getDescricao() + "' WHERE codaluno = " + friop.getCodigo() + ";";
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

    
    public void relatorioFrioP(FrioP friop, DefaultTableModel modelo)      
    {
       connection = Conexao.getInstance().getConnection();
       System.out.println("Conectado!! Preparando a exclus�o");
       Statement stmt = null;
         
  	        
  	   try
  	   {  		    
  		   stmt = connection.createStatement();
           ResultSet res = stmt.executeQuery("SELECT * FROM friop ORDER BY codigo");
         
  		   while(res.next())
  		   {
  			   friop.setCodigo(res.getInt("codigo"));
  			   friop.setDescricao(res.getString("descricao"));	
  			   friop.setMarca(res.getString("marca"));
			   friop.setQuantidade(res.getInt("quantidade"));
			   friop.setValidade(res.getString("validade"));
			   
  			   modelo.addRow(new Object[] {friop.getCodigo(), friop.getDescricao(),
  					   friop.getMarca(),friop.getQuantidade(),
  					   friop.getValidade()});		    
	   
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
    
    
    
    public boolean excluirAluno(FrioP friop)
    {
        System.out.println("Excluir produto");
        connection = Conexao.getInstance().getConnection();
        System.out.println("Conectado!! Preparando a exclus�o");
        Statement stmt = null;
        
        try
        {
            stmt = connection.createStatement();

            String sql = "DELETE FROM aluno WHERE codaluno = " + friop.getCodigo() + ";";
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