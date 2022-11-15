package lotto.input.validation.code;

public enum TotalPriceValidationCode {
    INVALID_NUMBER_FORMAT("숫자 외 문자를 포함해서는 안 되며, 첫 번째 숫자가 0이 되어서는 안 됩니다."),
    INVALID_NUMBER("구입 금액은 1000의 배수가 되는 수여야 합니다"),
    VALID_NUMBER("올바른 입력입니다.");

    private final String errorMessage;

    TotalPriceValidationCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
