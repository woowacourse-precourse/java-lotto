package lotto;

public enum ErrorMessage {
    PRICE("[ERROR] 1000으로 나누어 떨어지는 양의 정수로 입력하세요."),
    LOTTO("[ERROR] 1 ~ 45 범위의 서로 다른 6개의 숫자를 입력하세요. (ex) 13, 14, 16, 38, 42, 45");

    String message;
    private ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
