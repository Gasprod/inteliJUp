package gas.parsky.main;

import gas.parsky.banque.AbstractAccount;
import gas.parsky.banque.Banque;
import gas.parsky.banque.CurentAccount;
import gas.parsky.banque.SaveAccount;
import gas.parsky.banque.exception.BankingOpMaxWithdrawException;
import gas.parsky.banque.exception.BankingOpNegAmountException;
import gas.parsky.banque.exception.BanqueMaxListAccountException;
import gas.parsky.holder.AccountHolder;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        Banque Martinka = new Banque("Martinka", 3);

        String account_holder = "account_holder_";
        AccountHolder ah;
        AbstractAccount abs;

        // loop for each bank's list accounts item ->
        for (int i = 0; i < Martinka.getMaxAccounts(); i++) {


            /* each item of the account's list has :
                -> a account holder
                    -> which has either an save account or a curent account
                       -> each account is appied 5 operations
            */

            ah = new AccountHolder(account_holder + i);

            if (i % 2 == 0) {
                abs = new CurentAccount(ah, getRandomNumberInRange(250, 500)*1f, -500f);
            } else {
                abs = new SaveAccount(ah, getRandomNumberInRange(250, 500)*1f , 0.01f);
            }

            /*  each account is applied 5 operations
                    5 x ( 1 deposit and 1 withdraw -> amount range -250 -> + 500)
            */
            for (int k = 0; k < 5; k++) {

                // *********************************************************************
                    float deposit = getRandomNumberInRange(-250, 500)*1f;
                            float withdraw = getRandomNumberInRange(-250, 500)*1f;
                // *********************************************************************
                System.out.println("OPERATION " + (k+1) + " sur COMPTE " + (i+1) + "\n***********************************************************");
                System.out.println("Solde avant operation : "+abs.getSolde());
                System.out.println("montant depot -> "+deposit);
                System.out.println("montant retrait -> "+withdraw);
                // **********************************************************************

                try {
                    abs.deposit(deposit);
                } catch (BankingOpNegAmountException e) {
                    // System.out.println(e.getMessage());
                }

                try {
                    abs.withdraw(withdraw);
                } catch (BankingOpNegAmountException e) {
                    // System.out.println(e.getMessage());
                } catch (BankingOpMaxWithdrawException e) {
                    // System.out.println(e.getMessage());
                }

                System.out.println("SOLDE APRES DEPOT ET RETRAIT -> "+abs.getSolde());
                System.out.println("***********************************************************");

            }

            if (abs instanceof SaveAccount) {
                ((SaveAccount) abs).getInterest();
                System.out.println("***********************************************************");
            }

            ah.addAccountToList(abs);

            try {
                Martinka.addAccountToList(abs);
            } catch (BanqueMaxListAccountException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("DETAIL COMPTES BANQUE MARTINKA " +
                "\n*************************************");

        Martinka.getListAccount().forEach((AbstractAccount a) -> System.out.println(a));


    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
