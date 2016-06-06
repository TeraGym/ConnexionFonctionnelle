/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Goth
 */
public class Abonnement {
    
    private int NumAbonnement;
    private String IntituleAbonnement;
    private String DureeAbonnement;
    private String DateDebutAbonnement;
    private String DateFinAbonnement;
    private Boolean ValidationAbonnement;
     private int NumAdherent;

    public Abonnement() {
    }
     
     

    public Abonnement(int NumAbonnement) {
        this.NumAbonnement = NumAbonnement;
    }

    public Abonnement(int NumAbonnement, String IntituleAbonnement, String DureeAbonnement, String DateDebutAbonnement, String DateFinAbonnement, Boolean ValidationAbonnement, int NumAdherent) {
        this.NumAbonnement = NumAbonnement;
        this.IntituleAbonnement = IntituleAbonnement;
        this.DureeAbonnement = DureeAbonnement;
        this.DateDebutAbonnement = DateDebutAbonnement;
        this.DateFinAbonnement = DateFinAbonnement;
        this.ValidationAbonnement = ValidationAbonnement;
        this.NumAdherent = NumAdherent;
    }
 

    public int getNumAdherent() {
        return NumAdherent;
    }

    public void setNumAdherent(int NumAdherent) {
        this.NumAdherent = NumAdherent;
    }
    
    

    public int getNumAbonnement() {
        return NumAbonnement;
    }

    public void setNumAbonnement(int NumAbonnement) {
        this.NumAbonnement = NumAbonnement;
    }

    public String getIntituleAbonnement() {
        return IntituleAbonnement;
    }

    public void setIntituleAbonnement(String IntituleAbonnement) {
        this.IntituleAbonnement = IntituleAbonnement;
    }

    public String getDureeAbonnement() {
        return DureeAbonnement;
    }

    public void setDureeAbonnement(String DureeAbonnement) {
        this.DureeAbonnement = DureeAbonnement;
    }

    public String getDateDebutAbonnement() {
        return DateDebutAbonnement;
    }

    public void setDateDebutAbonnement(String DateDebutAbonnement) {
        this.DateDebutAbonnement = DateDebutAbonnement;
    }

    public String getDateFinAbonnement() {
        return DateFinAbonnement;
    }

    public void setDateFinAbonnement(String DateFinAbonnement) {
        this.DateFinAbonnement = DateFinAbonnement;
    }

    public Boolean getValidationAbonnement() {
        return ValidationAbonnement;
    }

    public void setValidationAbonnement(Boolean ValidationAbonnement) {
        this.ValidationAbonnement = ValidationAbonnement;
    }
    
    
}
