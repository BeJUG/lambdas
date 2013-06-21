package E1_reflection.solution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Bank {

    private final Set<BankAccount> accounts = new HashSet<BankAccount>();

    public void executeOnAllAccounts(Method action, BigInteger bonus) {
        if (bonus.compareTo(BigInteger.ZERO) <= 0)
            throw new IllegalArgumentException();
        for (BankAccount account: getAllAccounts())
            try {
                action.invoke(account, bonus);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
    }

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
