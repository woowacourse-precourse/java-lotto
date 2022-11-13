package lotto.constant;

import lotto.domain.constant.LottoProperty;

public enum ValidationErrorMessage {
    INVALID_SIZE(LottoProperty.LENGTH.getProperty() + "개의 숫자를 입력해주세요."),
    INVALID_RANGE(LottoProperty.MIN_NUMBER.getProperty() + "부터 "
            + LottoProperty.MAX_NUMBER.getProperty() +"까지의 숫자만 허용됩니다."),
    DUPLICATE_NUMBERS("중복된 숫자가 없도록 입력해주세요.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ValidationErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }
}
