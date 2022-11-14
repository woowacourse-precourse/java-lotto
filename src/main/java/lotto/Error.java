package lotto;

public enum Error {
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_NUMBER("[ERROR] 숫자여야 합니다."),
    NOT_DISTINCT("[ERROR] 숫자가 중복이면 안됩니다."),
    NOT_VALIDATE_MONEY_UNIT("[ERROR] 금액 단위가 잘못 됐습니다."),
    NOT_VALIDATE_LENGTH("[ERROR] 길이가 잘못됐습니다."),
    WORNG_INPUT("[ERROR] 잘못된 입력값입니다."),
    IS_CONTAIN_BONUS_TO_LOTTO("[ERROR] 입력하신 당첨 로또에 포함된 값입니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}