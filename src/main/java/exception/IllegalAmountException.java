package exception;

public class IllegalAmountException extends IllegalArgumentException{
    public IllegalAmountException() {
        super("[ERROR] Input amount is not divisible by 1000");
    }
}
