package lotto.util;

public enum LottoExceptionMessage {
    PURCHASE_PRICE_UNIT_OF_MONEY("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    PURCHASE_PRICE_IS_NUMBER("[ERROR] 구입 금액은 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 중복되지 않는 숫자 6개여야 합니다."),
    LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
