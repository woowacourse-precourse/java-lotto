package lotto.global;

public enum ExceptionCode {
    NUM_ERROR("[ERROR] 숫자만 입력 해야 합니다."),
    NOT_CORRECT_INPUT("[ERROR] 올바르지 않은 입력입니다."),
    MUST_DIVIDE_UNIT_PRICE("[ERROR] 0이 아니고 1000으로 나누어 떨어지는 숫자만 입력해야 합니다."),
    NOT_CORRECT_VOLUME("[ERROR] 구매한 수량이 일치하지 않습니다."),
    NOT_CORRECT_BONUS_NUM_RANGE("[ERROR] 보너스번호의 범위는 0보다 크고 46보다 작은 숫자입니다."),
    NOT_CORRECT_BONUS_NUM("[ERROR] 보너스번호는 당첨번호와 일치하지 않아야 합니다.");

    private final String message;
    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
