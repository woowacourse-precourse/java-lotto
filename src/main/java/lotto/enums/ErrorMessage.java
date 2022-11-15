package lotto.enums;

public enum ErrorMessage {
    NUM_ERROR("[ERROR] 숫자만 입력해주세요."),
    LEN_ERROR("[ERROR] 6개의 숫자를 입력해주세요."),
    RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR("[ERROR] 중복 없이 입력해주세요."),
    COMMA_ERROR("[ERROR] 숫자는 콤마로 구분해서 넣어주세요. (띄어 쓰기X)"),
    PRICE_ERROR("[ERROR] 금액은 1000원 단위로 입력해주세요."),
    BONUS_DUPLICATE_ERROR("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");


    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
