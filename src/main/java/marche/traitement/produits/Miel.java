package marche.traitement.produits;

import marche.traitement.production.Ruche;

import java.time.LocalDate;

/**
 * Classe Miel représentant un pot de miel
 *
 * @author Thibaud CENENT
 * @author Tristan DIETZ
 *
 * @version 1.7
 */
public class Miel extends ProduitFermier {

    /**
     * Attribut général d'un seau de miel.
     * Cette valeur est incrémentée au fur et à mesure du code, permettant d'identifier les seau de miel de manière
     * unique.
     *
     * @see Miel#Miel(float, LocalDate, short, float, String, Ruche)
     * @see Miel#idSeauMiel
     */
    private static int idSeauMielGeneral = 1500;

    /**
     * Identifiant d'un seau de miel.
     * Cette valeur est définie à la création d'un seau de miel en fonction de la valeur d'idSeauMielGeneral, permettant
     * d'obtenir un identifiant unique.
     *
     * @see Miel#getIdSeauMiel()
     * @see Miel#Miel(float, LocalDate, short, float, String, Ruche)
     * @see Miel#idSeauMielGeneral
     */
    private int idSeauMiel;

    /**
     * Le poids d'un seau de miel en kg. Il n'est pas modifiable
     * @see Miel#getPoidsSeauMiel()
     */
    private float poidsSeauMiel;

    /**
     *  Le type de miel présent dans le seau. Il n'est pas modifiable
     *  @see Miel#getTypeDeMiel()
     *
     */
    private String typeDeMiel;

    /**
     * Constructeur d'un seau de miel
     *
     * @param prix           désigne le prix du produit
     * @param datePeremption désigne la date de péremption du produit
     * @param qualite        désigne la qualité du produit sur une échelle de 1 à 100
     * @param poidsSeauMiel  désigne le poids d'un seau de miel en kg
     * @param typeDeMiel     désigne le type de miel
     * @param ruche          désigne la ruche associé à un pot de miel
     */
    public Miel(float prix, LocalDate datePeremption, short qualite, float poidsSeauMiel, String typeDeMiel,Ruche ruche) {
        this.prix = prix;
        this.datePeremption = datePeremption;
        this.qualite = qualite;
        this.idSeauMiel = idSeauMielGeneral;
        idSeauMielGeneral += 100;
        this.poidsSeauMiel = poidsSeauMiel;
        this.typeDeMiel = typeDeMiel;
        this.uniteDeProduction = ruche;
    }

    /** Retourne l'identifiant d'un seau de miel
     *
     * @return l'identifiant d'un seau de miel
     */
    public int getIdSeauMiel() {

        return idSeauMiel;
    }

    /** Retourne le poids d'un seau de miel
     *
     * @return le poids d'un seau de miel
     */
    public float getPoidsSeauMiel() {

        return poidsSeauMiel;
    }

    /** Retourne le type de miel
     *
     * @return le type de miel
     */
    public String getTypeDeMiel() {

        return typeDeMiel;
    }
}