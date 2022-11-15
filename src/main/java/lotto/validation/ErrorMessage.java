package lotto.validation;

public enum ErrorMessage {
    INPUT_PURCHASE_PRICE_IN_INTEGERS("구입금액은 숫자로만 입력해야 합니다."),
    PURCHASE_PRICE_DIVIDED_BY_THOUSAND("구입금액은 1000으로 나누어떨어져야 합니다."),
    QUANTITY_OF_DIGITS_SIX("번호의 개수는 6개여야 합니다."),
    NO_DUPLICATE_NUMBERS("중복된 번호는 입력할 수 없습니다."),
    NUMBERS_RANGE_BETWEEN_ONE_AND_FOURTYFIVE("번호의 범위는 1이상 45이하여야 합니다."),
    INPUT_PREDICTION_NUMBERS_IN_COMMA_AND_INTEGERS("쉼표를 기준으로 구분된 숫자만을 입력해 주세요."),
    INPUT_BONUS_NUMBER_IN_INTEGER("숫자를 입력해 주세요."),
    NO_DUPLICATION_WITH_PREDICTION_NUMBERS("예측 번호와 중복되는 번호를 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        String prefix = "[ERROR] ";
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
