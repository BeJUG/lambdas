package E3_functionalInterfaces.solution;

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
        for (int i = 1; i < 3; i++) {
            System.out.print("Enter the threshold for the balance: ");
            Scanner inputStreamScanner = new Scanner(System.in);
            final BigInteger threshold = BigInteger.valueOf(inputStreamScanner.nextLong());

            Set<BankAccount> accountsBalanceNotBelowThreshold =
                    christmasBank.getAccountsSatisfying
                            (account -> account.getBalance().compareTo(threshold) >= 0);
            for (BankAccount account : accountsBalanceNotBelowThreshold)
                System.out.println(account.getBalance());
        }
    }

}
