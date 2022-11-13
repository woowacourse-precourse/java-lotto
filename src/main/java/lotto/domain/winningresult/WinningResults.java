package lotto.domain.winningresult;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;

public class WinningResults {
    private final List<WinningResultType> winningResultTypes;
    private final int purchasedAmount;

    private WinningResults(List<WinningResultType> winningResultTypes, int purchasedAmount) {
        this.winningResultTypes = winningResultTypes;
        this.purchasedAmount = purchasedAmount;
    }

    public static WinningResults of(Lottos lottos, LottoDraw lottoDraw) {
        List<WinningResultType> winningResultTypes = lottos.lottoStream()
                .map(lottoDraw::match)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        int purchasedAmount = lottos.purchasedLottosAmount();

        return new WinningResults(winningResultTypes, purchasedAmount);
    }

    public int count(WinningResultType winningResultType) {
        return (int) winningResultTypes.stream()
                .filter(o -> o == winningResultType)
                .count();
    }

    public double calculateRewardRate() {
        double rewardAmount = calculateTotalRewardAmount();
        return rewardAmount / purchasedAmount * 100;
    }

    private int calculateTotalRewardAmount() {
        return winningResultTypes.stream()
                .map(WinningResultType::getReward)
                .mapToInt(o -> o)
                .sum();
    }

}
