package lotto;

import java.util.List;

import static lotto.Results.DEFAULT;

public class LottoNumbers {

    private static final int MATCH_COUNT = 5;

    private final List<Lotto> lottoNumbers;

    public LottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int compareResult(LottoWinningNumber lottoWinningNumber, Results totalLottoRankingCount) {
        int totalAmount = DEFAULT;
        for (Lotto number : lottoNumbers) {
            int lottoNumberMatchCount = lottoWinningNumber.compareLottoNumbers(number);
            Ranking ranking = Ranking.findRanking(lottoNumberMatchCount,
                    isBonusNumber(lottoWinningNumber, lottoNumberMatchCount));
            totalLottoRankingCount.addPrizeCount(ranking);
            totalAmount += ranking.getPrizeMoney();
        }
        return totalAmount;
    }

    private boolean isBonusNumber(LottoWinningNumber lottoWinningNumber, int lottoNumberMatchCount) {
        if (lottoNumberMatchCount == MATCH_COUNT) {
            return lottoWinningNumber.findBonusNumber();
        }
        return false;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

}
