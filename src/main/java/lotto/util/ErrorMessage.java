package lotto.util;

public enum ErrorMessage {
    NOT_A_NUMBER("[ERROR] 숫자가 아닙니다."),
    WRONG_UNIT("[ERROR] 1000원 단위가 아닙니다."),
    NO_SIX_NUMBER("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NO_ONE_NUMBER("[ERROR] 보너스 번호는 1개의 숫자여야 합니다."),
    OUT_OF_RANGE("[ERROR] 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("[ERROR] 중복된 숫자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String printMessage() {
        return message;
    }
}
