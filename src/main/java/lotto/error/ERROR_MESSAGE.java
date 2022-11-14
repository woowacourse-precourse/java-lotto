package lotto.error;

public enum ERROR_MESSAGE {
    NOT_INTEGER_MONEY("[ERROR] 구입금액은 숫자여야 합니다."),
    NOT_MATCH_UNIT_MONEY("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
    NOT_LENGTH_OF_NUMBERS("[ERROR] 로또 번호는 6개여야 합니다."),
    NOT_RANGE_OF_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATION_OF_NUMBERS("[ERROR] 로또 번호는 중복이 없어야 합니다."),
    NOT_INTEGER_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    NOT_RANGE_OF_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATION_OF_BONUS_NUMBER("[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다.");

    private final String message;

    ERROR_MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
