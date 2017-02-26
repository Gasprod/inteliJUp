package gas.parsky.holder;

import gas.parsky.banque.AbstractAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gasprod on 25/02/17.
 */
public class AccountHolder {

    private AbstractAccount account;
    private String firstName;
    private String lastName;
    private String nickName;
    private Address address;
    private List<AbstractAccount> listAccounts ;

    public AccountHolder(String firstName, String lastName, String nickName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.address = address;
    }

    public AccountHolder(String nickName) {

        this.nickName = nickName;
        listAccounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAccountToList(AbstractAccount account){
        this.listAccounts.add(account);
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "nickName='" + nickName + '\'' +
                "nombre de comptes='" + this.listAccounts.size() + '\'' +
                '}';
    }
}
