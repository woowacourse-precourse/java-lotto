package lotto.util;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.lottoenum.Prize;

public class PrizeCalculator {
    private static Map<Prize, Integer> receivedPrizesCount;

    private PrizeCalculator() {
    }

    public static Map<Prize, Integer> calculatePrize(List<Lotto> lottos, WinningLotto winningLotto) {
        initializePrizeCount();

        lottos.stream()
                .map(lotto -> getLottoResult(lotto.getNumbers(), winningLotto))
                .forEach(PrizeCalculator::updateAccumulateCount);
        return receivedPrizesCount;
    }

    private static void initializePrizeCount() {
        receivedPrizesCount = new EnumMap<>(Prize.class);
        Stream.of(Prize.values())
                .forEach(prize -> receivedPrizesCount.put(prize, 0));
    }

    private static Prize getLottoResult(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        return Prize.checkPrizeToReceive(
                winningLotto.countMatchingNumbers(lottoNumbers),
                winningLotto.isContainingBonusNumber(lottoNumbers)); //둘 다 lotto 에 접근하는 거면 책임 분리가 잘 안된거 아닌가,,
    }

    private static void updateAccumulateCount(Prize prize) {
        receivedPrizesCount.put(prize, receivedPrizesCount.get(prize) + 1);
        // 여기서 누적 상금을 바로바로 업데이트 해도 될 것 같은데,,, 굳이 total money 연산하지 말고
    }
}
