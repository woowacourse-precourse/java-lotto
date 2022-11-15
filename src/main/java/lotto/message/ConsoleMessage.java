package lotto.message;

public enum ConsoleMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATISTICS_HEADER("당첨 통계\n---"),
    OUTPUT_WINNING_STATISTICS_WITHOUT_BONUS("개 일치 ("),
    OUTPUT_WINNING_STATISTICS_WITH_BONUS("개 일치, 보너스 볼 일치 ("),
    OUTPUT_WINNING_STATISTICS_AFTER_PRIZE("원) - "),
    OUTPUT_WINNING_STATISTICS_AFTER_COUNT("개"),
    OUTPUT_PROFIT_RATE_BEFORE_RATE("총 수익률은 "),
    OUTPUT_PROFIT_RATE_AFTER_RATE("%입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
