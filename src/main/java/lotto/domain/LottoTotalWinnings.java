package lotto.domain;

import lotto.utils.LottoRanking;
import lotto.model.LottoBuyer;
import lotto.model.LottoResults;

public class LottoTotalWinnings {
    public void getTotalWinnings(LottoBuyer lottoBuyer) {
        long totalWinnings = calculateTotalWinnings(lottoBuyer.getLottoResults());
        lottoBuyer.setTotalWinnings(totalWinnings);
    }

    private long calculateTotalWinnings(LottoResults lottoResults) {
        int totalWinnings = 0;

        for (LottoRanking rank : LottoRanking.values()) {
            totalWinnings += rank.getWinnings() * lottoResults.getLottoPrizeCount(rank.toString());
        }

        return totalWinnings;
    }
}
