package exception;

public class InputParsingException extends IllegalArgumentException{
    public InputParsingException() {
        super("[ERROR] cannot parse string to integer");
    }
}
