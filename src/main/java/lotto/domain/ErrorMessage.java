package lotto.domain;

public enum ErrorMessage {
    NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    MONEY_ERROR("[ERROR] 1000원 단위를 입력하셔야 합니다."),
    WINNING_NUMBER_ERROR("[ERROR] 6자리의 숫자를 입력하셔야 합니다."),
    DUPLICATION_ERROR("[ERROR] 중복되는 숫자는 입력하실 수 없습니다.");

    private final String Message;

    ErrorMessage(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
