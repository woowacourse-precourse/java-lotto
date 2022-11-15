package exception;

public class OutOfRangeInputException extends IllegalArgumentException {
    public OutOfRangeInputException() {
        super("[ERROR] Input is out of range");
    }
}
