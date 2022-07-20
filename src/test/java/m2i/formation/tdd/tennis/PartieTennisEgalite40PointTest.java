package m2i.formation.tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Egalité à 40 points")
class PartieTennisEgalite40PointTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);

    @BeforeEach
    public void before() {
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setPoint(40);
    }

    @Test
    @DisplayName("Le joueur gagnant gagne l'avantage si aucun des 2 joueurs n'en a")
    public void testAvantageGagnerGagnant() {
        partie.getScoreJoueur1().setAvantage(false);
        partie.getScoreJoueur2().setAvantage(false);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertTrue(partie.getScoreJoueur1().isAvantage());
    }

    @Test
    @DisplayName("Le joueur perdant perd son avantage si il en a un et le joueur gagnant n'en gagne pas")
    public void testdAvantagePerdrePerdant() {
        partie.getScoreJoueur1().setAvantage(false);
        partie.getScoreJoueur2().setAvantage(true);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertFalse(partie.getScoreJoueur1().isAvantage());
        assertFalse(partie.getScoreJoueur2().isAvantage());
    }
}