package lotto.domain;

import lotto.domain.strategy.CreateStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Lottery {
    private final Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
    private final List<Lotto> lottery = new ArrayList<>();

    public Map<Rank, Integer> RankResult(WinningLotto winningLotto) {
        List<Rank> ranks = ranks(winningLotto, lottery);

        for (Rank rank : Rank.values()) {
            rankResult.put(rank, Collections.frequency(ranks, rank));
        }

        return rankResult;
    }

    public void createLottery(int buyLottos, CreateStrategy lottoCreateStrategy) {
        for (int i = 0; i < buyLottos; i++) {
            lottery.add(lotto(lottoCreateStrategy));
        }
    }

    public List<Lotto> getLottery() {
        return Collections.unmodifiableList(lottery);
    }

    private Lotto lotto(CreateStrategy lottoCreateStrategy) {
        return new Lotto(lottoCreateStrategy.createTempLottoNumber());
    }

    private List<Rank> ranks(WinningLotto winningLotto, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> Rank.findRank(winningLotto.countMatch(lotto), winningLotto.bonus(lotto)))
                .collect(Collectors.toList());
    }

}
