package lotto.controller;

import lotto.model.JackpotBonus;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

public enum RankCalculator {
    INSTANCE;

    public static Rank getRankOf(JackpotBonus jackpotBonus, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int jackpotHitCnt = countJackpotHits(jackpotBonus, lottoNumbers);
        boolean hitBonus = doesHitBonus(jackpotBonus, lottoNumbers);

        return Rank.getInstanceOf(jackpotHitCnt, hitBonus);
    }

    private static int countJackpotHits(JackpotBonus jackpotBonus, List<Integer> lottoNumbers) {
        List<Integer> jackpotNumbers = jackpotBonus.getJackpotNumbers();

        return (int) lottoNumbers.stream()
                .filter(jackpotNumbers::contains)
                .count();
    }

    private static boolean doesHitBonus(JackpotBonus jackpotBonus, List<Integer> lottoNumbers) {
        int bonusNumber = jackpotBonus.getBonusNumber();
        return lottoNumbers.contains(bonusNumber);
    }

}
