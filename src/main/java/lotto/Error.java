package lotto;

public enum Error {
    INPUT_NOTHING("[ERROR] 아무것도 입력되지 않았습니다."),
    INPUT_BLANK("[ERROR] 아무것도 입력되지 않았습니다."),
    INPUT_WITH_BLACK("[ERROR] 빈칸이 입력되었습니다."),
    INPUT_NOT_NUMERIC("[ERROR] 숫자만 입력 가능합니다."),
    LESS_THAN_1000WON("[ERROR] 1000원 이상부터 구매 가능합니다."),
    NOT_DIVIDED_1000WON("[ERROR] 1000원 단위로만 구매 가능합니다."),
    NOT_SIX_NUMBERS("[ERROR] 당첨 번호는 6개를 입력해야만 합니다."),
    DUPLICATED_NUMBERS("[ERROR] 수가 중복됩니다."),
    SEPARATOR("[ERROR] 구분자는 콤마만 가능합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 번호는 1 ~ 45 사이의 수만 가능합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호에 존재하지 않는 수만 가능합니다.")
    ;

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
