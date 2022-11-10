package lotto.global;

public enum Message {

    GAME_INPUT("구입금액을 입력해 주세요."),
    GAME_ISSUE("개를 구매했습니다."),

    ERROR_INPUT("[ERROR] 구입 금액은 1,000으로 나누어 떨어지는 숫자여야 합니다."),
    ERROR_LOTTO("[ERROR] 로또 번호는 1에서 45 사이의 6개의 중복되지 않는 숫자여야 합니다.");

    private final String message;

    Message(String s) {
        this.message = s;
    }

    public void print() {
        System.out.println(message);
    }

    public String getMessage() {
        return name();
    }
}
