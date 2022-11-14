package lotto;

public enum ErrorType {

    MONEY("입력 금액이 유효하지 않습니다."),

    WINNING_NUMBER("당첨 번호가 유효하지 않습니다."),

    BONUS_NUMBER("보너스 번호가 유효하지 않습니다.");


    private static final String ERROR_FORMAT = "[ERROR]";
    private final String message;

    ErrorType(String message) {
        this.message = ERROR_FORMAT + message;
    }

    public String getMessage() {
        return message;
    }
}
