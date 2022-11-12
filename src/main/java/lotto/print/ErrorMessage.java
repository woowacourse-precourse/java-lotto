package lotto.print;


import java.util.Arrays;


public enum ErrorMessage {
    BASIC_MESSAGE("basic", "[ERROR]"),
    INPUT_OVER("InputOverException", " 로또 입력 개수가 초과하였습니다."),
    NUMBER_VERIFICATION("NumberCheckException", " 숫자가 아닌 문자를 입력하였습니다."),
    OVERLAPS_NUMBER("OverlapsNumberException", " 중복된 숫자를 입력하였습니다."),
    SCOPE_OVER("ScopeOverException", " 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    THOUSAND_UNIT_VERIFICATION("ThousandUnitCheckException", " 입력한 금액은 1000원 단위가 아닙니다."),
    EMPTY("none", "없음");

    private final String error;
    private final String message;

    ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }

    static ErrorMessage find(String error) {
        return Arrays.stream(values())
                .filter(ErrorMessage -> ErrorMessage.error.equals(error))
                .findAny()
                .orElse(EMPTY);
    }//find

    static String sendMessage(Object obj) {
        String error = obj.getClass().getSimpleName();
        return BASIC_MESSAGE.message + find(error).message;
    }// sendMessage
}// end enum