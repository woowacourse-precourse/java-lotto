package lotto.exception;

import static lotto.utils.constant.Messages.*;

public enum Exception {
    NOT_NUMBER(ERROR + "숫자(정수)만 입력해주세요."),
    WRONG_PURCHASE_COST(ERROR + "로또는 한개에 1000원입니다. 1000원 단위로 입력해주세요."),
    WRONG_COUNT(ERROR + "6개의 번호를 입력해주세요."),
    OUT_OF_RANGE(ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE(ERROR + "로또 번호는 중복되지 않는 숫자여야 합니다."),
    WRONG_DELIMITER(ERROR + "당첨 번호는 쉼표로 구분되어야 합니다."),
    BONUS_DUPLICATE(ERROR + "보너스 번호는 당첨 번호와 중복되면 안됩니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
