package system.process.exception;

import constants.LottoConstant;

public enum IllegalArgument {
    // Number
    NOT_SET_SIZE(String.format("숫자의 개수가 %d개가 아닙니다.", LottoConstant.NUMBERS_SIZE)),
    NOT_IN_RANGE(String.format("숫자 중, %d~%d의 범위를 벗어난 숫자가 있습니다.", LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)),
    DUPLICATION("중복된 값이 존재합니다."),

    // Input
    NOT_DIGIT_OR_COMMA_TEXT("올바른 입력이 아닙니다."),
    NOT_DIGIT_TEXT("쉼표 없이 금액을 입력해주세요."),
    NOT_DIVISION("입력한 금액에 맞춰 로또를 구매할 수 없습니다."),
    WRONG_NUMBERS_INPUT("슷자 6개와 쉼표 5개를 번갈아가며 입력해주세요."),
    EMPTY_INPUT("아무것도 입력하지 않았습니다.");

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
