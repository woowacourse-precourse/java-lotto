package lotto.exception.winningnumber;

public class WinningNumberRangeException extends IllegalArgumentException{
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";

    public WinningNumberRangeException(int lottoLowerNumber, int lottoUpperNumber) {
        super(String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE, lottoLowerNumber, lottoUpperNumber));
    }
}
