package lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_TYPE("0 이상의 숫자만 입력 가능합니다"),
    INVALID_UNIT_OF_MONEY("1000원 단위로만 입력 가능합니다"),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개까지 입력 가능합니다"),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1~45사이의 숫자만 입력 가능합니다"),
    MONEY_IS_ZERO("구입 금액이 0원이므로 게임을 종료합니다"),
    INVALID_NUMBER_OF_LOTTO("로또 개수는 1개 이상이어야 합니다"),
    DUPLICATION_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

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
