package E7_streams.assignment;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Experiment {

    private static Bank christmasBank = new Bank();
    private static String[] customerIds = {"Eric", "John", "Peter", "Mary", "Elisabeth", "Ann"};

    public static void main(String[] argsv) {
        init();
        sumNegativeBalances();
        checkAllPositives("Eric");
        awardBonusExternal();
        awardBonusInternal();
    }

    public static void init() {
        int customerIndex = 0;
        for (int bal=-1000; bal <= 1000; bal+=50) {
            BankAccount newAccount =
                new BankAccount(customerIds[customerIndex], BigInteger.valueOf(bal), BigInteger.valueOf(-2000));
            customerIndex = (customerIndex+1)%customerIds.length;
            christmasBank.addAccount(newAccount);
        }
    }

    public static void sumNegativeBalances() {
        // External iteration
        BigInteger total = BigInteger.ZERO;
        for (BankAccount account: christmasBank.getAllAccounts())
            if (account.getBalance().signum() < 0)
                total = total.add(account.getBalance());
        System.out.println("Total of negative balances (int): " + total);
        // Internal iteration
        BigInteger totalAlt = BigInteger.ZERO;
            // To be worked out.
        System.out.println("Total of negative balances (ext): " + totalAlt);
    }

    public static void checkAllPositives(String customerId) {
        // External iteration
        boolean allPositives = true;
        for (BankAccount account: christmasBank.getAllAccounts())
            if ( account.getCustomerId().equals(customerId) && (account.getBalance().signum() < 0) )  {
                allPositives = false;
                break;
            }
        System.out.println("All positive balances for " + customerId + " (ext) is " + allPositives);
        //Internal iteration
        boolean allPositivesAlt = true;
                // To be worked out.
        System.out.println("All positive balances for " + customerId + " (int) is " + allPositivesAlt);
    }

    public static void awardBonusExternal() {
        class AwardBonus extends RecursiveAction {

            public AwardBonus(ArrayList<BankAccount> accounts, int start, int end) {
                this.accounts = accounts;
                this.start = start;
                this.end = end;
            }

            private ArrayList<BankAccount> accounts;
            private final int start, end;

            private void awardBonus() {
                BigInteger bonusReduction = BigInteger.valueOf(100);
                for (int i=start; i<end; i++) {
                    BankAccount currentAccount = accounts.get(i);
                    if (currentAccount.getBalance().signum() > 0)
                        currentAccount.deposit(currentAccount.getBalance().divide(bonusReduction));
                }
            }

            @Override
            protected void compute() {
                // Better use Runtime.getRuntime().availableProcessors()
                if (end-start < 10)
                     awardBonus();
                else {
                    invokeAll(new AwardBonus(accounts,start,(start+end)/2),
                              new AwardBonus(accounts,(start+end)/2,end));
                }
            }
        }

        ForkJoinPool pool = new ForkJoinPool();
        ArrayList<BankAccount> accountsList = new ArrayList<>(christmasBank.getAllAccounts());
        pool.invoke(new AwardBonus(accountsList,0,accountsList.size()));

        System.out.print("Balances of all accounts (ext): ");
        for (BankAccount account: accountsList)
            System.out.print(" " + account.getBalance());
        System.out.println();

    }

    public static void awardBonusInternal() {
        BigInteger bonusReduction = BigInteger.valueOf(100);

            // To be worked out.

        System.out.print("Balances of all accounts (int): ");
        for (BankAccount account: christmasBank.getAllAccounts())
            System.out.print(" " + account.getBalance());
        System.out.println();

    }

}
