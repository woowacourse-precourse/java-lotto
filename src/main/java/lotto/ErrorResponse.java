package lotto;

public enum ErrorResponse {
    INPUT_LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_WRONG_SIZE_ERROR("[ERROR] 로또 당첨 번호느 6개의 수여야 합니다."),
    INPUT_BUYING_RANGE_ERROR("[ERROR] 1000으로 나누어지는 단위의 구입 금액을 입력해야 합니다."),
    INPUT_WITHOUT_COMMA_ERROR("[ERROR] 당첨번호는 쉽표(,)로 구분하여 입력해야 합니다."),
    INPUT_CONTAINS_CHAR_ERROR("[ERROR] 입력은 문자를 포함할 수 없습니다."),
    INPUT_BONUS_NUMBER_EXISTS("[ERROR] 입력한 보너스 번호가 이미 당첨 번호에 포함되어 있습니다.")
    ;

    private String errorMessage;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
