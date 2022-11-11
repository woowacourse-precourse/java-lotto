package lotto.domain.enums;

public enum Message {

    RESULT_FIFTH("3개 일치 (5,000원) - "),
    RESULT_FOURTH("4개 일치 (50,000원) - "),
    RESULT_THIRD("5개 일치 (1,500,000원) - "),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_FIRST("6개 일치 (2,000,000,000원) - "),
    NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_THOUSAND_UNIT_INPUT_ERROR("[ERROR] 입력 금액은 1,000원 단위입니다."),
    BONUS_NUMBER_INPUT_ERROR("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 1~9 사이의 하나의 숫자입니다."),
    WINNING_NUMBER_INPUT_ERROR("1부터 45 사이의 수를 중복되지 않게 쉼표(,)를 이용하여 입력해주세요.\n예) 1,2,3,4,5,6"),
    YIELD_MESSAGE("총 수익률은 %.1d%입니다.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
