package E2_interfaces.assignment;

import java.math.BigInteger;

public class BankAccount {

    public BankAccount(BigInteger balance, BigInteger creditLimit) throws IllegalArgumentException{
        if (! this.canHaveAsCreditLimit(creditLimit))
            throw new IllegalArgumentException();
        this.creditLimit = creditLimit;
        this.setBalance(balance);
    }

    public BankAccount(BigInteger balance) throws IllegalArgumentException{
        this(balance,BigInteger.ZERO);
    }

    public BigInteger getBalance() {
        return balance;
    }

    public boolean canHaveAsBalance(BigInteger balance) {
        return (balance != null) && (balance.compareTo(this.getCreditLimit()) >= 0);
    }

    public void deposit(BigInteger amount) throws IllegalArgumentException {
        if ( (amount == null) || (amount.compareTo(BigInteger.ZERO) <= 0) )
            throw new IllegalArgumentException();
        setBalance(this.getBalance().add(amount));
    }

    private void setBalance(BigInteger balance) throws IllegalArgumentException {
        if (! this.canHaveAsBalance(balance))
            throw new IllegalArgumentException();
        this.balance = balance;
    }

    private BigInteger balance;

    public BigInteger getCreditLimit() {
        return creditLimit;
    }

    public boolean canHaveAsCreditLimit(BigInteger creditLimit) {
        return (creditLimit != null) && (creditLimit.compareTo(BigInteger.ZERO) <= 0);
    }

    private final BigInteger creditLimit;

    public void award_bonus(BigInteger threshold, BigInteger bonus) {
        if (getBalance().compareTo(threshold) >= 0)
            deposit(bonus);
    }


}
