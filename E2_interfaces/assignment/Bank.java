package E2_interfaces.assignment;

import java.math.BigInteger;
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

    public Set<BankAccount> getAccountsBalanceNotBelow(BigInteger threshold) throws IllegalArgumentException {
        if (threshold == null)
            throw new IllegalArgumentException();
        Set<BankAccount> result = new HashSet<>();
        for (BankAccount account: accounts)
            if (account.getBalance().compareTo(threshold) >= 0)
                result.add(account);
        return result;
    }

}
