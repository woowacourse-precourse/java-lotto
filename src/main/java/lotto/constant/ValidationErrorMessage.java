package lotto.constant;

import lotto.domain.constant.LottoProperty;

public enum ValidationErrorMessage {
    EMPTY_VALUE("값을 입력하지 않았습니다."),
    NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_SIZE(LottoProperty.LENGTH.getProperty() + "개의 숫자를 입력해주세요."),
    INVALID_RANGE(LottoProperty.MIN_NUMBER.getProperty() + "부터 "
            + LottoProperty.MAX_NUMBER.getProperty() +"까지의 숫자만 허용됩니다."),
    DUPLICATE_NUMBERS("중복된 숫자가 없도록 입력해주세요."),
    INVALID_MONEY_AMOUNT(LottoProperty.PRICE.getProperty() + "원 단위로 입력해주세요."),
    DUPLICATE_BONUS_NUMBER("보너스 숫자는 당첨 번호와 중복되지 않아야 합니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ValidationErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }

    public String getErrorMessageWithoutPrefix() {
        return errorMessage;
    }
}
