package lotto.Utils;

public enum Message {
    NUMBER("[ERROR] 숫자만 입력해주세요"),
    AMOUNT("[ERROR] 1,000원 단위로 입력해 주세요."),
    DUPLICATED("[ERROR] 중복되지 않은 숫자를 입력해 주세요"),
    RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}