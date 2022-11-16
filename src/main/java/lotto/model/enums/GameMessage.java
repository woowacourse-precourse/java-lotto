package lotto.model.enums;

public enum GameMessage {
    PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_MESSAGE("개를 구매했습니다."),
    SIX_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTIC_MESSAGE("당첨 통계\n---"),
    WINNING_3_RESULT_MESSAGE("3개 일치 (5,000원) - "),
    WINNING_4_RESULT_MESSAGE("4개 일치 (50,000원) - "),
    WINNING_5_RESULT_MESSAGE("5개 일치 (1,500,000원) - "),
    WINNING_5BONUS_RESULT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_6_RESULT_MESSAGE("6개 일치 (2,000,000,000원) - "),
    PROFIT_HEAD_MESSAGE("총 수익률은 "),
    PROFIT_TAIL_MESSAGE("%입니다."),
    COUNT_MESSAGE("개");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getMessage() {
        return gameMessage;
    }
}
