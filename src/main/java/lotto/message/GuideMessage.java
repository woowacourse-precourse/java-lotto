package lotto.message;

public enum GuideMessage {

    MONEY_INPUT_MESSAGE("구매금액을 입력해 주세요."),

    BUY_LOTTO_MESSAGE("개를 구매했습니다."),

    PICK_WINNER_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),

    PICK_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.")
    ;

    private final String guideMessage;

    GuideMessage(String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getGuideMessage() {
        return guideMessage;
    }
}
