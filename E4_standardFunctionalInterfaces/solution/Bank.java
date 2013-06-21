package E4_standardFunctionalInterfaces.solution;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

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

    public Set<BankAccount> getAccountsSatisfying(Predicate<BankAccount> predicate) {
        Set<BankAccount> result = new HashSet<>();
        for (BankAccount account: accounts)
            if (predicate.test(account))
                result.add(account);
        return result;
    }

}
