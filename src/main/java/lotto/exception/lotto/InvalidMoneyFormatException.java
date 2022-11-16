package lotto.exception.lotto;

public class InvalidMoneyFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요. : %s";

    public InvalidMoneyFormatException(String input){
        super(String.format(ERROR_MESSAGE,input));
    }
}
