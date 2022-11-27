package lotto.messages;

public enum UI_MSG {

    INPUT_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE("\n%d개를 구매했습니다."),
    OUTPUT_STATISTICS("\n당첨 통계\n---"),
    OUTPUT_YIELD("총 수익률은 %.1f%%입니다.");

    private final String msg;

    UI_MSG(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
