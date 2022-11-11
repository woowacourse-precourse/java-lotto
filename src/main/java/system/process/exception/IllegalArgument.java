package system.process.exception;

import constants.LottoConstant;

public enum IllegalArgument {

    // TODO : 구역 나누는 방법을 알아내야겠다..

    // Number
    NOT_SET_SIZE(String.format("%d개의 숫자가 아닙니다.", LottoConstant.NUMBERS_SIZE)),
    NOT_IN_RANGE(String.format("숫자 중, %d~%d의 범위가 아닌 숫자가 있습니다.",LottoConstant.NUMBER_START,LottoConstant.NUMBER_END)),
    DUPLICATION("중복된 값이 존재합니다."),

    // Input
    NOT_DIGIT_OR_COMMA_TEXT("숫자나 쉼표로 이루어진 입력이 아닙니다."),
    NOT_DIGIT_TEXT("올바른 금액을 입력해주세요."),
    NOT_DIVISION("금액에 맞춰 로또를 구매할 수 없습니다."),
    WRONG_COMMA("잘못된 위치에 쉼표가 존재합니다.");



    private final String message;

    IllegalArgument(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }

    public static void handleException(String message) {
        throw new IllegalArgumentException(message);
    }




}
