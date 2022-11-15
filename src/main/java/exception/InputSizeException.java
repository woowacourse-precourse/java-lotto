package exception;

public class InputSizeException extends IllegalArgumentException{
    public InputSizeException() {
        super("[ERROR] Input size is larger than 6");
    }
}
