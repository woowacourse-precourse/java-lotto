package lotto.message;

public enum ErrorMessage {
    MONEY_NOT_A_NUMBER("[ERROR] 구입금액은 숫자여야 합니다."),
    MORE_THAN_THOUSAND("[ERROR] 구입금액은 1000부터 입니다."),
    DIVIDE_DISABLE("[ERROR] 천원 단위가 아닙니다."),
    NOT_ENOUGH_NUM("[ERROR] 6개의 번호가 필요합니다."),
    WINNING_NUM_NOT_A_NUMBER("[ERROR] 당첨 번호는 숫자여야 합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 번호는 1부터 45사이의 숫자여야 합니다."),
    BONUS_NUM_NOT_A_NUMBER("[ERROR] 보너스 번호는 숫자여야 합니다."),
    WINNING_NUM_CONTAINS_BONUS_NUM("[ERROR] 당첨 번호 중에 보너스 번호가 존재합니다"),
    DUPLICATE_EXIST("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");


    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
