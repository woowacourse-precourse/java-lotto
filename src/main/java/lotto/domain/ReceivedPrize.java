package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.lottoenum.Prize;

public class ReceivedPrize {
    private Map<Prize, Integer> receivedPrize;
    private long totalPrizeCount;

    public ReceivedPrize(List<Lotto> lottos, WinningLotto winningLotto) {
        initializeReceivedPrize();
        calculatePrizeToReceive(lottos, winningLotto);
    }

    public Map<Prize, Integer> getReceivedPrize() {
        return receivedPrize;
    }

    public double calculateRateOfReturn(int paidMoney) {
        return (double) totalPrizeCount / paidMoney * 100;
    }

    private void initializeReceivedPrize() {
        receivedPrize = new EnumMap<>(Prize.class);
        Stream.of(Prize.values())
                .forEach(prize -> receivedPrize.put(prize, 0));
    }

    private void calculatePrizeToReceive(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> getLottoResult(lotto.getNumbers(), winningLotto))
                .forEach(this::updateAccumulateCount);
    }

    private Prize getLottoResult(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return Prize.checkPrizeToReceive(
                winningLotto.countMatchingNumbers(lottoNumbers),
                winningLotto.isContainingBonusNumber(lottoNumbers));
    }

    private void updateAccumulateCount(Prize prize) {
        receivedPrize.put(prize, receivedPrize.get(prize) + 1);
        updateTotalPrizeCount(prize.getMoney());
    }

    private void updateTotalPrizeCount(int money) {
        this.totalPrizeCount += money;
    }
}
