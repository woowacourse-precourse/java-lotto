package lotto.ui;

import lotto.util.LogLevel;

public enum ErrorMessage {

    NOT_NUMERIC("입력값이 숫자가 아닙니다."),
    INVALID_INPUT_PRICE("구입 금액 입력값이 올바르지 않습니다."),
    INVALID_INPUT_WINNING_NUMBERS("당첨 번호 입력값이 올바르지 않습니다."),
    NOT_RANGE_OF_1_TO_45("당첨 번호 입력값이 올바르지 않습니다."),
    INVALID_INPUT_BONUS_NUMBERS("로또 번호의 숫자 범위는 1~45까지입니다."),
    INVALID_SIZE("로또 자리수는 6자리 입니다."),
    LOTTO_DUPLICATION("각 로또 번호는 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toMessage(LogLevel level) {
        return level.getLevel() + message;
    }
}
