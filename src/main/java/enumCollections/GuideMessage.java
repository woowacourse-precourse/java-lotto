package enumCollections;

public enum GuideMessage {
    PURCHASE_INPUT("구매금액을 입력해 주세요."),
    NUMBER_OF_PURCHASE("%d개를 구매했습니다."),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요.");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public static String getMessage(GuideMessage situation) {
        return situation.message;
    }
}
