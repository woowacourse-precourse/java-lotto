package lotto;

public enum GameMessage {
    LENGTH_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 로또 번호는 중복되어선 안됩니다."),
    INTEGER_ERROR_MESSAGE("[ERROR] 숫자를 입력해야 합니다."),
    BONUS_ERROR_MESSAGE("[ERROR] 보너스 번호는 1개만 입력해야 합니다."),
    LUCKY_DUPLICATE_ERROR_MESSAGE("[ERROR] 보너스 번호는 당첨 번호 6개와 중복되면 안됩니다."),
    PRICE_ERROR_MESSAGE("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다."),
    PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_MESSAGE("개를 구매했습니다."),
    LUCKY_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTIC_MESSAGE("당첨 통계\n---"),
    WINNING_3_RESULT_MESSAGE("3개 일치 (5,000원) - "),
    WINNING_4_RESULT_MESSAGE("4개 일치 (50,000원) - "),
    WINNING_5_RESULT_MESSAGE("5개 일치 (1,500,000원) - "),
    WINNING_5BONUS_RESULT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_6_RESULT_MESSAGE("6개 일치 (2,000,000,000원) - "),
    PROFIT_HEAD_MESSAGE("총 수익률은 "),
    PROFIT_TAIL_MESSAGE("입니다."),
    COUNT_MESSAGE("개");

    private String Message;

    GameMessage(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
