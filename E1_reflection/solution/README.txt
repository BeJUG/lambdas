1. Refactor the code checking the bonus and depositing the bonus into a static method awardBonus of Experiment.
2. Refactor the static method awardBonus into an instance method of Bank.

3. Generalize the method awardBonus into executeOnAll(Method,BigInteger), and invoke the method in the body.
   Add exceptions where needed.
4. Invoke the method in Experiment supplying BankAccount.class.getMethod("deposit",BigInteger.class).
