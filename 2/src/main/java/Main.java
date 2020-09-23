import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input File path: ");
        String inputFilePath = scanner.next();

        System.out.println("Input delimiter: ");
        String inputDelimiter = scanner.next();

        System.out.println("Output File path: ");
        String outputFilePath = scanner.next();

        System.out.println("output delimiter: ");
        String outputDelimiter = scanner.next();

        CSVParser parser = new CSVParser(inputDelimiter, outputDelimiter);
        parser.parseFile(inputFilePath, outputFilePath);
    }
}
