package lotto.util;

public enum LottoExceptionMessage {
    PURCHASE_PRICE_UNIT_OF_MONEY("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    PURCHASE_PRICE_IS_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다.");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
