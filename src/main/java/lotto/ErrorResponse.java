package lotto;

public enum ErrorResponse {
    INPUT_LOTTO_RANGE_ERROR("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_BUYING_RANGE_ERROR("[Error] 1000으로 나누어지는 단위의 구입 금액을 입력해야 합니다."),
    INPUT_WITHOUT_COMMA_ERROR("[Error] 당첨번호는 쉽표(,)로 구분하여 입력해야 합니다."),
    NOT_IN_WINNING_PLACE("[Error] 일치하는 등수에 존재하지 않습니다.")
    ;

    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
