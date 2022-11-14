package lotto;

public enum ErrorMessage {
    PRICE("[ERROR] 1000으로 나누어 떨어지는 양의 정수로 입력하세요.");

    String message;
    private ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
