package message;

public enum ErrorMessage {
    MORE_THAN_SIX_LOTTO("[ERROR] 로또 번호의 개수는 6개가 넘으면 안됩니다."),
    DUPLICATED_LOTTO("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ABOVE_ELEMENT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    MORE_MONEY("[ERROR] 값을 잘못 입력하였습니다."),
    INCORRECT_MONEY_UNIT("[ERROR] 1000원 단위로 입력해야 합니다."),

    USER_INPUT_ERROR("[ERROR] 당첨번호는 쉼표를 기준으로 구분해야 합니다."),
    INPUT_COUNT_ERROR("[ERROR] 당첨번호는 6개를 입력해야 합니다."),

    INVALID_NUMBER("[ERROR] 잘못된 숫자입니다.");


    private String status;

    ErrorMessage(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
