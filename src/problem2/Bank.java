package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCustomer(Customer customer) {
        boolean exists = false;
        for (Customer c : customers) {
            if (c.getName().equals(customer.getName())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            customers.add(customer);
        }
    }

    public void addTransaction(String customerName, double amount) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                customer.addTransaction(amount);
                return;
            }
        }
    }

    public void printStatement(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                System.out.println("Customer: " + customer.getName());
                System.out.println("Transactions:");
                for (Double transaction : customer.getTransactions()) {
                    double amount = transaction; // unboxing
                    System.out.println(amount >= 0 ? 
                        "Credit: " + amount : 
                        "Debit: " + amount);
                }
                return;
            }
        }
        System.out.println("Customer not found: " + customerName);
    }
}