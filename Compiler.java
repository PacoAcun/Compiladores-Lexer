import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Compiler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        scanner.scan("input.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            Token current = scanner.getTokens();
            while (current != null) {
                writer.write(current.toString());
                writer.newLine();
                current = current.next;
            }
            System.out.println("Tokens written to output.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

