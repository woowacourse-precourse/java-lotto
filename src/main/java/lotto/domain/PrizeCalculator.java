package lotto.domain;

import java.util.List;

public class PrizeCalculator {
    public int calculate(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .map(lottoRank -> lottoRank.getPrize())
                .mapToInt(Integer::intValue).sum();
    }
}
