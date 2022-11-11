package lotto;

public enum ErrorMessage {
    INVALID_MONEY_TYPE("숫자만 입력 가능합니다"),
    INVALID_UNIT_OF_MONEY("1000원 단위로만 입력 가능합니다"),
    INVALID_WINNING_NUMBER_TYPE("로또 번호는 숫자만 입력 가능합니다"),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개까지 입력 가능합니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1~45사이의 숫자만 입력 가능합니다"),
    DUPLICATION_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return getPrefix() + message;
    }

    private String getPrefix() {
        return "[ERROR] ";
    }
}
