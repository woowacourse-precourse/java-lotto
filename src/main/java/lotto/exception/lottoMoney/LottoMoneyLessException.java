package lotto.exception.lottoMoney;

public class LottoMoneyLessException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다. : %d";

    public LottoMoneyLessException(int value) {
        super(String.format(ERROR_MESSAGE, value));
    }
}