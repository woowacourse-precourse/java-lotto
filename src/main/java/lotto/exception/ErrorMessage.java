package lotto.exception;

public enum ErrorMessage {
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_NOT_INT("[ERROR] 숫자를 입력해야 합니다."),
    PURCHASE_AMOUNT_NOT_IN_THE_THOUSANDS("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    WINNING_NUMBER_NOT_SEPARATED_BY_COMMA("[ERROR] 당첨번호는 쉼표로 구분되어야 합니다."),
    NUMBERS_SIZE_NOT_SIX("[ERROR] 당첨번호는 6개여야 합니다."),
    BONUS_NOT_ONE("[ERROR] 보너스번호는 숫자 1개여야 합니다."),
    DUPLICATION_EXISTS("[ERROR] 중복된 숫자가 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
