package common.message;

public enum Message {

    TOTAL_FUND("구입금액을 입력해 주세요."),
    COUNTING_BUY("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    TOTAL_START("당첨 통계"),
    EA("개"),
    TOTAL_RESULT_A("총 수익률은 "),
    TOTAL_RESULT_B("%입니다."),
    CONTOUR("---"),
    THREE_GAMES("3개 일치 (5,000원) - "),
    FOUR_GAMES("4개 일치 (50,000원) - "),
    FIVE_GAMES("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_GAMES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_GAMES("6개 일치 (2,000,000,000원) - ");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return value;
    }

}
