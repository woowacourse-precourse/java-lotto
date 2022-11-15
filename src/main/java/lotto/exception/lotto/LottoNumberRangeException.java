package lotto.exception.lotto;

public class LottoNumberRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 45보다 크거나 1보다 작을수 없습니다. : %d";

    public LottoNumberRangeException(int number) {
        super(String.format(ERROR_MESSAGE, number));
    }
}
