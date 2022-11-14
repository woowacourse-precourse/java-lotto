package lotto.constants;

public enum Output {
    PURCHASE_INPUT("구입금액을 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    TOTAL_RETURN_START("총 수익률은 "),
    TOTAL_RETURN_END("입니다.");

    private final String msg;

    private Output(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
