package problem3;

import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the capacity of the library: ");
        int capacity = scan.nextInt();
        scan.nextLine();
        
        Library library = new Library(capacity);
        
        library.add(new Novel("1984", "George Orwell", 328, 12.99));
        library.add(new Textbook("Java Programming", "John Doe", 500, "Undergraduate"));
        
        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Document");
            System.out.println("2. Display Documents");
            System.out.println("3. Delete Document");
            System.out.println("4. Find Document by Record Number");
            System.out.println("5. Display Authors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\nSelect document type:");
                    System.out.println("1. Book");
                    System.out.println("2. Novel");
                    System.out.println("3. Textbook");
                    System.out.println("4. Magazine");
                    System.out.println("5. Dictionary");
                    System.out.print("Enter choice: ");
                    int docType = scan.nextInt();
                    scan.nextLine();
                    
                    System.out.print("Enter title: ");
                    String title = scan.nextLine();
                    
                    Document doc = null;
                    if (docType == 1) {
                        System.out.print("Enter author: ");
                        String author = scan.nextLine();
                        System.out.print("Enter number of pages: ");
                        int pages = scan.nextInt();
                        scan.nextLine();
                        doc = new Book(title, author, pages);
                    } else if (docType == 2) {
                        System.out.print("Enter author: ");
                        String author = scan.nextLine();
                        System.out.print("Enter number of pages: ");
                        int pages = scan.nextInt();
                        System.out.print("Enter price: ");
                        double price = scan.nextDouble();
                        scan.nextLine();
                        doc = new Novel(title, author, pages, price);
                    } else if (docType == 3) {
                        System.out.print("Enter author: ");
                        String author = scan.nextLine();
                        System.out.print("Enter number of pages: ");
                        int pages = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter level: ");
                        String level = scan.nextLine();
                        doc = new Textbook(title, author, pages, level);
                    } else if (docType == 4) {
                        System.out.print("Enter month: ");
                        String month = scan.nextLine();
                        System.out.print("Enter year: ");
                        int year = scan.nextInt();
                        scan.nextLine();
                        doc = new Magazine(title, month, year);
                    } else if (docType == 5) {
                        System.out.print("Enter language: ");
                        String language = scan.nextLine();
                        doc = new Dictionary(title, language);
                    }
                    
                    if (doc != null) {
                        if (library.add(doc)) {
                            System.out.println("Document added successfully!");
                        } else {
                            System.out.println("Library is full! Cannot add document.");
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("\n=== All Documents ===");
                    library.displayDocuments();
                    break;
                    
                case 3:
                    System.out.print("Enter record number to delete: ");
                    int numRec = scan.nextInt();
                    scan.nextLine();
                    Document docToDelete = library.document(numRec);
                    if (docToDelete != null) {
                        if (library.delete(docToDelete)) {
                            System.out.println("Document deleted successfully!");
                        } else {
                            System.out.println("Failed to delete document.");
                        }
                    } else {
                        System.out.println("Document not found!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter record number: ");
                    int recNum = scan.nextInt();
                    scan.nextLine();
                    Document found = library.document(recNum);
                    if (found != null) {
                        System.out.println("Document found: " + found);
                    } else {
                        System.out.println("Document not found!");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== Authors ===");
                    library.displayAuthors();
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
        
        scan.close();
    }
}
