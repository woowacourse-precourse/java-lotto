package lotto.view;

public enum ErrorMessage {
    GET_ERROR_FOR_PRICE("[ERROR] 천원 단위의 금액을 입력하셔야 합니다."),
    GET_ERROR_FOR_INPUT_WINNING_NUMBER("[ERROR] 올바른 형식으로 숫자를 입력해주세요."),
    GET_ERROR_FOR_INPUT_WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 6개를 입력하셔야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
