package m2i.formation.tdd.tennis;

/**
 * Classe Partie, partie de tennis entre 2 joueurs avec scores
 */
public class Partie {
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur gagnant;

    private Score scoreJoueur1 = new Score(0,0,0,false);
    private Score scoreJoueur2 = new Score(0,0,0,false);

    private boolean jeuxDecisif;

    public Partie(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.jeuxDecisif = false;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Joueur getGagnant() throws NullPointerException {
        if(gagnant == null){
            throw new NullPointerException("Aucun gagnant, la partie n'est pas finie");
        }
        return gagnant;
    }

    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }

    public Score getScoreJoueur1() {
        return scoreJoueur1;
    }

    public void setScoreJoueur1(Score scoreJoueur1) {
        this.scoreJoueur1 = scoreJoueur1;
    }

    public Score getScoreJoueur2() {
        return scoreJoueur2;
    }

    public void setScoreJoueur2(Score scoreJoueur2) {
        this.scoreJoueur2 = scoreJoueur2;
    }

    public boolean isJeuxDecisif() {
        return jeuxDecisif;
    }

    public void setJeuxDecisif(boolean jeuxDecisif) {
        this.jeuxDecisif = jeuxDecisif;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "joueur1=" + joueur1 +
                ", joueur2=" + joueur2 +
                ", gagnant=" + gagnant +
                ", scoreJoueur1=" + scoreJoueur1 +
                ", scoreJoueur2=" + scoreJoueur2 +
                ", jeuxDecisif=" + jeuxDecisif +
                '}';
    }
}
