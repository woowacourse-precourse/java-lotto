package lotto.constant;

public enum LottoInfo {
    INPUT_WINNING_NUM_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUM_MESSAGE("보너스 번호를 입력해 주세요."),
    INPUT_BUY_MESSAGE("구매금액을 입력해 주세요."),
    STATISTIC_MESSAGE("\n당첨 통계\n---");

    private final String message;

    LottoInfo(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
