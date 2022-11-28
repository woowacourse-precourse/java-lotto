package lotto.messages;

public enum UI_MSG {

    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE("\n%d개를 구매했습니다."),
    OUTPUT_STATISTICS("\n당첨 통계\n---"),
    OUTPUT_YIELD("총 수익률은 %,.1f%%입니다."),

    RANK5("3개 일치 (5,000원) - "),
    RANK4("4개 일치 (50,000원) - "),
    RANK3("5개 일치 (1,500,000원) - "),
    RANK2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1("6개 일치 (2,000,000,000원) - ");

    private final String msg;

    UI_MSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
