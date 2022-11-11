package lotto.message;

public enum GuideMessage {

    MONEY_INPUT_MESSAGE("구매금액을 입력해 주세요."),
    ;

    private final String guideMessage;

    GuideMessage(String guideMessage) {
        this.guideMessage = guideMessage;
    }

    public String getGuideMessage() {
        return guideMessage;
    }
}
