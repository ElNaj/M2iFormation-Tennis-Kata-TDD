package m2i.formation.tdd.tennis;

/**
 * Classe Score du joueur
 */
public class Score {
    private int point;
    private int jeux;
    private int set;
    private boolean avantage;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getJeux() {
        return jeux;
    }

    public void setJeux(int jeux) {
        this.jeux = jeux;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public boolean isAvantage() {
        return avantage;
    }

    public void setAvantage(boolean avantage) {
        this.avantage = avantage;
    }

    @Override
    public String toString() {
        return "Score{" +
                "point=" + point +
                ", jeux=" + jeux +
                ", set=" + set +
                ", avantage=" + avantage +
                '}';
    }
}
