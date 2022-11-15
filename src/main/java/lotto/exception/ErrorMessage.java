package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("[ERROR] 숫자가 아님"),
    NOT_DIVIDED("[ERROR] 1000으로 나누어 떨어지지 않음"),
    SMALL_NUMBER("[ERROR] 숫자가 1000보다 작음"),
    NOT_LOTTO_SIZE("[ERROR] 로또 번호 개수가 6이 아님"),
    DUPLICATED_NUMBER("[ERROR] 로또 번호가 중복됨"),
    NOT_LOTTO_NUMBER("[ERROR] 로또 번호(1~45)가 아님");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}