package lotto;

public enum ErrorMessage {
    FORM("[ERROR] 올바른 형식으로 입력해야 합니다."),
    SIZE("[ERROR] 알맞은 개수의 숫자를 입력해야 합니다."),
    RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DIVIDE("[ERROR] 입력된 값이 1,000으로 나누어 떨어지지 않습니다."),
    DUPLICATE("[ERROR] 중복된 번호가 존재합니다."),
    INTEGER("[ERROR] 입력된 값이 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
