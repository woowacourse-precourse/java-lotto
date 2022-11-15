package lotto.enums;

import java.util.List;

public enum Message {

    ERROR_NOT_NUMBER("[ERROR] 숫자로 입력받아야 합니다."),
    ERROR_NOT_THOUSAND_DIVIDE("[ERROR] 구매 금액이 1000원 단위여야 합니다."),

    ERROR_NUMBER_SIZE("[ERROR] 6개의 숫자를 입력해야 합니다."),
    ERROR_DUPLICATE_NUMBER("[ERROR] 중복된 번호를 사용하지 않아야 합니다."),
    ERROR_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호가 당첨 번호와 겹치지 않아야 합니다"),

    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    TICKET_RESULT("\n당첨 통계\n---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
