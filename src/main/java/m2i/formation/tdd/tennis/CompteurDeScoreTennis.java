package m2i.formation.tdd.tennis;

/**
 * Classe avec le code pour calculer les scores d'une partie de tennis
 */
public class CompteurDeScoreTennis {

    /**
     * Méthode pour céer une nouvelle partie
     * Une partie avec 2 joureurs et 2 scores, scores à 0 en début de partie
     * @param joueur1 joueur 1
     * @param joueur2 joueur 2
     * @return nouvelle partie
     */
    public Partie creerNouvellePartie(Joueur joueur1, Joueur joueur2) {
        if (joueur1 == null || joueur2 == null) {
            throw new RuntimeException("Les joueurs ne doivent pas être null");
        }
        if (joueur1 == joueur2) {
            throw new RuntimeException("Les joueurs ne doivent pas être les mêmes !");
        }
        return new Partie(joueur1, joueur2);
    }

    /**
     * Méthode pour compter les points d'une partie
     * méthode a appeler quand joueur gagne un point
     * @param partie en cours
     * @param joueurGagnant joueur qui gagne
     * @return la partie avec les nouveaux scores
     */
    public Partie joueurGagnePoint(Partie partie, Joueur joueurGagnant) {

        if(partie.getGagnant() != null) {
            throw new RuntimeException("Partie finie !!!");
        }
        Score[] scores = gagnerPartie(partie, joueurGagnant);
        if(partie.isJeuxDecisif()) {
            gagnerPointJeuxDecisif(scores[0], scores[1], partie);
        } else {
            gagnerPoint(scores[0], scores[1]);
        }
        gererLesJeux(scores[0], scores[1], partie);
        if(scores[0].getSet() == 2) {
            partie.setGagnant(joueurGagnant);
        }
        return partie;

    }

    /**
     * Méthode pour compter les points d'un jeu décisif
     */
    private void gagnerPointJeuxDecisif(Score gagnant, Score perdant, Partie partie) {
        gagnant.setPoint(gagnant.getPoint() + 1);
        if(gagnant.getPoint() > 6 && gagnant.getPoint() >= perdant.getPoint() + 2) {
            gagnant.setSet(gagnant.getSet() + 1);
            gagnant.setJeux(0);
            gagnant.setPoint(0);
            perdant.setJeux(0);
            perdant.setPoint(0);
            partie.setJeuxDecisif(false);
        }
    }

    /**
     * Méthode pour le calcul des points d'un jeu
     * avec le cas de l'égalité à 40 points  
     * @param gagnant score gagnant
     * @param perdant score perdant
     */
    private void gagnerPoint(Score gagnant, Score perdant){
        if (gagnant.getPoint() == 0) {
			gagnant.setPoint(15);
    	} else if( gagnant.getPoint() == 15) {
    		gagnant.setPoint(30);
    	} else if(gagnant.getPoint() == 30){
    		gagnant.setPoint(40);
    	} else if (perdant.getPoint() != 40) {
    		gagnerJeu(gagnant, perdant);
    	} else {
    		egualite40Point(gagnant, perdant);
    	}
    }

    /**
     * Méthode pour déterminer un jeu gagner
     * @param gagnant score gagnant
     * @param perdant score perdant
     */
    private void gagnerJeu(Score gagnant, Score perdant) {
        gagnant.setPoint(0);
		perdant.setPoint(0);
		gagnant.setAvantage(false);
		gagnant.setJeux(gagnant.getJeux()+1);
    }

    /**
     * Méthode pour gérer le cas d'égalité à 40 points et déterminer quel joueur à l'avantage
     * @param gagnant score gagnant
     * @param perdant score perdant
     */
    private void egualite40Point(Score gagnant, Score perdant) {
		if(perdant.isAvantage()){
			perdant.setAvantage(false);
		} else if(!perdant.isAvantage() && !gagnant.isAvantage()){
			gagnant.setAvantage(true);
		} else if(gagnant.isAvantage()){
			gagnerJeu(gagnant, perdant);
		}
    }

    /**
     * Méthode permettant de gérer les points de 0 à 7 d'un jeu
     * @param gagnant score gagnant
     * @param perdant score perdant
     * @param partie partie en cours
     */
    private void gererLesJeux(Score gagnant, Score perdant, Partie partie) {
        if (gagnant.getJeux() >= 7 && gagnant.getJeux() >= perdant.getJeux() +2) {
			gagnant.setSet(gagnant.getSet() + 1);
			gagnant.setJeux(0);
			perdant.setJeux(0);
		}else if (gagnant.getJeux() == 6 && perdant.getJeux() == 6) {
			partie.setJeuxDecisif(true);
		}
    }

    /**
     * Méthode pour gérer les scores d'une partie 
     * et détermine les scores gagnant et perdant
     * @param partie partie en cours 
     * @param joueurGagnant joueur gagnant la partie de tennis
     * @return une liste de scores du joueur gagnant et du joueur perdant 
     */
    public Score[] gagnerPartie(Partie partie, Joueur joueurGagnant) {

        Score scoreJoueurGagnant;
        Score scoreJoueurPerdant;
        if (joueurGagnant == partie.getJoueur1()) {
            scoreJoueurGagnant = partie.getScoreJoueur1();
            scoreJoueurPerdant = partie.getScoreJoueur2();
        } else if (joueurGagnant == partie.getJoueur2()) {
            scoreJoueurGagnant = partie.getScoreJoueur2();
            scoreJoueurPerdant = partie.getScoreJoueur1();
        } else {
            throw new RuntimeException("Le joueur gagnant ne doit pas être ici!!");
        }
        return new Score[] {scoreJoueurGagnant, scoreJoueurPerdant};
    }

}
