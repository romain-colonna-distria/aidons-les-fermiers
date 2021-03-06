package marche.traitement.participant;

import marche.traitement.exceptions.SoldeNonDisponibleException;
import marche.traitement.production.Verger;
import marche.traitement.produits.Pomme;
import marche.traitement.produits.ProduitFermier;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests unitaire de la classe Fermier
 *
 * @author Romain COLONNA D'ISTRIA
 * @author Nicolas Guigou
 *
 * @see Fermier
 *
 * @version 1.0
 */
public class FermierTest {

    @Test
    /**
     * Test du solde du trader avec le bon type
     */
    public void testDuSoldeDuFermier() {
        Acteur fermier = new ProducteurLaitier(null, null, 0);
        fermier.ajouterSolde(50.0);

        assert fermier.getSolde() == 50.0;
    }

    @Test
    /**
     * Test du solde du trader avec un int (test du cast implicite)
     */
    public void testDuSoldeDuFermierAvecInt() {
        Acteur fermier = new Horticulteur(null, null, 0);
        fermier.ajouterSolde(50);

        assert fermier.getSolde() == 50.0;
    }

    @Test(expected = SoldeNonDisponibleException.class)
    /**
     * Test d'enlever du solde supérieur à ce qui est possible : soulève une exception SoldeNonDisponibleException
     */
    public void testEnleverSolde() throws SoldeNonDisponibleException {
        Acteur fermier = new ProducteurDeViande(null, null, 0);
        fermier.ajouterSolde(30.0);
        fermier.enleverSolde(50.0);
    }

    @Test
    /**
     * Test d'ajout du produit fermier dans l'inventaire d'un acteur
     */
    public void testAjouterProduit() {
        Acteur fermier = new Arboriculteur(new ArrayList<ProduitFermier>(), null, 0);
        ProduitFermier pomme = new Pomme(10, LocalDate.of(1996, Month.SEPTEMBER, 13), (short)90, 1, "Reinette", 15, new Verger(50,"Normandie"));


        List<ProduitFermier> test = new ArrayList<ProduitFermier>();

        fermier.ajoutProduit(pomme);
        test.add(pomme);

        assertEquals (fermier.getInventaire(), test);
    }
}
