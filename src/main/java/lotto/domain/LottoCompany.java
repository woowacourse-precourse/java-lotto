package lotto.domain;

import lotto.LottoRank;

import java.util.List;

public class LottoCompany {

    public WinningNumber generate(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public double getRateOfReturn(int money, int prizeMoney) {
        return ((double) prizeMoney / money) * 100;
    }

    public int getTotalPrizeMoney(List<LottoRank> ranks) {
        return ranks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }
}
