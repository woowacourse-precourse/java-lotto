package lotto.utils;

public enum ErrorCode {
    // 로또 금액 관련 오류
    INVALID_PRICE("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다."),

    // 로또 번호 관련 오류
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않는 숫자들로만 이루어져야 합니다."),
    INVALID_TYPE_LOTTO_NUMBER("[ERROR] 로또 번호는 ,로 구분된 6개의 숫자로만 입력하여 주십시오."),

    // 보너스 번호 관련 오류
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다."),
    NOT_INT_TYPE("[ERROR] 숫자로만 입력하여 주십시오.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}