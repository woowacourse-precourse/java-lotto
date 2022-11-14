package lotto.domain;

public enum Errors {

    LENGTH ("[ERROR] 로또 번호는 6자리 숫자여야 합니다."),
    ONE_BETWEEN_NINE ("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OVERLAP("[ERROR] 로또 번호에 중복된 숫자가 존재합니다."),
    LOTTO_ONLY_NUMBER("[ERROR] 로또 번호는 숫자여야합니다."),
    MONEY_ONLY_NUMBER ("[ERROR] 금액은 숫자여야합니다."),
    CHARGE("[ERROR] 금액은 1000단위로 투입해야합니다.");

    private String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
