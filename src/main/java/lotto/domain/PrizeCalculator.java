package lotto.domain;

import java.util.List;

public class PrizeCalculator {
    public int getPrize(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .map(lottoRank -> lottoRank.getPrize())
                .mapToInt(Integer::intValue).sum();
    }

    public double getROI(int prize, int fee) {
        return (double) prize / (double) fee;
    }
}
