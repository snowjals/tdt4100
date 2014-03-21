package inheritance;

public abstract class AbstractAccount {
    private double balance;

    public AbstractAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0)
            this.balance += amount;
        else
            throw new IllegalArgumentException("Illegal amount");
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Illegal amount");
        else {
            boolean allowed = true;
            try {
                internalWithdraw(amount);
            }
            catch (Exception e) {
                allowed = false;
                throw e;
            }
            if (allowed)
                this.balance -= amount;
        }
    }

    abstract void internalWithdraw(double amount);

    public double getBalance() {
        return this.balance;
    }
}
