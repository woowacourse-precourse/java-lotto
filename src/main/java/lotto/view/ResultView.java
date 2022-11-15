package lotto.view;

import lotto.LottoRank;
import lotto.LottoResult;
import java.text.DecimalFormat;
import java.util.Map;

public class ResultView {
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private static final DecimalFormat totalReturnRatioFormat = new DecimalFormat("###,###.0");

    private final LottoResult lottoResult;

    public ResultView(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printWinningStats() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printRankResult();
        printTotalReturnRatio();
    }

    private void printTotalReturnRatio() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("총 수익률은 ")
                .append(totalReturnRatioFormat.format(this.lottoResult.getTotalReturnRatio()))
                .append("%입니다.");
        System.out.println(stringBuilder.toString());
    }

    private void printRankResult() {
        for (Map.Entry<LottoRank, Integer> result : this.lottoResult.getRankResult().entrySet()) {
            if (isPrintExclusive(result)) {
                System.out.println(makeRankResultPrintMessage(result));
            }
        }
    }

    private String makeRankResultPrintMessage(Map.Entry<LottoRank, Integer> result) {
        LottoRank rank = result.getKey();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rank.correctWinningNumber).append("개 일치");
        if (rank.isCorrectBonusNumber) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(numberFormat.format(rank.winningPrize))
                .append("원) - ").append(result.getValue()).append("개");
        return stringBuilder.toString();
    }

    private boolean isPrintExclusive(Map.Entry<LottoRank, Integer> result) {
        return !result.getKey().equals(LottoRank.DRAW);
    }
}
