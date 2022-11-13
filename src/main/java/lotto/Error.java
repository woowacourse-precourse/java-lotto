package lotto;

public enum Error {
    OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_QUANTITY("[ERROR] 로또 번호는 6개입니다."),
    WRONG_INPUT("[ERROR] 로또 번호는 서로 다른 6개입니다."),

    WRONG_AMOUNT("[ERROR] 로또 한 장의 가격은 1000원입니다.");
    private final String message;

    Error(String s) {
        this.message = s;
    }

    public String message() {
        return message;
    }
}
