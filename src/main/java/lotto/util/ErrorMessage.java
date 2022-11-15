package lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_TYPE("1000 이상의 숫자만 입력 가능합니다"),
    INVALID_UNIT_OF_MONEY("1000원 단위로만 입력 가능합니다"),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호 개수는 6개이어야 합니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1~45사이의 숫자만 입력 가능합니다"),
    INVALID_PREFIX_ZERO("유효하지 않는 0값이 들어있습니다"),
    INVALID_NUMBER_OF_LOTTO("로또 개수는 1개 이상이어야 합니다"),
    DUPLICATION_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다");

    private final String message;

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
