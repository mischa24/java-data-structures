public class Node {
    int data; // εδώ η τιμή του κόμβου
    Node next; //εδώ ο δείκτης στον επόμενο κόμβο
    // και πάμε στον κατασκευαστή της κλάσης
    public Node(int data) {
        this.data = data; //εδώ θα θέσουμε την τιμή του κόμβου
        this.next = null; //σε πρώτη φάση ο επόμενος κόμβος είναι null
    }
}