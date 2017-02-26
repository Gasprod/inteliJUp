package gas.parsky.holder;

/**
 * Created by Gasprod on 25/02/17.
 */
public class Address {

    private String street ;
    private int number ;
    private int po ;
    private Commune commune ;
    private Pays pays ;

    public Address(String street, int number, int po, Commune commune, Pays pays) {
        this.street = street;
        this.number = number;
        this.po = po;
        this.commune = commune;
        this.pays = pays;
    }

    public Address(){}

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", po=" + po +
                ", commune=" + commune +
                ", pays=" + pays +
                '}';
    }
}
