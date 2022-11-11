package system.process.exception;

import constants.LottoConstant;

public enum IllegalArgument {

    // TODO : 구역 나누는 방법을 알아내야겠다..

    // Number
    NOT_SET_SIZE(String.format("숫자의 개수가 %d개가 아닙니다.", LottoConstant.NUMBERS_SIZE)),
    NOT_IN_RANGE(String.format("숫자 중, %d~%d의 범위를 벗어난 숫자가 있습니다.", LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)),
    DUPLICATION("중복된 값이 존재합니다."),

    // Input
    NOT_DIGIT_OR_COMMA_TEXT("숫자나 쉼표로 이루어진 입력이 아닙니다."),
    NOT_DIGIT_TEXT("올바른 금액을 입력해주세요."),
    NOT_DIVISION("입력한 금액에 맞춰 로또를 구매할 수 없습니다."),
    WRONG_NUMBERS_INPUT("올바르게 숫자를 입력해주세요.");

    private final String message;

    IllegalArgument(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }

    public static void handleException(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }
}
