package E5_methodReferences.solution;

import java.math.BigInteger;
import java.util.Set;

public class Experiment {

    public static void main(String[] argsv) {

        // Setting op a bank.
        Bank christmasBank = new Bank();
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(100)));
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(50), BigInteger.valueOf(-1000)));
        BankAccount theAccount = new BankAccount(BigInteger.valueOf(-70), BigInteger.valueOf(-1500));
        christmasBank.addAccount(theAccount);

        // Collect and print all accounts with a balance not below 80: Static method
        Set<BankAccount> accountsPositiveBalance =
            christmasBank.getAccountsSatisfying
                    (Bank::hasPositiveBalance);
        System.out.println("Static method");
        for (BankAccount account: accountsPositiveBalance)
            System.out.println(account.getBalance());
        System.out.println();

        // Collect and print all accounts with a balance not below 80: Instance method via class
        accountsPositiveBalance =
                christmasBank.getAccountsSatisfying
                        (BankAccount::hasPositiveBalance);
        System.out.println("Instance method via class");
        for (BankAccount account: accountsPositiveBalance)
            System.out.println(account.getBalance());
        System.out.println();

        // Collect and print all accounts with a balance not below 80: Instance method via instance
        accountsPositiveBalance =
                christmasBank.getAccountsSatisfying
                        (theAccount::hasHigherBalanceThan);
        System.out.println("Instance method via instance");
        for (BankAccount account: accountsPositiveBalance)
            System.out.println(account.getBalance());
        System.out.println();

        // Generate and print duplicate accounts with a balance 10 higher than the original account.
        Set<BankAccount> newAccounts =
                christmasBank.getReplacingAccounts
                        (BankAccount::new);
        System.out.println("Constructor");
        for (BankAccount account: newAccounts)
            System.out.println(account.getBalance());
        System.out.println();


    }

}
