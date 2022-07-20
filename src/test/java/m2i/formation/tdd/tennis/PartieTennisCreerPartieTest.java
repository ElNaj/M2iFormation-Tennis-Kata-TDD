package m2i.formation.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Créer une nouvelle partie de tennis")
public class PartieTennisCreerPartieTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();

    @Test
    @DisplayName("Avec deux joueurs")
    public void testCreationAvecDeuxJoueurs() {
        Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);
        assertNotNull(partie);
    }

    @Test
    @DisplayName("Retourne une erreur si un des joueur est null")
    public void testErreurSiJoueurNull() {
        assertThrows(RuntimeException.class, () -> compteurScore.creerNouvellePartie(joueur1, null));
        assertThrows(RuntimeException.class, () -> compteurScore.creerNouvellePartie(null, joueur2));
    }

    @Test
    @DisplayName("Retourne une erreur si un seul joueur participe a la partie")
    public void testErreurSiUnSeulJoueur() {
        assertThrows(RuntimeException.class, () -> compteurScore.creerNouvellePartie(joueur2, joueur2));
    }

    @Test
    @DisplayName("La partie contient les deux joueurs")
    public void testContientLesJoueurs() {
        Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);
        assertEquals(joueur1, partie.getJoueur1());
        assertEquals(joueur2, partie.getJoueur2());
    }

}
