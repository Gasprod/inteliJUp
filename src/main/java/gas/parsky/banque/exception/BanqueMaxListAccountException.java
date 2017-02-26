package gas.parsky.banque.exception;

/**
 * Created by Gasprod on 25/02/17.
 */
public class BanqueMaxListAccountException extends Exception{

    public BanqueMaxListAccountException(int max){
        System.out.println("Ajout compte refusé - maximum de comptes - "+max+" a été atteint !");
    }

}
