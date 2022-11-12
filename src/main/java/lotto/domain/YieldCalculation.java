package lotto.domain;

import lotto.input.LottoTickets;

public class YieldCalculation {

    private static final int PERCENT = 100;

    public double revenue(int totalPrizePool) {
        LottoTickets lottoTickets = new LottoTickets();
        int paid = lottoTickets.getPrice();

        return (((double) totalPrizePool / paid) * PERCENT);
    }
}
