package lotto.constant;

public enum Information {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    PRINT_AMOUNT_OF_LOTTO("\n%d개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\n당첨 통계\n---\n"),
    YIELD("총 수익률은 %.2f%입니다");

    private final String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
