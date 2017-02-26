package gas.parsky.banque;

import gas.parsky.banque.exception.BanqueMaxListAccountException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gasprod
 */
public class Banque {

    private List<AbstractAccount> listAccount;
    private String banque_name ;
    private int maxAccounts ;

    public Banque(){
        this.listAccount = new ArrayList<>();
    }

    public Banque(String banque_name, int maxAccounts) {
        this.listAccount = new ArrayList<>();
        this.banque_name = banque_name;
        this.maxAccounts = maxAccounts;
    }

    public boolean addAccountToList(AbstractAccount account)
        throws BanqueMaxListAccountException  {

        if(listAccount.size()==this.maxAccounts)
            throw new BanqueMaxListAccountException(this.maxAccounts);

        else
            listAccount.add(account);
        return true ;

    }

    public int getMaxAccounts() {
        return maxAccounts;
    }

    public void getBanqueListeDetails(){

        listAccount.forEach((AbstractAccount a)->System.out.println(a) );

        //listAccount.forEach(System.out::println);
    }

    public List<AbstractAccount> getListAccount() {
        return listAccount;
    }

}
