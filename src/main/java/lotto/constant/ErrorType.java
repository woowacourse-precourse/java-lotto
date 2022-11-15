package lotto.constant;

public enum ErrorType {

    NUMBER_TYPE_ERROR("숫자를 입력해야 합니다."),
    NOT_POSITIVE_NUMBER_ERROR("구입금액은 양수여야 합니다."),
    PURCHASE_AMOUNT_UNIT_ERROR("구입금액은 1,000원 단위여야 합니다."),
    LOTTO_NUMBERS_COUNT_STANDARD_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATION_ERROR("로또 번호에 중복된 번호가 존재합니다."),
    BONUS_NUMBER_DUPLICATION_ERROR("보너스 번호가 당첨 번호와 중복된 번호가 존재합니다."),
    ;

    private final String message;

    ErrorType(String message) {
        this.message = Prefix.MESSAGE + message;
    }

    public String getMessage() {
        return message;
    }

    private static class Prefix {
        private static final String MESSAGE = "[ERROR] ";
    }
}