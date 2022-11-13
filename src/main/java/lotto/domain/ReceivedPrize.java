package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.lottoenum.Prize;
import lotto.util.PrizeCalculator;

public class ReceivedPrize {
    private final Map<Prize, Integer> receivedPrize;

    public ReceivedPrize(List<Lotto> lottos, WinningLotto winningLotto) {
        this.receivedPrize = PrizeCalculator.calculatePrize(lottos, winningLotto);
    }

    public Map<Prize, Integer> getReceivedPrize() {
        return receivedPrize;
    }

    public double calculateRateOfReturn(int money) {
        return (double) calculateTotalPrizeMoney() / money * 100;
    }

    private long calculateTotalPrizeMoney() {
        return receivedPrize.entrySet()
                .stream()
                .map(set -> set.getKey().getTotalMoney(set.getValue()))
                .mapToLong(Long::longValue)
                .sum();
    }
}
