package lotto;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 구입금액은 숫자여야 합니다."),
    DIVIDE_DISABLE("[ERROR] 천원 단위가 아닙니다."),
    NOT_ENOUGH_NUM("[ERROR] 6개의 번호가 필요합니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
