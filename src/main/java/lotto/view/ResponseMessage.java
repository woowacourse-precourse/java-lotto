package lotto.view;

public enum ResponseMessage {
    MONEY_INPUT("구입금액을 입력해 주세요."),
    QUANTITY("개를 구매했습니다."),
    WINNING_NUM_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_NUM_INPUT("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n----"),
    RATE_OF_RETURN_PREFIX("총 수익률은 "),
    RATE_OF_RETURN_SUFFIX("%입니다.");


    private final String msg;

    ResponseMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
