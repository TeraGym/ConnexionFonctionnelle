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
import metier.Adherent;
/**
 *
 * @author P1313115
 */
public class DaoAdherent {

    private final Connection cnx; // injection de dépendance

    public DaoAdherent(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void lireAdherent(List<Adherent>LesAdherents)throws SQLException {
        String requete = "select * from ADHERENT";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while(rset.next()){
            int numAdherent = Integer.parseInt(rset.getString(1));
            String nomAdherent = rset.getString(2);
            String prenomAdherent = rset.getString(3);
            String adresseAdherent = rset.getString(4);
            String cpAdherent = rset.getString(5);
            String mdpAdherent = rset.getString(6);

            Adherent temp = new Adherent(numAdherent,nomAdherent,prenomAdherent,adresseAdherent,cpAdherent,mdpAdherent);
            
            LesAdherents.add(temp);
            
        }
        rset.close();

        
    }
    
    public boolean estAdherent(int numAdherent, String password ) throws SQLException {
        String requete = "select 1 from ADHERENT where numeroadherent = " + numAdherent + "and mdpadherent = " + password;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        boolean resultat = rset.next();
        pstmt.close();
        return resultat;
    }
    
       public int trouverAdherent(String nomAdhe, String preAdherent ) throws SQLException {
        String requete = "select numeroadherent from ADHERENT where nomadherent = '" + nomAdhe + "' and prenomadherent = '" + preAdherent+"'";
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        int numAdherent=0;
        while(rset.next()){    
            
         numAdherent = Integer.parseInt(rset.getString(1));
//        String nomAdherent = rset.getString(2);
//        String prenomAdherent = rset.getString(3);
//        String adresseAdherent = rset.getString(4);
//        String cpAdherent = rset.getString(5);
//        String mdpAdherent = rset.getString(6);
        }
        rset.close();
        return numAdherent;
    }
       
      public Adherent lireUnAdherentCoach(int numero,int numEmp) throws SQLException {
        String requete = "select * from ADHERENT where numeroAdherent = " + numero + "and numeroEmploye = "+numEmp;
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        Adherent temp;
        rset.next();
        int numAdherent = Integer.parseInt(rset.getString(1));
        String nomAdherent = rset.getString(2);
        String prenomAdherent = rset.getString(3);
        String adresseAdherent = rset.getString(4);
        String cpAdherent = rset.getString(5);
        String mdpAdherent = rset.getString(6);

        temp = new Adherent(numAdherent, nomAdherent, prenomAdherent, adresseAdherent, cpAdherent, mdpAdherent);

        rset.close();
        return temp;
    }
      
//     public void lireAdherenCoach(List<Adherent> LesAdherents, int numero) throws SQLException {
//        String requete = "select * from ADHERENT where numeroemploye = " + numero + " order by numeroadherent";
//        PreparedStatement pstmt = cnx.prepareStatement(requete);
//        ResultSet rset = pstmt.executeQuery(requete);
//        while (rset.next()) {
//            int numAdherent = Integer.parseInt(rset.getString(1));
//            String nomAdherent = rset.getString(2);
//            String prenomAdherent = rset.getString(3);
//            String adresseAdherent = rset.getString(4);
//            String cpAdherent = rset.getString(5);
//            String mdpAdherent = rset.getString(6);
//
//            Adherent temp = new Adherent(numAdherent, nomAdherent, prenomAdherent, adresseAdherent, cpAdherent, mdpAdherent);
//
//            LesAdherents.add(temp);
//
//        }
//        rset.close();
//
//    }

   public void lireAdherentCoach(List<Adherent> LesAdherents, int numero) throws SQLException {
        String requete = "select distinct adh.numeroadherent,adh.nomadherent,adh.prenomadherent,adresseAdherent,cpAdherent,mdpAdherent , tailleprofil from adherent adh, profil pr, EMPLOYE emp where adh.numeroadherent = pr.numeroadherent and pr.numeroemploye = "+ numero+ " order by numeroadherent";
        
        PreparedStatement pstmt = cnx.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {
            int numAdherent = Integer.parseInt(rset.getString(1));
            String nomAdherent = rset.getString(2);
            String prenomAdherent = rset.getString(3);
            String adresseAdherent = rset.getString(4);
            String cpAdherent = rset.getString(5);
            String mdpAdherent = rset.getString(6);

            Adherent temp = new Adherent(numAdherent, nomAdherent, prenomAdherent, adresseAdherent, cpAdherent, mdpAdherent);

            LesAdherents.add(temp);

        }
        rset.close();

    }
}


