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
    RESULT_A("개 일치"),
    BRACKET_LEFT("("),
    BRACKET_RIGHT(")"),
    WON("원"),
    SLASH(" - ");

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
