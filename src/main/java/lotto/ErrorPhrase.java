package lotto;

public enum ErrorPhrase {
    DUPLICATE("[ERROR] 중복된 숫자가 존재합니다."),
    WRONG_LENGTH("[ERROR] 6자리가 아닙니다."),
    WRONG_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_INPUT("[ERROR] 잘못된 입력입니다."),
    WRONG_PAY("[ERROR] 잘못된 금액입니다.");

    private final String phrase;

    ErrorPhrase(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return phrase;
    }
}
