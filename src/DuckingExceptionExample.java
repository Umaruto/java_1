//public class DuckingExceptionExample {
//    // Method that may throw ArithmeticException
//    public static int divide(int a, int b) throws ArithmeticException {
//        return a / b; // This will throw ArithmeticException if b = 0
//    }
//
//    public static void main(String[] args) {
//        try {
//            System.out.println(divide(10, 0)); // Throws exception
//        } catch (ArithmeticException e) {
//            System.out.println("Exception caught in main: " + e.getMessage());
//        }
//    }
//}
import java.io.*;

public class DuckingExceptionExample {
    // Method declares it may throw IOException
    public static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt");
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
        br.close();
    }

    public static void main(String[] args) {
        try {
            readFile(); // Calls method that throws exception
        } catch (IOException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
    }
}
