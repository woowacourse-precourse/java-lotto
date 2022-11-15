package lotto.model.vallidator;

import lotto.model.Constants;

public enum MoneyError {
    PREFIX("[ERROR] "),
    MONEY_POSITIVE(PREFIX.message() + "구매 금액은 양수여야 합니다."),
    MONEY_MOD(PREFIX.message() +
            String.format("구매 금액은 가격(%d)으로 나누어 떨어져야 합니다.", Constants.LOTTO_PRICE))
    ;
    private final String message;
    MoneyError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
