package lotto.enums;

public enum Error {
    ZERO_MONEY_ERROR("[ERROR] 구입 금액은 최소 1000원이어야 합니다."),
    PAY_MONEY_ERROR("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    ONLY_NUMBER_ERROR("[ERROR] 숫자만 입력해야 합니다."),
    DUPLICATE_ERROR("[ERROR] 로또 번호는 중복된 숫자가 있어선 안 됩니다."),
    INVALID_FORMAT("[ERROR] 정해진 형식이 아닙니다. 숫자와 콤마로만 입력해 주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
