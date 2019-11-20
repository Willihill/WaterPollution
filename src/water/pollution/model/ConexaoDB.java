/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package water.pollution.model;

import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

/**
 *
 * @author William Sousa
 */
/**
 *
 * @author William Sousa
 */
public class ConexaoDB {
    private static SQLServerConnection connection;
    
    // Deixa o construtor privado para não ser instanciado
    private ConexaoDB(){}
    
    /**
     * Metodo para criar conexão com o banco de dados
     * 
     * @return 
     */
    public static Boolean OpenConnection()
    {        
        Boolean retorno = true;
        
        try{
            // Caso a conexão já esteja aberta, retorna true
            if(ConexaoDB.connection != null && ConexaoDB.connection.isClosed()){
                //return true;
            }
            
            SQLServerDataSource dd = new SQLServerDataSource();
            dd.setServerName("william-sousa");
            dd.setPortNumber(1433);
            dd.setUser("root");
            dd.setPassword("root");
            dd.setDatabaseName("WaterPollution");
            
            ConexaoDB.connection = (SQLServerConnection) dd.getConnection();
           
            //JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.\n\n" + e.getMessage().trim());
            System.exit(-9);
            retorno = false;
        }
        
        return retorno;
    }
    
    /**
     * Retorna um objeto para preparar e executar uma Select
     * 
     * @param query
     * @return
     * @throws SQLServerException 
     */
    public static PreparedStatement getNewPreparedStatement(String query) throws SQLServerException{
        return ConexaoDB.connection.prepareStatement(query);
    }
    
    /**
     * Executa uma Select e retornar o resultado
     * 
     * @param query = T-SQL do tipo SELECT a ser executada
     * @return Resultado da query.
     */
    public static ResultSet ExecuteSelect(String query) throws SQLException{
        // Abri a conexão
        ConexaoDB.OpenConnection();
        
        ResultSet retorno = null;
              
        
        try {            
            Statement stmt = ConexaoDB.connection.createStatement();
            retorno = stmt.executeQuery(query);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a SELECT.\n\n" + e.getMessage().trim());
        }finally{
            //retorno.close();
        }
        
        return retorno;
    }   
}