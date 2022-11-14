package lotto.utils.message;

public enum ErrorMessagesUtil {
    PREFIX("[ERROR] "),
    ONLY_NUMBERS("숫자만 입력할 수 있습니다."),
    NOT_BLANK("공백은 입력할 수 없습니다."),
    NOT_DIVIDE("1,000원으로 나누어 떨어지지 않습니다"),
    NOT_MATCH_NUMBERS_SIZE("번호 입력이 잘못되었습니다."),
    LOWER_MONEY("0원보다 작게 입력할 수 없습니다."),
    LOWER_NUMBER("1보다 낮은 수는 입력할 수 없습니다."),
    UPPER_NUMBER("45보다 높은 수는 입력할 수 없습니다.");


    private final String message;

    ErrorMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }

}
