package problem2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");
        
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        
        bank.addTransaction("John Doe", 1000.0);
        bank.addTransaction("John Doe", -200.0);
        bank.addTransaction("John Doe", 500.0);
        
        bank.addTransaction("Jane Smith", 2000.0);
        bank.addTransaction("Jane Smith", -300.0);
        
        System.out.println("=== Bank Statement ===");
        bank.printStatement("John Doe");
        System.out.println();
        bank.printStatement("Jane Smith");
    }
}

