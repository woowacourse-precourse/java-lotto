package lotto.domain;

public enum Error {

    ERROR_WRONG_SIZE("[ERROR] 번호의 개수가 맞지 않습니다."),
    ERROR_WRONG_MONEY("[ERROR] 금액이 잘못되었습니다."),
    ERROR_OVERLAP_NUMBER("[ERROR] 중복되는 번호가 있습니다."),
    ERROR_WRONG_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_WRONG_INPUT("[ERROR] 입력 방식이 잘못되었습니다.");

    private final String message;

    Error(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
