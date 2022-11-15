package exception;

public class DuplicateInputException extends IllegalArgumentException {
    public DuplicateInputException() {
        super("[ERROR] Input contains duplicating numbers");
    }
}
