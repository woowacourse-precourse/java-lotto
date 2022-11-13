package lotto;

public enum ExceptionMessage {
    WRONG_PAYMENT("[ERROR] 구입 금은 1,000원 단위여야 합니다."),
    WRONG_NUM("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_BONUS("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_NUM_LIST("[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
