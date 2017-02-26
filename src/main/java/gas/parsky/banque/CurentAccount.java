package gas.parsky.banque;

import gas.parsky.banque.exception.BankingOpMaxWithdrawException;
import gas.parsky.banque.exception.BankingOpNegAmountException;
import gas.parsky.holder.AccountHolder;

/**
 * @author Gasprod
 */
public class CurentAccount extends AbstractAccount{

    private float minSolde ;


    public CurentAccount(AccountHolder holder, float solde,float minSolde) {
        super(holder,solde);
        this.minSolde = minSolde;

    }

    @Override
    public boolean withdraw(float amount)
            throws BankingOpNegAmountException,
                    BankingOpMaxWithdrawException {
        if(amount < 0f)
            throw new BankingOpNegAmountException();
        if (this.solde - amount < minSolde) {
            throw new BankingOpMaxWithdrawException(this.solde);
        } else {
            this.solde -= amount;
            System.out.println("retrait de "+amount+" effectué avec succes");
        }
        return true;
    }
}
