package lotto.exception;

public class MyException extends IllegalArgumentException{

    public MyException(ErrorMessage errorMessage) {
        System.out.println(errorMessage.getMessage());
        throw new IllegalArgumentException(errorMessage.getMessage());
    }
}
