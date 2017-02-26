package gas.parsky.holder;

/**
 * Created by Gasprod on 25/02/17.
 */
public class Pays {

    private String pays_nom ;

    public Pays(String pays_nom) {
        this.pays_nom = pays_nom;
    }

    public Pays() {
    }

    public String getPays_nom() {
        return pays_nom;
    }

    public void setPays_nom(String pays_nom) {
        this.pays_nom = pays_nom;
    }
}
