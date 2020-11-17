import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Input File directory: ");
        String inputDirectory = scanner.next();

        System.out.println("Input delimiter: ");
        String inputDelimiter = scanner.next();

        System.out.println("Output File path: ");
        String outputFilePath = scanner.next();

        System.out.println("output delimiter: ");
        String outputDelimiter = scanner.next();

        System.out.println("num of workers: ");
        int numOfWorkers = scanner.nextInt();*/

        String inputDirectory = "testdata/2";
        String inputDelimiter = ",";
        String outputFilePath = "test.txt";
        String outputDelimiter = "+";

        int numOfWorkers = 2;

        CSVController controller = new CSVController(inputDelimiter, outputDelimiter, numOfWorkers);
        controller.parseDirectory(inputDirectory, outputFilePath);
    }
}
