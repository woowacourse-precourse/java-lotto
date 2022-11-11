package lotto.domain.enums;

public enum Message {

    RESULT_FIFTH("3개 일치 (5,000원) - "),
    RESULT_FOURTH("4개 일치 (50,000원) - "),
    RESULT_THIRD("5개 일치 (1,500,000원) - "),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
    NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_THOUSAND_UNIT_INPUT_ERROR("[ERROR] 입력 금액은 1,000원 단위입니다."),
    YIELD_MESSAGE("총 수익률은 %.1d%입니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
