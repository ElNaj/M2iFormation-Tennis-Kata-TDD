package m2i.formation.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Les deux joueurs sont a 6 jeux")
public class JeuxDecisifTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);

    @Test
    @DisplayName("Alors ont passe en jeux decisif")
    public void testGagneJeuxAvec2JeuxAvance() {
        partie.getScoreJoueur1().setJeux(5);
        partie.getScoreJoueur1().setPoint(40);
        partie.getScoreJoueur2().setJeux(6);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertTrue(partie.isJeuxDecisif());
    }


    @Test
    @DisplayName("Les points sont de 1 en 1")
    public void testGagnePointDansJeuxDecisif() {
        partie.setJeuxDecisif(true);
        partie.getScoreJoueur1().setPoint(0);
        for( int i = 1; i <= 6; i++){
            compteurScore.joueurGagnePoint(partie, joueur1);
            assertEquals(i, partie.getScoreJoueur1().getPoint());
        }
    }

    @Test
    @DisplayName("Si le gagnant a 2 points d'avance alors il gagne le jeux et donc le set")
    public void testGagneAvec2pointDavance() {
        partie.getScoreJoueur1().setSet(0);
        partie.setJeuxDecisif(true);
        partie.getScoreJoueur1().setPoint(6);
        partie.getScoreJoueur2().setPoint(5);
        compteurScore.joueurGagnePoint(partie, joueur1);
        assertEquals(1, partie.getScoreJoueur1().getSet());
    }
}