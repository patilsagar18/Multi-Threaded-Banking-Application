import java.util.Random;

public class BankCustomer implements Runnable {
    private BankAccount account;
    private Random random = new Random();

    public BankCustomer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (random.nextBoolean()) {
                account.deposit(random.nextInt(100));
            } else {
                account.withdraw(random.nextInt(100));
            }

            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

