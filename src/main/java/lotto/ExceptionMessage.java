package lotto;

public enum ExceptionMessage {

    PURCHASE_AMOUNT_IS_NOT_NUMBER("[ERROR] 금액을 투입해주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO("[ERROR] 0을 초과한 금액을 투입해 주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS("[ERROR] 입력 금액은 1,000원 단위여야 합니다."),
    LOTTO_WRONG_NUMBER_OF_VALUE("[ERROR] 6개의 값을 쉼표로 구분해 작성해 주셔야 합니다."),
    LOTTO_OUT_OF_RANGE("[ERROR] 1 ~ 45 사이의 값만 입력해 주셔야 합니다."),
    LOTTO_DUPLICATE_VALUE("[ERROR] 서로 다른 숫자들을 입력해 주셔야 합니다."),
    BONUS_OUT_OF_RANGE("[ERROR] 1 ~ 45 사이의 값만 입력해 주셔야 합니다."),
    BONUS_DUPLICATE_VALUE("[ERROR] 당첨 번호에 없는 번호를 입력해 주셔야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
