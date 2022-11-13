package lotto.util;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.lottoenum.Prize;

public class PrizeCalculator {

    private PrizeCalculator() {
    }

    public static Map<Prize, Integer> calculatePrize(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Prize, Integer> receivedPrizesCount = new EnumMap<>(Prize.class);
        lottos.stream()
                .map(lotto -> getLottoResult(lotto.getNumbers(), winningLotto))
                .forEach(prize -> updateAccumulateCount(prize, receivedPrizesCount));
        return receivedPrizesCount;
    }

    private static Prize getLottoResult(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return Prize.checkPrizeToReceive(
                winningLotto.countMatchingNumbers(lottoNumbers),
                winningLotto.isContainingBonusNumber(lottoNumbers)); //둘 다 lotto 에 접근하는 거면 책임 분리가 잘 안된거 아닌가,,
    }

    private static void updateAccumulateCount(Prize prize, Map<Prize, Integer> receivedPrizesCount) {
        int accumulateCount = 1;
        if (receivedPrizesCount.containsKey(prize)) {
            accumulateCount = receivedPrizesCount.get(prize) + 1;
        }
        receivedPrizesCount.put(prize, accumulateCount);
    }
}
