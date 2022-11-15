package OutputView;

public enum PrintComment {

    PURCHASED_MESSAGE("구입금액을 입력해 주세요."),
    LottoCount_MESSAGE("개를 구매했습니다."),
    EARNING_HEADER_MESSAGE("총 수익률은 "),
    EARNING_TAIL_MESSAGE("%입니다."),
    WINNING_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private final String msg;

    PrintComment(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
