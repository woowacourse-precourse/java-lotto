package lotto.Domain;

public class IllegalArgument {
    public IllegalArgumentException withMessage(String message) {
        return new IllegalArgumentException(message);
    }
}
