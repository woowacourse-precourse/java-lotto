package lotto.message;

public enum GuideMessage {

    MONEY_INPUT_MESSAGE("구매금액을 입력해 주세요."),

    BUY_LOTTO_MESSAGE("개를 구매했습니다."),

    PICK_WINNER_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),

    PICK_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    RESULT_GUIDE_TEXT_MESSAGE("당첨 통계"),

    RESULT_GUIDE_LINE_MESSAGE("---"),

    FIFTH_PRIZE_MESSAGE("3개 일치 (5,000원) - "),

    FOURTH_PRIZE_MESSAGE("4개 일치 (50,000원) - "),

    THIRD_PRIZE_MESSAGE("5개 일치 (1,500,000원) - "),

    SECOND_PRIZE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    FIRST_PRIZE_MESSAGE("6개 일치 (2,000,000,000원) - "),

    PRIZE_UNIT("개"),

    PROFIT_RATE_PREFIX_MESSAGE("총 수익률은 "),
    PROFIT_RATE_SUFFIX_MESSAGE("%입니다.");

    private final String guideMessage;

    GuideMessage(String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getGuideMessage() {
        return guideMessage;
    }
}
