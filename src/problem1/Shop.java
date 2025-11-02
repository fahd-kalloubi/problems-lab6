package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop 
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";

        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();

            scan.nextLine();
            Item item = new Item(itemName, itemPrice, quantity);

            cart.add(item);



            System.out.print ("Continue shopping (y|n)? ");
            keepShopping = scan.nextLine();


        }
        while (keepShopping.equals("y"));

        System.out.println("\nCart Contents:");
        double totalPrice = 0;
        for (Item item : cart) {
            System.out.println(item);
            totalPrice += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total Price: " + totalPrice);

    }
}
