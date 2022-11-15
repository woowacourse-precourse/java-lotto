package lotto;

public enum ExceptionMessage {
    NOT_NUMBER("제대로된 숫자가 아닙니다."),
    AMOUNT_NOT_DIVIDED("구입금액이 1000으로 나눠 떨어지지 않습니다.");
    //AMOUNT_INVALID("구입금액을 잘못 입력했습니다.");
    final private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
