package gas.parsky.banque.exception;

/**
 * Created by Gasprod on 25/02/17.
 */
public class BankingOpMaxWithdrawException extends Exception{

    public BankingOpMaxWithdrawException(float solde) {
        System.out.println("Retrait refusé - solde négatif interdit " +
                "- maximum autorisé -> "+solde);
    }
}
