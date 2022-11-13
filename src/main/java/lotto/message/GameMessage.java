package lotto.message;

public enum GameMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NUMBER_OF_PURCHASES("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONNUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNIG_STATISTICS("당첨 통계"),
    LINE("---"),
    FIFTH_OPTION("3개 일치 (5,000원) - "),
    FOURTH_OPTION("4개 일치 (50,000원) - "),
    THIRD_OPTION("5개 일치 (1,500,000원) - "),
    SECOND_OPTION("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_OPTION("6개 일치 (2,000,000,000원) - ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
