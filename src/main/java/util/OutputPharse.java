package util;

public enum OutputPharse {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONNUS_LOTTO("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---"),
    TOTOAL_PROFIT("총 수익률은 ");

    private final String msg;

    OutputPharse(String msg) {
        this.msg = msg;
    }
}
