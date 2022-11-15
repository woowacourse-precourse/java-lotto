package lotto.utils;

public enum ExceptionMessage {
    NOT_NUMBER("제대로된 숫자가 아닙니다."), AMOUNT_NOT_DIVIDED("구입금액이 1000으로 나눠 떨어지지 않습니다."), LOTTO_NOT_VALID(
            "로또 번호가 유효하지 않습니다."), BONUS_NOT_VALID("보너스 번호가 유효하지 않습니다.");
    final private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
