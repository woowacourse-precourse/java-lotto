package lotto.constant;

public enum ErrorMessage {
    EMPTY_VALUE("값을 입력하지 않았습니다."),
    MISSING_VALUE("입력된 요소 중 비어있는 값이 있습니다."),
    NOT_NUMBER("숫자만 입력해주세요."),
    INVALID_SIZE(LottoProperty.LENGTH.getProperty() + "개의 숫자를 입력해주세요."),
    INVALID_RANGE(LottoProperty.MIN_NUMBER.getProperty() + "부터 "
            + LottoProperty.MAX_NUMBER.getProperty() +"까지의 숫자만 허용됩니다."),
    DUPLICATE_NUMBERS("중복된 숫자가 없도록 입력해주세요."),
    INVALID_MONEY_AMOUNT(LottoProperty.PRICE.getProperty() + "원 단위로 입력해주세요."),
    DUPLICATE_BONUS_NUMBER("보너스 숫자는 당첨 번호와 중복되지 않아야 합니다."),
    INVALID_TICKET("해당 티켓은 판매된 티켓이 아닙니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }

    public String getErrorMessageWithoutPrefix() {
        return errorMessage;
    }
}
