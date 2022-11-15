package lotto.messages;

public enum ErrorMessage {
    PREFIX_ERROR_MESSAGE("[ERROR]"),
    MONEY_INPUT_ERROR_MESSAGE(PREFIX_ERROR_MESSAGE
            + "구입 금액은 천원 단위의 숫자여야 합니다."),
    DRAW_NUMBER_INPUT_ERROR_MESSAGE(PREFIX_ERROR_MESSAGE
            + "당첨 번호는 1부터 45사이의 6개로 구성된 숫자여야 합니다."),
    BONUS_NUMBER_INPUT_ERROR_MESSAGE(PREFIX_ERROR_MESSAGE
            + "보너스 번호는 1부터 45사이의 숫자 중 6개의 당첨 번호를 제외한 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}