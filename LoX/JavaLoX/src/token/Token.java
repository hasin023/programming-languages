package token;

public class Token {
    public final TokenType tokenType;
    public String lexeme;
    public Object literal;
    public final int line;

    public Token(TokenType type, String lexeme, int line) {
        this.tokenType = type;
        this.lexeme = lexeme;
        this.literal = null;
        this.line = line;
    }

    public Token(TokenType tokenType, String lexeme, Object literal, int line) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        return tokenType + " " + lexeme + " " + literal;
    }

    public void concat(Token token) {
        if (token == null) {
            return;
        }

        this.lexeme += token.lexeme;
    }
}
