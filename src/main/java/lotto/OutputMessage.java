package lotto;

public enum OutputMessage {

    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BUY_LOTTE_MESSAGE("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER_MESSAGE ("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WIN_A_LOTTERY_STATUS("당첨 통계"),
    CATCH_THREE_NUMBER("3개 일치 (5,000원) - "),
    CATCH_FOUR_NUMBER("4개 일치 (50,000원) - "),
    CATCH_FIVE_NUMBER("5개 일치 (1,500,000원) - "),
    CATCH_FIVE_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (300,000,000원) - "),
    CONGRATULATIONS("6개 일치 (2,000,000,000원) - "),
    SEPARATION("---"),
    CATCH_NUMBER_BACK("개"),
    USER_RETURN_FRONT("총 수익률은"),
    USER_RETURN_BACK("입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
