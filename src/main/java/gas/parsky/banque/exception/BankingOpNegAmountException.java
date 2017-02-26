package gas.parsky.banque.exception;

import gas.parsky.banque.BankingBasicOperations;

/**
 * Created by Gasprod on 25/02/17.
 */
public class BankingOpNegAmountException extends Exception {

    public BankingOpNegAmountException(){
        System.out.println("Depot/retrait negatif pas possible !");
    }


}
