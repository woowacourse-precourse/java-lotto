package lotto.domain.winning;

public class WinningStatistics {

    private final LottoResults lottoResults;
    private final LottoTickets lottoTickets;

    public WinningStatistics(LottoTickets lottoTickets, LottoResults lottoResults) {
        this.lottoTickets = lottoTickets;
        this.lottoResults = lottoResults;
    }

    public double rateOfReturn() {
        int totalPayment = lottoTickets.totalPayment();
        long totalWinnings = lottoResults.totalWinnings();
        double rate = (double) totalWinnings / totalPayment * 100;

        return (double) Math.round(rate * 10) / 10;
    }
}
