package lotto.exception.winningnumber;

public class WinningNumberDuplicatedNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_DUPLICATED_NUMBER = "[ERROR] 중복된 복권번호가 있습니다.";

    public WinningNumberDuplicatedNumberException(){
        super(EXCEPTION_MESSAGE_DUPLICATED_NUMBER);
    }
}
