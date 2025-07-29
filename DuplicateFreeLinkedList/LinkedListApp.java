import java.util.Scanner;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // Δημιουργία αντικειμένου συνδεδεμένης λίστας
        Scanner scanner = new Scanner(System.in);

        // Εισαγωγή αριθμών από το χρήστη
        System.out.println("Εισάγετε ακέραιους αριθμούς (0 για τερματισμό):");
        while (true) {
            int number = scanner.nextInt(); // Εισαγωγή αριθμού από τον χρήστη
            if (number == 0) {
                break; // Τερματισμός όταν εισαχθεί το 0
            }
            list.insert(number); // Προσθήκη του αριθμού στη λίστα
        }

        // Εκτύπωση της λίστας
        System.out.println("Η λίστα σας είναι:");
        list.printList(); // Κλήση της μεθόδου printList

        // Μέτρηση των διπλότυπων στοιχείων
        int duplicateCount = list.countDuplicateNodes(); // Κλήση της μεθόδου countDuplicateNodes
        System.out.println("The list contains " + duplicateCount + " duplicate value(s).");

        // Αφαίρεση των διπλότυπων στοιχείων και εκτύπωση της λίστας
        System.out.println("Removing duplicates...");
        list.removeDuplicates();
        System.out.println("List after removing duplicates:");
        list.printList();
    }
} 
