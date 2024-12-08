import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        BigInteger first = scanner.nextBigInteger();
        System.out.print("Second number: ");
        BigInteger second = scanner.nextBigInteger();
        System.out.print("Third number: ");
        BigInteger third = scanner.nextBigInteger();

        System.out.print("Max value: ");
        BigInteger maxValue = scanner.nextBigInteger();

        String fileName = "fibonacci_numbers.txt";

        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write(first + "\n");
            writer.write(second + "\n");

            BigInteger a = first;
            BigInteger b = second;
            BigInteger c = third;

            long period = 0;
            BigInteger previous = BigInteger.valueOf(-1);

            while (c.compareTo(maxValue) <= 0) {
                BigInteger next = a.multiply(b).multiply(c);
                writer.write(next + "\n");
                a = b;
                b = c;
                c = next;

                if (next.equals(first) && previous.equals(second)) {
                    period++;
                    break;
                }

                if (next.equals(first) && previous.equals(BigInteger.valueOf(-1))) {
                    previous = first;
                    period++;
                } else if (next.equals(second) && previous.equals(first)) {
                    previous = second;
                    period++;
                } else if (next.equals(third) && previous.equals(second)) {
                    previous = third;
                    period++;
                } else {
                    previous = BigInteger.valueOf(-1);
                    period = 0;
                }
            }

            writer.close();
            System.out.println("Writen to " + fileName);
            System.out.println("Period: " + period);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
