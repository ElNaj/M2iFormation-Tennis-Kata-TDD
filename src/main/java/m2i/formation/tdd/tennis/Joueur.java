package m2i.formation.tdd.tennis;

/**
 * Classe Joueur 
 */
public class Joueur {
    
    private String nom;
    private String prenom;


    public Joueur() {
        this("","");
    }

    public Joueur(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }
}
