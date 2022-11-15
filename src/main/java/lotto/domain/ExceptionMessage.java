package lotto.domain;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_IS_NOT_NUMBER("금액을 투입해 주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO("0을 초과한 금액을 투입해 주셔야 합니다."),
    PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS("입력 금액은 1,000원 단위여야 합니다."),
    LOTTO_WRONG_NUMBER_OF_VALUE("6개의 값을 쉼표로 구분해 작성해 주셔야 합니다."),
    LOTTO_OUT_OF_RANGE("1 ~ 45 사이의 값만 입력해 주셔야 합니다."),
    LOTTO_DUPLICATE_VALUE("서로 다른 숫자들을 입력해 주셔야 합니다."),
    BONUS_OUT_OF_RANGE("1 ~ 45 사이의 값을 입력해 주셔야 합니다."),
    BONUS_IS_SEPARATE_CHAR("1 ~ 45 사이의 값을 하나만 입력해 주셔야 합니다."),
    BONUS_DUPLICATE_VALUE("당첨 번호에 없는 번호를 입력해 주셔야 합니다."),
    NUMBER_FORMAT_EXCEPTION("0보다 크고 2,147,483,647 이하의 값을 입력해 주셔야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_TAG + message;
    }

    public String getMessage() {
        return message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
