package m2i.formation.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Joueur qui gagne un jeu")
public class PartieTennisJeuxTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);

    @Test
    @DisplayName("Si il a i il passe a i+1 point (jusqu'a 6)")
    public void testGagneJeu() {
        partie.getScoreJoueur1().setJeux(0);
        for (int i = 1; i <= 6; i++) {
            partie.getScoreJoueur1().setPoint(40);
            compteurScore.joueurGagnePoint(partie, joueur1);
            assertEquals(i, partie.getScoreJoueur1().getJeux());
        }
    }


    @Test
    @DisplayName("Si le gagnant a 6 jeux et le perdant moins de 4 (inclu)")
    public void testGagneJeuxAvec2JeuxAvance6A4() {
        partie.getScoreJoueur1().setJeux(6);
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setJeux(4);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(1, partie.getScoreJoueur1().getSet());
        assertEquals(0, partie.getScoreJoueur1().getJeux());
        assertEquals(0, partie.getScoreJoueur2().getJeux());
    }


    @Test
    @DisplayName("Si le gagnant a 2 jeux d'avance, alors il gagne le set")
    public void testGagneJeuxAvec2JeuxAvance() {
        partie.getScoreJoueur1().setSet(0);
        partie.getScoreJoueur1().setJeux(6);
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setJeux(5);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(1, partie.getScoreJoueur1().getSet());
        assertEquals(0, partie.getScoreJoueur1().getJeux());
        assertEquals(0, partie.getScoreJoueur2().getJeux());
    }
}
