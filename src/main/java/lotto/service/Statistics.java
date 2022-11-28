package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Winning;

import java.util.*;
import java.util.stream.IntStream;

public class Statistics {

    private static final Long FIRST_REWARD = 2_000_000_000L;
    private static final Long SECOND_REWARD = 30_000_000L;
    private static final Long THIRD_REWARD = 1_500_000L;
    private static final Long FOURTH_REWARD = 50_000L;
    private static final Long FIFTH_REWARD = 5_000L;

    private Winning winning;
    private List<Lotto> issuedLotteries;
    private final Map<Integer, Integer> winningResult = new LinkedHashMap<>();

    public Statistics(Winning winning, List<Lotto> issuedLotteries) {
        this.winning = winning;
        this.issuedLotteries = issuedLotteries;
        initWinningResult();
    }

    public Map<Integer, Integer> winningResult() {
        List<Integer> ranks = calculateRanks();
        ranks.forEach(x -> winningResult.put(x, winningResult.getOrDefault(x, 0)+1));
        return winningResult;
    }

    public double yield() {
        long sum = winningResult.get(1) * FIRST_REWARD
                + winningResult.get(2) * SECOND_REWARD
                + winningResult.get(3) * THIRD_REWARD
                + winningResult.get(4) * FOURTH_REWARD
                + winningResult.get(5) * FIFTH_REWARD;
        return (double) sum / (1000 * issuedLotteries.size());
    }

    private void initWinningResult() {
        IntStream.range(1,6).forEach(x -> winningResult.put(x, 0));
    }

    private List<Integer> calculateRanks() {
        List<Integer> list = new ArrayList<>();
        for (Lotto lotto : issuedLotteries) {
            int matchCounts = matchCounts(lotto);
            if (matchCounts == 6) list.add(1);
            if (matchCounts == 4) list.add(4);
            if (matchCounts == 3) list.add(5);
            if (matchCounts == 5) list.add(secondOrThird(lotto));
        }
        return list;
    }

    private int matchCounts(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return (int)winning.getWinningNumbers()
                .stream()
                .filter(numbers::contains)
                .count();
    }

    private int secondOrThird(Lotto lotto) {
        Integer bonusNumber = winning.getBonusNumber();
        if (lotto.getNumbers().contains(bonusNumber)) {
            return 2;
        }
        return 3;
    }
}
