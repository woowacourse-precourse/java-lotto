package lotto.domain.winningresult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;

public class LottoStatistics {
    private final List<WinningType> winningTypes;
    private final double rewardRate;

    private LottoStatistics(List<WinningType> winningTypes, double rewardRate) {
        this.winningTypes = winningTypes;
        this.rewardRate = rewardRate;
    }

    public static LottoStatistics of(Lottos lottos, LottoDraw lottoDraw) {
        List<WinningType> winningTypes = lottos.stream()
                .map(lottoDraw::match)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int purchasedAmount = lottos.purchasedLottosAmount();
        int rewardAmount = calculateTotalRewardAmount(winningTypes);
        double rewardRate = calculateRewardRate(purchasedAmount, rewardAmount);

        return new LottoStatistics(winningTypes, rewardRate);
    }

    public int count(WinningType winningType) {
        return (int) winningTypes.stream()
                .filter(o -> o == winningType)
                .count();
    }

    public double getRewardRate() {
        return rewardRate;
    }

    private static double calculateRewardRate(double purchasedAmount, double rewardAmount) {
        return rewardAmount / purchasedAmount * 100;
    }

    private static int calculateTotalRewardAmount(List<WinningType> winningTypes) {
        return winningTypes.stream()
                .map(WinningType::getReward)
                .mapToInt(o -> o)
                .sum();
    }

}
