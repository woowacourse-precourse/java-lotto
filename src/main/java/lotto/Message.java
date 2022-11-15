package lotto;

public enum Message {
    VALID_INPUT_PRICE("[ERROR] 잘못된 형식의 금액을 입력하셨습니다.");

    private final String message;

    public String getMessage() {
        return message;
    }

    Message(String message) {
        this.message = message;
    }
}
