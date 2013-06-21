package E5_methodReferences.assignment;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;

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

    public static boolean hasPositiveBalance(BankAccount left) {
        return left.getBalance().compareTo(BigInteger.ZERO) >= 0;
    }

    public static boolean hasHigherBalanceThan(BankAccount account, BigInteger threshold) {
        return account.getBalance().compareTo(threshold) >= 0;
    }

    public Set<BankAccount> getAccountsSatisfying(Predicate<BankAccount> predicate) {
        Set<BankAccount> result = new HashSet<>();
        for (BankAccount account: accounts)
            if (predicate.test(account))
                result.add(account);
        return result;
    }

    public Set<BankAccount> getReplacingAccounts(BiFunction<BigInteger,BigInteger,BankAccount> generator) {
        Set<BankAccount> result = new HashSet<>();
        for (BankAccount account: accounts)
            result.add(generator.apply(account.getBalance().add(BigInteger.TEN),account.getCreditLimit()));
        return result;
    }

}
