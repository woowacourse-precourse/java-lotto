package lotto.enums;

public enum OutputMessage {
    OUTPUT_ENTER_MONEY("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_SUCCESS("%d개를 구매했습니다."),
    OUTPUT_ENTER_LOTTO_ANSWER("당첨 번호를 입력해 주세요."),
    OUTPUT_ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_RESULTS_TITLE("당첨 통계"),
    OUTPUT_LINE("---"),
    OUTPUT_WINNING_RESULTS_DESCRIPTION("%s - %d개"),
    OUTPUT_PROFIT_PERCENT_IS("총 수익률은 %.1f%%입니다.");

    private String output;

    public String getOutput() {
        return output;
    }

    OutputMessage(String output) {
        this.output = output;
    }

    public String purchaseSuccess(int count) {
        return String.format(OUTPUT_PURCHASE_SUCCESS.getOutput(), count);
    }

    public String winningResultsDescription(String description, int count) {
        return String.format(OUTPUT_WINNING_RESULTS_DESCRIPTION.getOutput(), description, count);
    }

    public String profitPercent(double profit) {
        return String.format(OUTPUT_PROFIT_PERCENT_IS.getOutput(), profit);
    }

}
