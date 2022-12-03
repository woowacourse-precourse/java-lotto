package lotto.error;

public enum Error {
    PRICE_EMPTY_INPUT_ERROR("금액을 입력하세요"),
    NOT_DIGIT_ERROR("금액은 숫자로 입력하세요."),
    DIVIDE_UNIT_ERROR("금액은 1,000원 단위로 입력하세요."),
    AMOUNT_RANGE_ERROR("금액은 100,000원 이하 1000원 이상으로 입력하세요."),
    WINNING_EMPTY_INPUT_ERROR("번호를 입력하세요."),
    INPUT_FORMAT_ERROR("당첨 숫자는 1~45 숫자를 '0,0,0,0,0,0' 형식으로 입력해주세요."),
    BONUS_FORMAT_ERROR("보너스 숫자는 1~45 숫자를 당첨 숫자와 중복되지 않게 입력해주세요");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
