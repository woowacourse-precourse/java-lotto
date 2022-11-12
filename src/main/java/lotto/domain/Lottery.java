package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public Map<Rank, Integer> RankResult(WinningLotto winningLotto, List<Lotto> lottos) {
        EnumMap<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        List<Rank> ranks = ranks(winningLotto, lottos);

        for (Rank rank : Rank.values()) {
            rankResult.put(rank, Collections.frequency(ranks, rank));
        }

        return rankResult;
    }

    public List<Lotto> createLottery(int buyLottos, CreateStrategy lottoCreateStrategy) {
        return IntStream.range(0, buyLottos)
                .mapToObj(ticket -> lottoCreateStrategy.createTempLottoNumber())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<Rank> ranks(WinningLotto winningLotto, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> Rank.findRank(winningLotto.countMatch(lotto), winningLotto.bonus(lotto)))
                .collect(Collectors.toList());
    }


}
