package lotto.domain;

public enum ErrorMessage {
    MONEY_IS_NOT_NUMBER("[ERROR] 구입 금액은 양수인 숫자여야 합니다."),
    MONEY_IS_ZERO("[ERROR] 구입 금액은 0보다 커야 합니다."),
    MONEY_IS_NOT_1000_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    MONEY_IS_NOT_ENTERED("[ERROR] 금액을 입력해주세요."),

    LOTTO_NUMBER_IS_NOT_VALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_IS_NOT_SIX_NUMBERS("[ERROR] 당첨 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATED("[ERROR] 로또 번호는 중복될 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}