package m2i.formation.tdd.tennis;

import org.junit.jupiter.api.DisplayName;

@DisplayName("Joueur qui gagne un jeu")
public class PartieTennisJeuxTest {

    private static Joueur joueur1 = new Joueur();
    private static Joueur joueur2 = new Joueur();
    private static CompteurDeScoreTennis compteurScore = new CompteurDeScoreTennis();
    private static Partie partie = compteurScore.creerNouvellePartie(joueur1, joueur2);
    
}
