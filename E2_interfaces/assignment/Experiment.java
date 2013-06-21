package E2_interfaces.assignment;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Set;

public class Experiment {

    public static void main(String[] argsv) {

        // Setting op a bank.
        Bank christmasBank = new Bank();
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(100)));
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(50), BigInteger.valueOf(-1000)));

        // Print the balance of all accounts with a balance not below some threshold.
        System.out.print("Enter the threshold for the balance: ");
        Scanner inputStreamScanner = new Scanner(System.in);
        BigInteger threshold = BigInteger.valueOf(inputStreamScanner.nextLong());

        Set<BankAccount> accountsBalanceNotBelowThreshold =
            christmasBank.getAccountsBalanceNotBelow(threshold);
        for (BankAccount account: accountsBalanceNotBelowThreshold)
            System.out.println(account.getBalance());

    }

}
