package lotto;

public enum ErrorMessage {
    DESIRED_AMOUNT_ERROR("구입 금액은 1,000원 단위로 입력하여야 합니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개의 숫자여야 입니다."),
    PARSING_NUMBER_ERROR("숫자를 입력해야 합니다."),
    NUMERIC_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_ERROR("당첨 번호는 서로 다른 숫자여야 합니다.")
    ;

    private String message;
    ErrorMessage(String message){
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
