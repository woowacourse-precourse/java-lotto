package lotto.domain.winning;

public class WinningStatistics {

    private final LottoResults lottoResults;
    private final PurchasedLottoTickets purchasedLottoTickets;

    public WinningStatistics(PurchasedLottoTickets purchasedLottoTickets,
            LottoResults lottoResults) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        this.lottoResults = lottoResults;
    }

    public double rateOfReturn() {
        int totalPayment = purchasedLottoTickets.totalPayment();
        long totalWinnings = lottoResults.totalWinnings();
        double rate = (double) totalWinnings / totalPayment * 100;

        return (double) Math.round(rate * 10) / 10;
    }
}
