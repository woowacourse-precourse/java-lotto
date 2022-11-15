package lotto.exception;

public enum ViewExceptionMessage {
    INPUT_DIGIT_EXCEPTION("[ERROR] 입력값이 숫자로 인식되지 않아 오류가 발생하였습니다."),
    INPUT_WIN_NUMBER_COMMA("[ERROR] 입력한 당첨 번호를 인식할 수 있는 콤마(,)에서 오류가 발생하였습니다."),
    INPUT_WIN_NUMBER_COUNT("[ERROR] 입력한 당첨 번호 개수가 충분하지 않아 오류가 발생하였습니다.");


    private final String message;

    ViewExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
