package marche.traitement.label;

/**
 * Classe LabelAOC désignant un label qui est attribué lorsqu'un produit est authentique et typique d'une région
 *
 * @author Thibaud CENENT
 * @version 1.1
 */
public class LabelAOC extends Label {

    /**
     * Désigne si un produit est authentique ou non. Elle n'est pas modifiable.
     * @see LabelAOC#isAuthenticiteProduit()
     */
    private boolean authenticiteProduit;

    /**
     * Désigne la région de création typique d'un produit. Elle n'est pas modifiable.
     * @see LabelAOC#getRegionCreationProduit()
     */
    private String regionCreationProduit;

    /**
     * Constructeur de la classe LabelAOC
     *
     * @param regionCreationProduit désigne la région de création d'un produit qui doit être typique. Elle n'est pas modifiable.
     * @param authenticiteProduit désigne le fait qu'un produit soit authentique ou non. Elle n'est pas modifiable.
     */
    public LabelAOC(String regionCreationProduit,boolean authenticiteProduit) {
        super();
        this.regionCreationProduit = regionCreationProduit;
        this.authenticiteProduit = authenticiteProduit;

    }

    /** Retourne la région de création d'un produit associé
     *
     * @return la région de création d'un produit
     */
    public String getRegionCreationProduit() {
        return regionCreationProduit;
    }

    /** Retourne si un produit est authentique ou non
     *
     * @return si un produit est authentique ou non
     */
    public boolean isAuthenticiteProduit() {
        return authenticiteProduit;
    }
}
