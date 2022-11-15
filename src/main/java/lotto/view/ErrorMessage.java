package lotto.view;

public enum ErrorMessage {
    GET_ERROR_FOR_PRICE("[ERROR] 천원 단위의 금액을 입력하셔야 합니다."),
    GET_ERROR_FOR_INPUT_WINNING_NUMBER("[ERROR] 당첨 번호는 콤마(,) 구분으로 입력하셔야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
