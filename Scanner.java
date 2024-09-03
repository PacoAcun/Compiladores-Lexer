import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {
    private Token tokens;

    // Define los tipos de tokens
    public static final int ARITH_OP = 1;
    public static final int DIGIT = 2;
    public static final int ID = 3;
    public static final int ALPHA = 4;
    public static final int UNKNOWN = 5;

    public void addToken(int type, String value, int line, int column) {
        Token newToken = new Token(type, value, line, column);
        if (tokens == null) {
            tokens = newToken;
        } else {
            Token current = tokens;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newToken;
        }
    }

    public void scan(String filepath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int lineNum = 1;

            while ((line = reader.readLine()) != null) {
                int columnNum = 1;
                int i = 0;

                while (i < line.length()) {
                    char currentChar = line.charAt(i);

                    if (Character.isDigit(currentChar)) {
                        StringBuilder value = new StringBuilder();
                        int startColumn = columnNum;
                        while (i < line.length() && Character.isDigit(line.charAt(i))) {
                            value.append(line.charAt(i));
                            i++;
                            columnNum++;
                        }
                        addToken(DIGIT, value.toString(), lineNum, startColumn);
                    } else if (Character.isLetter(currentChar)) {
                        StringBuilder value = new StringBuilder();
                        int startColumn = columnNum;
                        while (i < line.length() && Character.isLetterOrDigit(line.charAt(i))) {
                            value.append(line.charAt(i));
                            i++;
                            columnNum++;
                        }
                        addToken(ID, value.toString(), lineNum, startColumn);
                    } else if ("+-*/%".indexOf(currentChar) != -1) {
                        addToken(ARITH_OP, String.valueOf(currentChar), lineNum, columnNum);
                        i++;
                        columnNum++;
                    } else if (Character.isWhitespace(currentChar)) {
                        i++;
                        columnNum++;
                    } else {
                        addToken(UNKNOWN, String.valueOf(currentChar), lineNum, columnNum);
                        i++;
                        columnNum++;
                    }
                }
                lineNum++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Método para obtener la lista de tokens
    public Token getTokens() {
        return tokens;
    }
}
