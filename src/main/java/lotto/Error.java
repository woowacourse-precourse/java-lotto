package lotto;

public enum Error {
    ERROR_MESSAGE("[ERROR]"),
    WRONG_MONEY_UNIT(ERROR_MESSAGE.message +" 로또 구입 금액은 1000원 단위여야 합니다."),
    WRONG_MONEY_TYPE(ERROR_MESSAGE.message + " 로또 구입 금액은 숫자로만 이루어져야 합니다."),
    OVER_NUMBER_COUNT(ERROR_MESSAGE.message + " 로또 번호의 개수는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER(ERROR_MESSAGE.message + " 로또의 번호에 중복된 숫자가 있습니다");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
