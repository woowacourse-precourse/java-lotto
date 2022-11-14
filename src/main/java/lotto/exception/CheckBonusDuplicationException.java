package lotto.exception;

public class CheckBonusDuplicationException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 보너스숫자는 로또번호와 중복되지 않아야 합니다.";
    public CheckBonusDuplicationException(){
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
