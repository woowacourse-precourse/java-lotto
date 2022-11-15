package lotto.exception.lottoMoney;

public class LottoMoneyDivideException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 구입 금액은 1000 단위여야 합니다. : %d";

    public LottoMoneyDivideException(int value) {
        super(String.format(ERROR_MESSAGE, value));
    }
}
