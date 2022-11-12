package enumCollections;

public enum Messages {
    PURCHASE_INPUT("구매금액을 입력해 주세요."),
    NUMBER_OF_PURCHASE("개를 구매했습니다."),
    WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public static String getMessage(String situation) {
        return Messages.valueOf(situation).message;
    }
}
