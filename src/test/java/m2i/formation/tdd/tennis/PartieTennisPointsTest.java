package m2i.formation.tdd.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Joueur qui gagne le point")
class PartieTennisPointsTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);
    
    @Test
	@DisplayName("Les joueurs ont 0 points au de début de la partie")
	public void test0PointsDebutPartie() {
		Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);
		assertEquals(0, partie.getScoreJoueur1().getPoint());
		assertEquals(0, partie.getScoreJoueur2().getPoint());
	}
	
	@Test
	@DisplayName("Le joueur gagnant passe à 15 points si il avait 0 points")
	public void test0A15Points() {
		partie.getScoreJoueur1().setPoint(0);
		compteurScore.joueurGagnePoint(partie, joueur1);
		assertEquals(15, partie.getScoreJoueur1().getPoint());
		partie.getScoreJoueur2().setPoint(0);
		compteurScore.joueurGagnePoint(partie, joueur2);
		assertEquals(15, partie.getScoreJoueur2().getPoint());
	}
	
	@Test
	@DisplayName("Le joueur gagnant passe à 30 points si il avait 15 points")
	public void test15A30Points() {
		partie.getScoreJoueur1().setPoint(15);
		compteurScore.joueurGagnePoint(partie, joueur1);
		assertEquals(30, partie.getScoreJoueur1().getPoint());
		partie.getScoreJoueur2().setPoint(15);
		compteurScore.joueurGagnePoint(partie, joueur2);
		assertEquals(30, partie.getScoreJoueur2().getPoint());
	}
	
	@Test
	@DisplayName("Aucun points pour le joueur perdant")
	public void testAucunPointsJoueurPerdant() {
		partie.getScoreJoueur1().setPoint(0);
		partie.getScoreJoueur2().setPoint(0);
		compteurScore.joueurGagnePoint(partie, joueur1);
		assertEquals(0, partie.getScoreJoueur2().getPoint());
		compteurScore.joueurGagnePoint(partie, joueur2);
		assertEquals(15, partie.getScoreJoueur1().getPoint());
		compteurScore.joueurGagnePoint(partie, joueur1);
		assertEquals(15, partie.getScoreJoueur2().getPoint());
		compteurScore.joueurGagnePoint(partie, joueur2);
		assertEquals(30, partie.getScoreJoueur1().getPoint());
	}
	
	@Test
	@DisplayName("Le joueur gagnant passe à 40 points si il avait 30 points")
	public void test30A40Points() {
		partie.getScoreJoueur1().setPoint(30);
		compteurScore.joueurGagnePoint(partie, joueur1);
		assertEquals(40, partie.getScoreJoueur1().getPoint());
		partie.getScoreJoueur2().setPoint(30);
		compteurScore.joueurGagnePoint(partie, joueur2);
		assertEquals(40, partie.getScoreJoueur2().getPoint());
	}
}