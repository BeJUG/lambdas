package E1_reflection.assignment;

import java.math.BigInteger;
import java.util.Scanner;

public class Experiment {

    public static void main(String[] argsv) {

        // Setting op a bank.
        Bank christmasBank = new Bank();
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(100)));
        christmasBank.addAccount(new BankAccount(BigInteger.valueOf(50), BigInteger.valueOf(-1000)));

        // Award a bonus to all bank accounts of the Christmas bank.
        System.out.print("Enter the bonus to be awarded: ");
        Scanner inputStreamScanner = new Scanner(System.in);
        BigInteger bonus = BigInteger.valueOf(inputStreamScanner.nextLong());

        if (bonus.compareTo(BigInteger.ZERO) <= 0)
            throw new IllegalArgumentException();
        for (BankAccount account: christmasBank.getAllAccounts())
            account.deposit(bonus);

        // Print the balance of each account.
        for (BankAccount account: christmasBank.getAllAccounts())
            System.out.println(account.getBalance());

    }

}
