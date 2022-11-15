package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.WinningLotto;
import java.util.LinkedHashMap;

public class Result {
    private final LinkedHashMap<Rank, Integer> value = new LinkedHashMap<>();

    private Result(final LottoGroup lottos, final WinningLotto winningLotto) {
        for (Lotto lotto : lottos.get()) {
            Rank rank = Rank.of(lotto.countSameNum(winningLotto), lotto.contains(winningLotto.getBonusNumber()));
            add(rank);
        }
    }

    public static Result of(final LottoGroup lottos, final WinningLotto winningLotto) {
        return new Result(lottos, winningLotto);
    }

    private void add(final Rank rank) {
        value.merge(rank, 1, Integer::sum);
    }

    public long getPrize() {
        long prize = 0;
        for (Rank rank : value.keySet()) {
            prize += (long) rank.getPrize() * value.get(rank);
        }
        return prize;
    }

    public int getRankCount(final Rank rank) {
        return value.getOrDefault(rank, 0);
    }
}