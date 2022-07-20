package m2i.formation.tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Joueur qui gagne le point set")
public class PartieTennisSetsTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);

    @Test
    @DisplayName("La partie est gagnée quand 2 sets sont gagnés")
    void testGagnerParDeuxSets() {
        partie.getScoreJoueur1().setSet(1);
        partie.getScoreJoueur1().setJeux(6);
        partie.getScoreJoueur1().setPoint(40);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(joueur1, partie.getGagnant());
    }

    @Test
    @DisplayName("Si un joueur est gagnant impossible de jouer après")
    void testErreurApresJoueurGagnant() {
        partie.setGagnant(null);
        partie.getScoreJoueur1().setSet(1);
        partie.getScoreJoueur1().setJeux(6);
        partie.getScoreJoueur1().setPoint(40);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertThrows(RuntimeException.class, () -> {
            compteurScore.joueurGagnePoint(partie, joueur1);
        });
    }
}
