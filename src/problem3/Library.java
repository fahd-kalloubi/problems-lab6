package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    private ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public void displayDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents in the library.");
        } else {
            for (Document doc : documents) {
                System.out.println(doc);
            }
        }
    }

    public boolean add(Document doc) {
        if (documents.size() >= capacity) {
            return false;
        }
        documents.add(doc);
        return true;
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnrg) {
        for (Document doc : documents) {
            if (doc.getNumRec() == numEnrg) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors() {
        boolean found = false;
        for (Document doc : documents) {
            if (doc instanceof Book) {
                Book book = (Book) doc;
                System.out.println(book.getAuthor());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books with authors found.");
        }
    }
}
