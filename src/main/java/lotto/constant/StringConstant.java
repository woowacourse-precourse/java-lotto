package lotto.constant;

public enum StringConstant {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    MONEY_INPUT_NOT_INTEGER_ERROR_MESSAGE("[ERROR] 로또 번호는 정수 값이어야 합니다."),
    MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE("[ERROR] 로또 가격의 배수를 입력해야 합니다.")
    ;


    private final String message;

    StringConstant(String message) {
        this.message = message;
    }

    StringConstant(String message, int result) {
        this.message = String.valueOf(result) + message;
    }
    public String getMessage() {
        return message;
    }
}
