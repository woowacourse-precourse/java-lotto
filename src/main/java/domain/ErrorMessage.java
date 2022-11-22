package domain;

public enum ErrorMessage {
    NOT_NUMBER_ERROR("[ERROR] 숫자를 입력하여 주십시오"),
    NOT_ENOUGH_MONEY_ERROR("[ERROR] 1,000원 단위로 입력하여 주십시오"),
    NOT_LOTTO_DISTINCT_NUMBER_ERROR("[ERROR] 중복 번호를 기입하지 마십시오."),
    NOT_LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1 ~ 45 범위로 입력하여 주십시오."),
    NOT_LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개 입니다."),
    NOT_WINNING_LOTTO_INPUT_STYLE_ERROR("[ERROR] 형식에 맞게 당첨 번호를 입력하여 주십시오."),
    NOT_BONUS_SAME_WINNING_LOTTO_ERROR("[ERROR] 당첨번호에 기입된 값입니다. 다시 입력하어주십시오.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
