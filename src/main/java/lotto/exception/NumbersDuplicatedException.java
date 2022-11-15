package lotto.exception;

public class NumbersDuplicatedException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 중복된 숫자가 존재합니다.";

    public NumbersDuplicatedException(){
        super(MESSAGE);
    }
}
