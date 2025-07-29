import java.util.Scanner;
import java.math.MathContext;

public class DecimalToBinaryApp {
    public static void main(String[] args) {
        // Δημιουργία αντικειμένου της κλάσης DecimalToBinaryConverter
        DecimalToBinaryConverter converter = new DecimalToBinaryConverter();

        // Δημιουργία Scanner για είσοδο από το χρήστη
        Scanner scanner = new Scanner(System.in);

        // Εισαγωγή αριθμού από τον χρήστη
        System.out.println("Enter a double number:");
        double number = scanner.nextDouble();

        // Εισαγωγή ακρίβειας για το δεκαδικό μέρος
        System.out.println("Enter the precision for the decimal part:");
        int precision = scanner.nextInt();

        // Ορισμός υψηλής ακρίβειας
        MathContext mc = new MathContext(precision + 10);

        // Έλεγχος για αρνητικούς αριθμούς
        boolean isNegative = number < 0;
        number = Math.abs(number);

        // Υπολογισμός δυαδικής αναπαράστασης
        String binaryRepresentation = converter.convertToBinary(number, precision);

        // Αφαίρεση τελείας αν δεν υπάρχει κλασματικό μέρος
        if (precision == 0 && binaryRepresentation.endsWith(".")) {
            binaryRepresentation = binaryRepresentation.substring(0, binaryRepresentation.length() - 1);
        }

        // Αφαίρεση περιττών μηδενικών στο τέλος του κλασματικού μέρους
        if (binaryRepresentation.contains(".")) {
            while (binaryRepresentation.endsWith("0")) {
                binaryRepresentation = binaryRepresentation.substring(0, binaryRepresentation.length() - 1);
            }
            if (binaryRepresentation.endsWith(".")) {
                binaryRepresentation = binaryRepresentation.substring(0, binaryRepresentation.length() - 1);
            }
        }

        // Υπολογισμός της αναπαράστασης ως άθροισμα δυνάμεων του 2 με όριο διακοπής για μικρές τιμές
        String powersOfTwoRepresentation = converter.binaryAsPowersOfTwo(number, precision);

        // Έλεγχος για εξαιρετικά μικρές τιμές (threshold)
        if (powersOfTwoRepresentation.isEmpty() && number < 1e-15) {
            powersOfTwoRepresentation = "Value too small to represent in binary with current precision.";
        }

        // Εμφάνιση αποτελεσμάτων
        if (isNegative) {
            binaryRepresentation = "-" + binaryRepresentation;
            if (!powersOfTwoRepresentation.startsWith("Value too small")) {
                powersOfTwoRepresentation = "- (" + powersOfTwoRepresentation + ")";
            }
        }

        System.out.println("Binary equivalent: " + binaryRepresentation);
        System.out.println("As sum of powers of 2: " + powersOfTwoRepresentation);
    }
}
