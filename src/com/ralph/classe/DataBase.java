package com.ralph.classe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alphonse
 */
public class DataBase {

    Connection connection;
    Statement statement;
    String requet;
    String url;
    String username;
    String password;

    public DataBase(String url, String username, String password) {

        this.url = url;
        this.username = username;
        this.password = password;

    }

    //------------fonction pour faire connexion base de donne -------------
    public Connection connexionDatabase() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, " Erreur connexion activer le serveur ou verifier "
                    + "\nle configuration de  serveur");

            System.err.println(e.getMessage());
        }

        return connection;

    }

    //-----------pour fermer la connexion----------------
    public Connection closeconnexion() {
        try {
            connection.close();

        } catch (SQLException e) {

            System.err.println(e);
        }
        return connection;

    }

    // methode pour executer la requete select
    public ResultSet executionQuery(String sql) {
        connexionDatabase();
        ResultSet resultSet = null;

        try {

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return resultSet;
    }

    // methode pour executer la requete !select
    public String executionUpdate(String sql) {

        connexionDatabase();
        String result = "";
        try {

            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;

        } catch (SQLException ex) {

            result = ex.toString();
        }
        return result;

    }
    //get nombre d'enregistrement
    
    public ResultSet getNbEnreg(String table) throws Exception {
        connexionDatabase();
        
        String query = "SELECT COUNT(*) AS nbl FROM "+table;
        return this.executionQuery(query);
        
    }
    public ResultSet getAll(String table) throws Exception {
        String query = "SELECT * FROM "+table;
        return this.executionQuery(query);
        
    }
    

//methode requete pour affiche tous
    public ResultSet selectAll(String nomTable) {

        connexionDatabase();
        requet = "SELECT * FROM " + nomTable;
        System.out.println(requet);
        return this.executionQuery(requet);

    }

//methode pour affiche tous avec parametre ("état")
    public ResultSet selectAll(String nomTable, String état) {

        connexionDatabase();
        requet = "SELECT * FROM " + nomTable + " WHERE " + état;
        return this.executionQuery(requet);

    }

//
    public ResultSet querySelect(String[] nomColonne, String nomTable) {

        connexionDatabase();
        int i;
        requet = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            requet += nomColonne[i];
            if (i < nomColonne.length - 1) {
                requet += ",";
            }
        }

        requet += " FROM " + nomTable;
        return this.executionQuery(requet);

    }
    
    
//select avec condition
    public ResultSet sqlSelect(String[] nomColonne, String nomTable) {

        connexionDatabase();
        int i;
        requet = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            requet += nomColonne[i];
            if (i < nomColonne.length - 1) {
                requet += ",";
            }
        }

        requet += " FROM " + nomTable;
        return this.executionQuery(requet);

    }

    public ResultSet jfreeChartBar(){
        connexionDatabase();
         String sql = "SELECT SUM(Total) AS 'montant_par_mois',( CASE WHEN MONTH(Date_Facture)='1' THEN 'Janvier' WHEN MONTH(Date_Facture)='2' THEN 'Fevrier' WHEN MONTH(Date_Facture)='3' THEN 'Mars' WHEN MONTH(Date_Facture)='4' THEN 'Avril' WHEN MONTH(Date_Facture)='5' THEN 'Mai' WHEN MONTH(Date_Facture)='6' THEN 'Juin' WHEN MONTH(Date_Facture)='7' THEN 'Juillet' WHEN MONTH(Date_Facture)='8' THEN 'Aout' WHEN MONTH(Date_Facture)='9' THEN 'Septembre' WHEN MONTH(Date_Facture)='10' THEN 'Octobre' WHEN MONTH(Date_Facture)='11' THEN 'Novembre' WHEN MONTH(Date_Facture)='12' THEN 'Decembre' END) AS 'Mois'FROM test_chart GROUP BY MONTH(Date_Facture) ORDER BY MONTH(Date_Facture) ASC";
        return this.executionQuery(sql);
    }

//select avec condition
    public ResultSet sqlSelect(String[] nomColonne, String nomTable, String etat) {

        connexionDatabase();
        int i;
        requet = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            requet += nomColonne[i];
            if (i < nomColonne.length - 1) {
                requet += ",";
            }
        }

        requet += " FROM " + nomTable + " WHERE " + etat;
        return this.executionQuery(requet);

    }

    // 1er methode pour inserer des données dans la base des données
    public String queryInsert(String nomTable, String data[]) {

        connexionDatabase();
        int i;
        requet = "INSERT INTO " + nomTable + " VALUES(";

        for (i = 0; i < data.length; i++) {
            requet += "'" + data[i] + "'";
            if (i < data.length - 1) {
                requet += ",";
            }
        }
        requet += ")";
        return this.executionUpdate(requet);
    }
    
//2em methode pour inserer des données dans la base des données

    public String queryInsert(String nomTable, String nomColonne[], String data[]) {

        connexionDatabase();
        int i;
        try {
             requet = "INSERT INTO " + nomTable + "(";

        for (i = 0; i < nomColonne.length; i++) {
            requet += nomColonne[i];
            if (i < nomColonne.length - 1) {
                requet += ",";
            }
        }
        requet += ") VALUES(";

        for (i = 0; i < data.length; i++) {
            requet += "'" + data[i] + "'";
            if (i < data.length - 1) {
                requet += ",";
            }
        }

        requet += ")";
        return this.executionUpdate(requet);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec ");
            e.printStackTrace();
            return null;
        }
    }

//
    public String queryUpdate(String nomTable, String[] nomColonne, String[] data, String état) {

        connexionDatabase();
        int i;
        requet = "UPDATE " + nomTable + " SET ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            requet += nomColonne[i] + "='" + data[i] + "'";
            if (i < nomColonne.length - 1) {
                requet += ",";
            }
        }

        requet += " WHERE " + état;
        return this.executionUpdate(requet);

    }

    //methode pour requete suprimmer sans parametre
    public String queryDelete(String nomtable) {

        connexionDatabase();
        requet = "DELETE FROM " + nomtable;
        return this.executionUpdate(requet);

    }

//methode pour requete suprimmer avec condition
    public String queryDelete(String nomTable, String etat) {

        connexionDatabase();
        requet = "DELETE FROM " + nomTable + " WHERE " + etat;
        return this.executionUpdate(requet);

    }
    
}
