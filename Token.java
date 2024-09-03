public class Token {
    int type;
    String value;
    int line;
    int column;
    Token next;

    // Constructor
    public Token(int type, String value, int line, int column) {
        this.type = type;
        this.value = value;
        this.line = line;
        this.column = column;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Token(type=" + type + ", value=\"" + value + "\", line=" + line + ", column=" + column + ")";
    }
}


