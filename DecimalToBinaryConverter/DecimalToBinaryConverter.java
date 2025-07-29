import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class DecimalToBinaryConverter {

    public String convertToBinary(double number, int precision) {
        boolean isNegative = number < 0;
        number = Math.abs(number);

        BigDecimal decimalNumber = BigDecimal.valueOf(number);
        BigDecimal integerPart = decimalNumber.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal fractionalPart = decimalNumber.subtract(integerPart);

        Stack<Integer> integerStack = new Stack<>();
        BigDecimal two = BigDecimal.valueOf(2);

        if (integerPart.compareTo(BigDecimal.ZERO) == 0) {
            integerStack.push(0);
        } else {
            while (integerPart.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal[] divmod = integerPart.divideAndRemainder(two);
                integerStack.push(divmod[1].intValue());
                integerPart = divmod[0];
            }
        }

        StringBuilder binaryIntegerPart = new StringBuilder();
        while (!integerStack.isEmpty()) {
            binaryIntegerPart.append(integerStack.pop());
        }

        StringBuilder binaryFractionalPart = new StringBuilder();
        if (precision > 0) {
            binaryFractionalPart.append(".");
            for (int i = 0; i < precision; i++) {
                fractionalPart = fractionalPart.multiply(two);
                int bit = fractionalPart.intValue();
                binaryFractionalPart.append(bit);
                fractionalPart = fractionalPart.subtract(BigDecimal.valueOf(bit));
            }
        }

        return (isNegative ? "-" : "") + binaryIntegerPart + binaryFractionalPart;
    }

    public String binaryAsPowersOfTwo(double number, int precision) {
        boolean isNegative = number < 0;
        number = Math.abs(number);

        StringBuilder powersOfTwo = new StringBuilder();

        BigDecimal decimalNumber = BigDecimal.valueOf(number);
        BigDecimal integerPart = decimalNumber.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal fractionalPart = decimalNumber.subtract(integerPart);

        Stack<String> integerPowers = new Stack<>();
        BigDecimal two = BigDecimal.valueOf(2);
        int power = 0;

        while (integerPart.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal[] divmod = integerPart.divideAndRemainder(two);
            if (divmod[1].intValue() == 1) {
                integerPowers.push("1 * 2^" + power);
            }
            integerPart = divmod[0];
            power++;
        }

        while (!integerPowers.isEmpty()) {
            powersOfTwo.append(integerPowers.pop()).append(" + ");
        }

        power = -1;
        MathContext mc = new MathContext(30);
        for (int i = 0; i < precision; i++) {
            fractionalPart = fractionalPart.multiply(two, mc);
            int bit = fractionalPart.intValue();
            if (bit == 1) {
                powersOfTwo.append("1 * 2^(" ).append(power).append(") + ");
            }
            fractionalPart = fractionalPart.subtract(BigDecimal.valueOf(bit), mc);
            power--;
        }

        if (powersOfTwo.length() > 3) {
            powersOfTwo.setLength(powersOfTwo.length() - 3);
        }

        return isNegative ? "- (" + powersOfTwo + ")" : powersOfTwo.toString();
    }
} 
