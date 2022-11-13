package lotto.error;

public enum ErrorType {
    PREFIX("[ERROR] "),
    NOT_BLANK("공백은 입력할 수 없습니다."),
    ONLY_NUMBERS("숫자만 입력할 수 있습니다."),
    NOT_DIVIDE("1,000원으로 나누어 떨어지지 않습니다"),
    LOWER_MONEY("0원보다 작게 입력할 수 없습니다.");


    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    /*public String getMessage() {

    }*/

    public String showMessage() {
        return PREFIX.message + this.message;
    }

}
