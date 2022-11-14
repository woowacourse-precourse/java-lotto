package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lotto.util.WonMaker;

public enum Rank {
    FIFTH(3, 0, 5_000), FOURTH(4, 0, 50_000), THIRD(5, 0, 1_500_000), SECOND(5, 1, 30_000_000), FIRST(6, 0,
            2_000_000_000);

    private int equalCount;
    private int bonusCount;
    private int rewardMoney;

    Rank(int equalCount, int bonusCount, int rewardMoney) {
        this.equalCount = equalCount;
        this.bonusCount = bonusCount;
        this.rewardMoney = rewardMoney;
    }

    public static List<Rank> getRanks(List<Lotto> expectLottos, ResultLotto resultLotto) {
        return expectLottos.stream()
                .filter(expectLotto -> getRank(expectLotto, resultLotto).isPresent())
                .map(expectLotto -> getRank(expectLotto, resultLotto).get())
                .collect(Collectors.toList());
    }

    private static Optional<Rank> getRank(Lotto expectLotto, ResultLotto resultLotto) {
        return Arrays.stream(Rank.values())
                .filter(rank -> expectLotto.isSame(resultLotto, rank))
                .findAny();
    }

    public static Map<Rank, Long> getStatistics(List<Rank> ranks) {
        Map<Rank, Long> statistics = new TreeMap<>((x, y) -> x.getRewardMoney() - y.getRewardMoney());
        final Long initValue = 0L;
        for (Rank rank : values()) {
            statistics.merge(rank, initValue, Long::sum);
        }
        final Long count = 1L;
        for (Rank rank : ranks) {
            statistics.merge(rank, count, Long::sum);
        }

        return statistics;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    @Override
    public String toString() {
        StringBuffer name = new StringBuffer();
        name.append(equalCount);
        name.append("개 일치");
        if (this == Rank.SECOND) {
            name.append(", 보너스 볼 일치");
        }
        name.append(" ");
        name.append("(");
        name.append(WonMaker.makeWon(rewardMoney));
        name.append(")");
        return name.toString();
    }
}
