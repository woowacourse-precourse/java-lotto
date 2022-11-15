package lotto.exception;

public class MyException extends IllegalArgumentException{

    public MyException(ErrorMessage errorMessage) {
        throw new IllegalArgumentException(errorMessage.getMessage());
    }
}
