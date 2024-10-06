public class BankAccount {
    private double amount;

    public BankAccount(double initialAmount) {
        this.amount = initialAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
        }
    }

    public void withdraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Сумма превышает остаток на счете", amount);
        }
        amount -= sum;
    }
}
