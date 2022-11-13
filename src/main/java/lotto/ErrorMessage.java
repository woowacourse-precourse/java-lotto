package lotto;

public enum ErrorMessage {
    MONEY_NOT_A_NUMBER("[ERROR] 구입금액은 숫자여야 합니다."),
    DIVIDE_DISABLE("[ERROR] 천원 단위가 아닙니다."),
    NOT_ENOUGH_NUM("[ERROR] 6개의 번호가 필요합니다."),
    WINNING_NUM_NOT_A_NUMBER("[ERROR] 당첨 번호는 숫자여야 합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
