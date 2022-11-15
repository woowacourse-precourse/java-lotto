package lotto.exception.lotto;

public class InvalidFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다. : %s";

    public InvalidFormatException(String input){
        super(String.format(ERROR_MESSAGE,input));
    }
}
