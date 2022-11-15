package lotto;

public enum ErrorMessage {
    NUMBER_DUPLICATED("[ERROR] 번호에 중복된 숫자는 들어갈 수 없습니다."),
    NUMBER_COUNT_OVER_SIX("[ERROR] 숫자는 여섯개여야 합니다."),
    INPUT_IS_NOT_INTEGER("[ERROR] 입력은 정수만 가능합니다."),
    MONEY_CANNOT_DIVIDE_BY_THOUSAND("[ERROR] 입력 금액이 1000원으로 나누어 떨어지지 않습니다."),
    BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
