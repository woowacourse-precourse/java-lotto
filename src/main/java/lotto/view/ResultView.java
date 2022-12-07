package lotto.view;

import lotto.core.LottoRank;
import lotto.core.LottoResult;
import java.text.DecimalFormat;
import java.util.Map;

public class ResultView {
    private static final DecimalFormat numberFormat = new DecimalFormat("###,###");
    private static final DecimalFormat totalReturnRatioFormat = new DecimalFormat("###,##0.0");

    private final LottoResult lottoResult;

    public ResultView(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void printWinningStats() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printTotalRankingResult();
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

    private void printTotalRankingResult() {
        for (Map.Entry<LottoRank, Integer> rankResult : this.lottoResult.getTotalRankingResult().entrySet()) {
            if (isPrintIncluded(rankResult)) {
                System.out.println(makeTotalRankingResultPrintMessage(rankResult));
            }
        }
    }

    private String makeTotalRankingResultPrintMessage(Map.Entry<LottoRank, Integer> rankResult) {
        LottoRank rank = rankResult.getKey();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rank.winningNumberMatchCount).append("개 일치");
        if (rank.isCorrectBonusNumber) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(numberFormat.format(rank.winningPrize))
                .append("원) - ").append(rankResult.getValue()).append("개");
        return stringBuilder.toString();
    }

    private boolean isPrintIncluded(Map.Entry<LottoRank, Integer> rankResult) {
        return !rankResult.getKey().equals(LottoRank.DRAW);
    }
}
