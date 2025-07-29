import java.util.Scanner;

public class DecimalToBinaryController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalToBinaryConverter converter = new DecimalToBinaryConverter();

        System.out.println("Enter a double number:");
        double number = scanner.nextDouble();

        System.out.println("Enter the precision for the decimal part:");
        int precision = scanner.nextInt();

        // Δυαδική Αναπαράσταση
        String binaryRepresentation = converter.convertToBinary(number, precision);

        // Αναπαράσταση ως Άθροισμα Δυνάμεων του 2
        String powersOfTwoRepresentation = converter.binaryAsPowersOfTwo(number, precision);

        // Εμφάνιση Αποτελεσμάτων
        System.out.println("==============================");
        System.out.println("Binary Representation:");
        System.out.println(binaryRepresentation);
        System.out.println("------------------------------");
        System.out.println("Representation as Sum of Powers of 2:");
        System.out.println(powersOfTwoRepresentation);
        System.out.println("==============================");
    }
} 
