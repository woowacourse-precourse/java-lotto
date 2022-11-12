package lotto.domain.winning;

import java.util.StringJoiner;

public class WinningStatistics {

    private final LottoResults lottoResults;
    private final PurchasedLottoTickets purchasedLottoTickets;
    private double rateOfReturn;

    public WinningStatistics(PurchasedLottoTickets purchasedLottoTickets,
            LottoResults lottoResults) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        this.lottoResults = lottoResults;
        calculateRateOfReturn();
    }

    private void calculateRateOfReturn() {
        rateOfReturn = rateOfReturn(
                purchasedLottoTickets.totalPayment(),
                lottoResults.totalWinnings()
        );
    }

    private double rateOfReturn(double totalPayment, int totalWinnings) {
        double rate = (double) totalWinnings / totalPayment * 100;
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
