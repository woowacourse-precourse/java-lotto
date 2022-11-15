package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class LottoService {

    public static final Boolean BONUS_NUMBER_HIT = true;
    public static final Boolean BONUS_NUMBER_MISS = false;
    public static final int PERCENT = 100;
    public static final double DEFAULT_RATIO = 10.0;

    public void calculateLottoRanks(User user, WinningLotto winningLotto) {
        for (Lotto purchasedLotto : user.getLottos()) {
            LottoRank lottoRank = calculateLottoRank(purchasedLotto, winningLotto);
            user.getLottoRanks().add(lottoRank);
        }
    }

    public double calculateProfit(User user) {
        List<LottoRank> lottoRanks = user.getLottoRanks();

        long sumOfPrizeMoney = lottoRanks.stream()
                .mapToLong(LottoRank::getPrizeMoney)
                .sum();
        int purchaseAmount = user.getPurchaseCount() * Lotto.LOTTO_UNIT;
        double profit = (double) sumOfPrizeMoney / purchaseAmount * PERCENT;

        return Math.round(profit * DEFAULT_RATIO) / DEFAULT_RATIO;
    }

    private LottoRank calculateLottoRank(Lotto purchasedLotto, WinningLotto winningLotto) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int matchCount = (int) purchasedLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        Integer bonusNumber = winningLotto.getBonusNumber();
        if (purchasedLottoNumbers.contains(bonusNumber)) {
            return LottoRank.getLottoRank(matchCount, BONUS_NUMBER_HIT);
        }
        return LottoRank.getLottoRank(matchCount, BONUS_NUMBER_MISS);
    }

}
