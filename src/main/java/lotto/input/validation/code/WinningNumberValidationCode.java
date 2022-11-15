package lotto.input.validation.code;

public enum WinningNumberValidationCode {
    HAS_MORE_OR_LESS_THAN_SIX_TOKENS("입력된 숫자(또는 단어)가 여섯 개 미만 또는 초과입니다."),
    HAS_ILLEGAL_CHARACTERS("1 ~ 45 사이 외 수를 제외한 어떠한 입력도 허용하지 않습니다."),
    DUPLICATE_NUMBER("당첨 번호는 모두 서로 다른 6개의 숫자여야 합니다"),
    NUMBER_OUT_OF_RANGE("당첨 번호에 허용 범위를 벗어난 수가 포함되어 있습니다. 1 ~ 45 사이의 수만 허용합니다."),
    VALID("올바른 입력입니다.");

    private final String errorMessage;

    WinningNumberValidationCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
