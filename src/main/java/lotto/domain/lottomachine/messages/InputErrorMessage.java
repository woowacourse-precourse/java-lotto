package lotto.domain.lottomachine.messages;

public enum InputErrorMessage {
    PAYMENT("\\d{4,}", "[ERROR] 금액은 네 자리 이상의 숫자로 입력해야 합니다."),
    WINNING_NUMBERS("\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}\\,\\d{1,2}", "[ERROR] 숫자 입력 형식이 맞지 않습니다."),
    BONUS_NUMBER("\\d{1,2}", "[ERROR] 숫자 입력 형식이 맞지 않습니다.");

    private final String regularExpression;
    private final String errorMessage;

    InputErrorMessage(String regularExpression, String errorMessage) {
        this.regularExpression = regularExpression;
        this.errorMessage = errorMessage;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
