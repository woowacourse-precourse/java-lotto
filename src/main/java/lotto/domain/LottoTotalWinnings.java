package lotto.domain;

import lotto.model.LottoBuyer;
import lotto.model.LottoResults;

public class LottoTotalWinnings {
    public void getTotalWinnings(LottoBuyer lottoBuyer) {
        long totalWinnings = calculateTotalWinnings(lottoBuyer.getLottoResults());
        lottoBuyer.setTotalWinnings(totalWinnings);
    }

    private long calculateTotalWinnings(LottoResults lottoResults) {
        return (5_000L * lottoResults.getLottoPrizeCount("FIFTH_PLACE")) +
                (50_000L * lottoResults.getLottoPrizeCount("FOURTH_PLACE")) +
                (1_500_000L * lottoResults.getLottoPrizeCount("THIRD_PLACE")) +
                (30_000_000L * lottoResults.getLottoPrizeCount("SECOND_PLACE")) +
                (2_000_000_000L * lottoResults.getLottoPrizeCount("FIRST_PLACE"));
    }

}
