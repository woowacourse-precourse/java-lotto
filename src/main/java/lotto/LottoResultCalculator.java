package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private static final int RANK_OFFSET = 7;
    private List<Integer> winningNums;
    private int bonusNum;

    private LottoResultCalculator() {
    }

    private static class LottoResultCalculatorHelper {
        private static final LottoResultCalculator INSTANCE = new LottoResultCalculator();
    }

    public static LottoResultCalculator getInstance() {
        return LottoResultCalculatorHelper.INSTANCE;
    }

    public void setWinningNums(List<Integer> winningNums) {
        this.winningNums = winningNums;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public double calRateOfReturn(long winningAmount, int money) {
        return ((double) winningAmount / money) * 100;
    }

    public long calWinningAmount(EnumMap<Rank, Integer> ranks) {
        return ranks.entrySet()
                .stream()
                .mapToLong(rankIntegerEntry -> {
                    Rank rank = rankIntegerEntry.getKey();
                    int cnt = rankIntegerEntry.getValue();
                    return rank.getAmount() * cnt;
                })
                .sum();
    }

    public EnumMap<Rank, Integer> calRankAll(List<Lotto> lottos) {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> ranks.put(rank, 0));

        lottos.forEach(lotto -> {
            calRank(lotto).ifPresent(rank -> {
                ranks.put(rank, ranks.get(rank) + 1);
            });
        });

        return ranks;
    }

    private Optional<Rank> calRank(Lotto lotto) {
        int matchedWinningNumCnt = compareWithWinningNums(lotto);
        int matchedBonusNumCnt = compareWithBonusNum(lotto);

        if (matchedBonusNumCnt == 1 && matchedWinningNumCnt == 5) {
            return Optional.of(Rank.SECOND_PRIZE);
        }

        if (matchedWinningNumCnt == 6) {
            return Optional.of(Rank.FIRST_PRIZE);
        }

        if (matchedWinningNumCnt < 3) {
            return Optional.empty();
        }

        return Optional.of(Rank.values()[RANK_OFFSET - matchedWinningNumCnt]);
    }


    private int compareWithWinningNums(Lotto lotto) {
        int matchedNumCnt = (int) lotto.getNumbers()
                .stream()
                .filter(integer -> winningNums.contains(integer))
                .count();

        return matchedNumCnt;
    }

    private int compareWithBonusNum(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNum)) {
            return 1;
        }

        return 0;
    }
}
