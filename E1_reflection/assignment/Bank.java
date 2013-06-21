package E1_reflection.assignment;

import java.util.*;

public class Bank {

    private final Set<BankAccount> accounts = new HashSet<BankAccount>();

    public Set<BankAccount> getAllAccounts() {
        return Collections.unmodifiableSet(accounts);
    }

    public boolean canHaveAsAccount(BankAccount account) {
        return account != null;
    }

    public void addAccount(BankAccount account) throws IllegalArgumentException {
        if (! canHaveAsAccount(account))
            throw new IllegalArgumentException();
        accounts.add(account);
    }

}
