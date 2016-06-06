/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Abonnement;

/**
 *
 * @author Goth
 */
public class DaoAbonnement {
    
    private final Connection cnx;
    
     public DaoAbonnement(Connection cnx) {
        this.cnx = cnx;
    }
        public void lireAbonnement(List<Abonnement>LesAbonnements)throws SQLException {
        String requete = "select * from ABONNEMENT";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while(rset.next()){
            int numAbonnement = Integer.parseInt(rset.getString(1));
            String intituleAbonnement = rset.getString(2);
            String dureeAbonnement = rset.getString(3);
            String dateDebutAbonnement = rset.getString(4);
            String dateFinAbonnement = rset.getString(5);
            Boolean validationAbonnement = rset.getBoolean(6);
            int numAdherent = Integer.parseInt(rset.getString(7));

            Abonnement temp = new Abonnement(numAbonnement,intituleAbonnement,dureeAbonnement,dateDebutAbonnement,dateFinAbonnement,validationAbonnement,numAdherent);
            
            LesAbonnements.add(temp);
            
        }
        rset.close();  
    }
        
        public Abonnement validiteAbonnement(Abonnement metierAbo,int numAdh)throws SQLException{
        String requete = "select numeroabonnement from abonnement where numadherent = "+numAdh;
        Abonnement abo;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        
              int numAbonnement = Integer.parseInt(rset.getString(1));
            String intituleAbonnement = rset.getString(2);
            String dureeAbonnement = rset.getString(3);
            String dateDebutAbonnement = rset.getString(4);
            String dateFinAbonnement = rset.getString(5);
            Boolean validationAbonnement = rset.getBoolean(6);
            int numAdherent = Integer.parseInt(rset.getString(7));
            
            abo = new Abonnement (numAbonnement,intituleAbonnement,dureeAbonnement,dateDebutAbonnement,
                    dateFinAbonnement,validationAbonnement,numAdherent);
            rset.close(); 
            
            
            return abo;
            
}
}
