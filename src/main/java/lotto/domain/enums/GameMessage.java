package lotto.domain.enums;

public enum GameMessage {
    PROMPT_MESSAGE("구입금액을 입력해 주세요."),
    BUY_MESSAGE("개를 구매했습니다."),
    PICK_MESSAGE("당첨번호를 입력해 주세요."),
    PICK_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    RESULT_MESSAGE("당첨 통계\n---"),
    PRIZE_5_MESSAGE("3개 일치 (5,000원) - "),
    PRIZE_4_MESSAGE("4개 일치 (50,000원) - "),
    PRIZE_3_MESSAGE("5개 일치 (1,500,000원) - "),
    PRIZE_2_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRIZE_1_MESSAGE("6개 일치 (2,000,000,000원) - "),
    PROFIT_PROMPT_MESSAGE("총 수익률은 "),
    PROFIT_TOTAL_MESSAGE("%입니다.");


    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameMessage() {
        return gameMessage;
    }
}
