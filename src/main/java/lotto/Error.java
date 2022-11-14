package lotto;

public enum Error {
    INVALID_WINNING_INPUT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_INPUT("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_MONEY_INPUT("[ERROR] 구입 금액은 1000원 단위로 입력 받습니다."),
    REDUPLICATION_INPUT("[ERROR] 당첨 번호에 중복이 있습니다."),
    INVALID_TYPE("[ERROR] 숫자만 입력받습니다."),
    INVALID_INPUT("[ERROR] 잘못된 입력입니다."),
    REDUPLICATION_LOTTO("[ERROR] 로또 번호에 중복이 있습니다.")


    ;

    public String getMessage() {
        return message;
    }

    private final String message;

    Error(String message) {
        this.message = message;
    }
}
