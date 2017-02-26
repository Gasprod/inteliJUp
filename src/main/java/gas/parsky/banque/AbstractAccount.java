package gas.parsky.banque;


import gas.parsky.banque.exception.BankingOpMaxWithdrawException;
import gas.parsky.banque.exception.BankingOpNegAmountException;
import gas.parsky.holder.AccountHolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Gasprod
 */
public abstract class AbstractAccount /*implements BankingBasicOperations*/{

    private static int accountNumberCpt = 0 ;

    protected int accountNbr ;
    protected float solde ;
    protected AccountHolder holder ;


    public AbstractAccount(AccountHolder holder, float solde) {
        this.solde = solde;
        this.holder = holder;
        this.accountNbr = ++AbstractAccount.accountNumberCpt;
    }

    public abstract boolean withdraw(float amount)
            throws BankingOpNegAmountException,
                    BankingOpMaxWithdrawException;

    public boolean deposit(float amount)
            throws BankingOpNegAmountException {

        if(amount <0) {
            throw new BankingOpNegAmountException();
        }

        this.solde +=amount;
        System.out.println("dépot de "+amount+" effectué avec succes");
        return true ;

    }

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "accountNbr=" + accountNbr +
                ", solde=" + solde +
                ", holder=" + holder +
                '}';
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }



}
