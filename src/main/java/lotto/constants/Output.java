package lotto.constants;

public enum Output {
    PURCHASE_AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_OUTPUT("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_Statistics("당첨 통계\n---"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String msg;

    Output(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
