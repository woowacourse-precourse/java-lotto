package lotto.domain.winningresult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;

public class LottoStatistics {
    private final List<WinningType> winningTypes;
    private final int purchasedAmount;

    private LottoStatistics(List<WinningType> winningTypes, int purchasedAmount) {
        this.winningTypes = winningTypes;
        this.purchasedAmount = purchasedAmount;
    }

    public static LottoStatistics of(Lottos lottos, LottoDraw lottoDraw) {
        List<WinningType> winningTypes = lottos.lottoStream()
                .map(lottoDraw::match)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int purchasedAmount = lottos.purchasedLottosAmount();

        return new LottoStatistics(winningTypes, purchasedAmount);
    }

    public int count(WinningType winningType) {
        return (int) winningTypes.stream()
                .filter(o -> o == winningType)
                .count();
    }

    public double calculateRewardRate() {
        double rewardAmount = calculateTotalRewardAmount();
        return rewardAmount / purchasedAmount * 100;
    }

    private int calculateTotalRewardAmount() {
        return winningTypes.stream()
                .map(WinningType::getReward)
                .mapToInt(o -> o)
                .sum();
    }

}
