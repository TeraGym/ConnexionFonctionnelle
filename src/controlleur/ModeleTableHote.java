/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import accesOracle.DaoAbonnement;
import accesOracle.DaoAdherent;
import accesOracle.DaoEmploye;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import metier.Abonnement;
import metier.Adherent;


/**
 *
 * @author Goth
 */
public class ModeleTableHote extends AbstractTableModel {
       
    private DaoAbonnement leDaoAbo;
    private DaoAdherent leDaoAdh;
    private DaoEmploye leDaoEmp;
    private int numero=0;
    private List<Abonnement> leConteneurAbo;
    private List<Adherent> leConteneurAdh;
    //private DaoEmploye leDaoEmp;

    public ModeleTableHote(DaoEmploye leDao) {
        this.leDaoEmp = leDao;
      
        
               leConteneurAbo = new ArrayList<>();
               leConteneurAdh = new ArrayList<>();
        try {
               charger();
           
        } catch (SQLException ex) {
            Logger.getLogger(ModeleTableEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public int trouverAdherent(String nom,String prenom) throws SQLException{

       try {
          numero = leDaoAdh.trouverAdherent(nom,prenom);
        } catch (SQLException ex) {
            Logger.getLogger(ModeleTableEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
           
               return numero;
           
    }
    
    public void charger() throws SQLException {
        leDaoAbo.lireAbonnement(leConteneurAbo);
        leDaoAdh.lireAdherent(leConteneurAdh);
         //trouve = leDaoAdh.trouverAdherent(nom,prenom);
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    

}
