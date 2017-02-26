package gas.parsky.banque;

import gas.parsky.banque.exception.BankingOpMaxWithdrawException;
import gas.parsky.banque.exception.BankingOpNegAmountException;
import gas.parsky.holder.AccountHolder;

/**
 * Created by Gasprod on 25/02/17.
 */
public class SaveAccount extends AbstractAccount {

    private float interest_rate ;


    public SaveAccount(AccountHolder holder, float solde, float interest_rate) {
        super(holder,solde);
        this.interest_rate = interest_rate;
    }

    public void getInterest(){
        System.out.println("Interets -> "
                +this.solde*this.interest_rate);
    }

    @Override
    public boolean withdraw(float amount)
            throws BankingOpNegAmountException,
                    BankingOpMaxWithdrawException {
        if(amount < 0f)
            throw new BankingOpNegAmountException();
        else if(amount>this.solde)
            throw new BankingOpMaxWithdrawException(this.solde);
        else
            this.solde -= amount;

        System.out.println("retrait de "+amount+" effectué avec succes");
        return true ;

    }

}
