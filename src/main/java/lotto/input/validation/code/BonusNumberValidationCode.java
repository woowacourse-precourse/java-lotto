package lotto.input.validation.code;

public enum BonusNumberValidationCode {
    INVALID_FORMAT("입력된 값이 올바른 보너스 숫자 형식이 아닙니다"),
    NUMBER_OUT_OF_RANGE("보너스 숫자로 허용되는 값은 1과 45 사이의 수입니다"),
    DUPLICATE_EXIST_IN_WINNING_NUMBERS("같은 값이 이미 당첨 번호 중에 존재합니다."),
    VALID("올바른 입력입니다.");

    private final String errorMessage;

    BonusNumberValidationCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
