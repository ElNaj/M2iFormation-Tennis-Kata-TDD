package m2i.formation.tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Jeu gagné par le joueur gagnant")
class PartieTennisGagneLeJeuxTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);

    @Test
    @DisplayName("Le jeu est gagné si le gagnant a un avantage")
    public void testGagnerAvecAvantage() {
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setPoint(40);
        partie.getScoreJoueur1().setJeux(0);
        partie.getScoreJoueur1().setAvantage(true);
        partie.getScoreJoueur2().setAvantage(false);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(1, partie.getScoreJoueur1().getJeux());
    }
    
    @Test
    @DisplayName("Le jeu est gagné si le gagnant a un avantage et les points sont ensuite remis à 0")
    public void testGagnerAvecAvantageEtMiseAZero() {
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setPoint(40);
        partie.getScoreJoueur1().setAvantage(true);
        partie.getScoreJoueur2().setAvantage(false);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(0, partie.getScoreJoueur1().getPoint());
        assertEquals(0, partie.getScoreJoueur2().getPoint());
        assertFalse(partie.getScoreJoueur2().isAvantage());
        assertFalse(partie.getScoreJoueur2().isAvantage());
    }
    
    @Test
    @DisplayName("Le perdant a moins de 30 points et le gagnant a 40 point")
    public void testJeuxGagnerParAvance() {
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setPoint(30);
        partie.getScoreJoueur1().setAvantage(false);
        partie.getScoreJoueur2().setAvantage(false);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(3, partie.getScoreJoueur1().getJeux());
        assertEquals(0, partie.getScoreJoueur1().getPoint());
        assertEquals(0, partie.getScoreJoueur2().getPoint());
        assertFalse(partie.getScoreJoueur2().isAvantage());
        assertFalse(partie.getScoreJoueur2().isAvantage());
    }
}
