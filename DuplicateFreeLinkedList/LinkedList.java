import java.util.HashSet;

public class LinkedList {
    private Node head; // Ο πρώτος κόμβος της λίστας

    // Μέθοδος για εισαγωγή νέου αριθμού στη λίστα
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Μέθοδος για εκτύπωση της λίστας
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Μέθοδος για μέτρηση διπλότυπων στοιχείων
    public int countDuplicateNodes() {
        if (head == null) {
            return 0;
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (seen.contains(current.data)) {
                duplicates.add(current.data);
            } else {
                seen.add(current.data);
            }
            current = current.next;
        }

        return duplicates.size();
    }

    // Μέθοδος για αφαίρεση διπλότυπων στοιχείων
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next; // Διαγραφή του διπλότυπου κόμβου
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
} 
