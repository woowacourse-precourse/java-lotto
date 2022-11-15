package lotto.domain;

import lotto.LottoRank;

import java.util.List;

public class LottoEstimator {
    private final static int MIN_MATCH_NUMBERS = 3;
    private final static int LOTTO_PRICE_UNIT = 1000;

    private final WinningLotto winningLotto;
    private LottoStatics lottoStatics;

    public LottoEstimator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoStatics estimate(List<Lotto> lotteries) {
        lottoStatics = new LottoStatics();
        lotteries.forEach(this::rankLotto);
        lottoStatics.calculateProfitRate(lotteries.size() * LOTTO_PRICE_UNIT);

        return lottoStatics;
    }

    private void rankLotto(Lotto lotto) {
        int matchCount = winningLotto.getMatchCountWith(lotto);
        boolean hasBonusNumber = winningLotto.isBonusNumberIn(lotto);

        if (matchCount < MIN_MATCH_NUMBERS) {
            return;
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.matchLottoRank(matchCount, hasBonusNumber)) {
                lottoStatics.win(lottoRank);
                return;
            }
        }
    }
}
