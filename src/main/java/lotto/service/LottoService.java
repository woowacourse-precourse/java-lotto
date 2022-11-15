package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.User;
import lotto.domain.WinningLotto;
import lotto.dto.ProfitDto;

public class LottoService {

    public static final Boolean BONUS_NUMBER_HIT = true;
    public static final Boolean BONUS_NUMBER_MISS = false;
    public static final int PERCENT = 100;

    public void calculateRankings(User user, WinningLotto winningLotto) {
        for (Lotto purchasedLotto : user.getLottos()) {
            Ranking ranking = calculateLottoRank(purchasedLotto, winningLotto);
            user.getRankings().add(ranking);
        }
    }

    public ProfitDto calculateProfit(User user) {
        List<Ranking> rankings = user.getRankings();

        long sumOfPrizeMoney = rankings.stream()
                .mapToLong(Ranking::getPrizeMoney)
                .sum();
        int purchaseAmount = user.getPurchaseCount() * Lotto.LOTTO_UNIT;
        double profit = (double) sumOfPrizeMoney / purchaseAmount * PERCENT;
        return ProfitDto.of(profit);
    }

    private Ranking calculateLottoRank(Lotto purchasedLotto, WinningLotto winningLotto) {
        List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        int matchCount = (int) purchasedLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();

        Integer bonusNumber = winningLotto.getBonusNumber();
        if (purchasedLottoNumbers.contains(bonusNumber)) {
            return Ranking.getRanking(matchCount, BONUS_NUMBER_HIT);
        }
        return Ranking.getRanking(matchCount, BONUS_NUMBER_MISS);
    }
}
