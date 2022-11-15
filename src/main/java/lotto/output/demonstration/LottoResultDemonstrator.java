package lotto.output.demonstration;

import lotto.data.LottoResult;

public class LottoResultDemonstrator {
    private static final String HEADING = "당첨 통계";
    private static final String BREAK_LINE = "---";
    private static final String PROFIT_RATE_PHRASE_HEAD = "총 수익률은 ";
    private static final String PROFIT_RATE_PHRASE_TAIL = "%입니다.";

    public void printLottoResult(LottoResult lottoResult) {
        printHeading();
        printBreakLine();
        System.out.println(lottoResult);
    }

    private void printHeading() {
        System.out.println(HEADING);
    }

    private void printBreakLine() {
        System.out.println(BREAK_LINE);
    }

    public void printProfitRate(double profitRate) {
        System.out.println(PROFIT_RATE_PHRASE_HEAD + profitRate + PROFIT_RATE_PHRASE_TAIL);
    }
}
