package lotto.exception;

import lotto.player.Player;

public class LottoException extends IllegalArgumentException {

    private static final String FIRST_ERROR = "[ERROR] ";
    private static final String INPUT_ERROR = "정상적인 값을 입력해주세요.";
    private static final String UNEXPECTED_ERROR = "예상치 못한 에러가 발생하였습니다.";
    private final Class c;
    private String errorMsg = FIRST_ERROR;

    public LottoException(Class c) {
        this.c = c;
        createErrorMsg();
        throw new IllegalArgumentException(errorMsg);
    }


    private void createErrorMsg() {
        if (c == Player.class) {
            errorMsg += INPUT_ERROR;
            return;
        }
        errorMsg += UNEXPECTED_ERROR;
    }
}
