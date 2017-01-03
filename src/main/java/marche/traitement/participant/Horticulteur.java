package marche.traitement.participant;

import marche.traitement.cotisation.Cotisation;
import marche.traitement.cotisation.Visitable;
import marche.traitement.production.UniteDeProduction;
import marche.traitement.produits.ProduitFermier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe relative à un fermier gérant la culture de jardins
 * @author Thibaud CENENT
 * @author Romain COLONNA D'ISTRIA
 * @version 1.0
 */
public class Horticulteur extends Fermier implements Visitable {

    /** Constructeur principal de Horticulteur
     *
     * @param inventaire liste des produits fermiers à attribuer au fermier lors de sa création
     * @param uniteDeProductions unités de productions dont dispose un fermier à sa création
     * @param solde Gain dont dispose un fermier lors de sa création
     */
    public Horticulteur(ArrayList<ProduitFermier> inventaire, Collection<UniteDeProduction> uniteDeProductions, float solde){
        super(inventaire,uniteDeProductions,solde);
    }

    /**
     *
     * @param cotisation désigne la cotisation que va devoir payer un fermier en fonction de ses caractéristiques.
     * @return le nouveau solde de l'horticulteur après la cotisation
     */
    public double payerCotisation(Cotisation cotisation) {
        return cotisation.calculMontantCotisation(this);
    }
}
