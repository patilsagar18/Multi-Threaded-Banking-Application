public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread customer1 = new Thread(new BankCustomer(account), "Customer 1");
        Thread customer2 = new Thread(new BankCustomer(account), "Customer 2");
        Thread customer3 = new Thread(new BankCustomer(account), "Customer 3");

        customer1.start();
        customer2.start();
        customer3.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
