package marche.traitement.participant;

import marche.affichage.ExceptionsPopups;
import marche.traitement.marche.Controleur;
import marche.traitement.marche.Marche;
import marche.traitement.marche.Offre;
import marche.traitement.produits.ProduitFermier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe Vendeur
 *
 * @author Tristan DIETZ
 * @author Nicolas Guigou
 */
public class Vendeur extends Decorateur{

    /**
     * Constructeur
     * @param acteur
     */
    public Vendeur(Acteur acteur){
        super(acteur);
    }

    /**
     * Méthode permettant de proposer une offre
     * @param quantite
     * @param NomProduit
     * @param prix
     */
    public void proposerOffreVente( int quantite, String NomProduit, int prix, Marche marche) {
        ArrayList<ProduitFermier> temp = new ArrayList<ProduitFermier>();
        int cpt = 0;
        for (ProduitFermier p : this.getInventaire()) {
            if (cpt == quantite) break;
            if (p.getClass().getCanonicalName() == NomProduit) {
                temp.add(p);
                this.enleverProduit(p);
                ++cpt;
            }
        }
        if (cpt != quantite) {
            System.out.println("La création de l'offre a échouée.");
            ExceptionsPopups.pasAssezObjets();
        }
        else {

            Offre offre = new Offre(prix, temp, this);

            if (Controleur.valider(offre)) {
                Controleur.ajouterOffre(offre, marche);
            } else {
                System.out.println("La création d'offre a échouée.");
                ExceptionsPopups.produitFermierNonCommercialisable();
            }

        }
    }
}