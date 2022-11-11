package lotto.domain.winning;

import java.util.StringJoiner;

public class WinningStatistics {

    private final LottoResults lottoResults;
    private final LottoPurchaser lottoPurchaser;
    private double rateOfReturn;

    public WinningStatistics(LottoPurchaser lottoPurchaser, LottoResults lottoResults) {
        this.lottoPurchaser = lottoPurchaser;
        this.lottoResults = lottoResults;
        calculateRateOfReturn();
    }

    private void calculateRateOfReturn() {
        rateOfReturn = rateOfReturn(
                lottoPurchaser.totalPricesOfPurchase(),
                lottoResults.totalWinnings()
        );
    }

    private double rateOfReturn(double totalPrice, int totalWinnings) {
        double rate = (double) totalWinnings / totalPrice * 100;
        return (double) Math.round(rate * 10) / 10;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner
                .add("당첨 통계")
                .add("---")
                .add(lottoResults.toString())
                .add("총 수익률은 " + rateOfReturn + "%입니다.");

        return stringJoiner.toString();
    }
}
