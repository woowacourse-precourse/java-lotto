package lotto.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Consumer {

    private final List<Lotto> lottos;

    public Consumer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Rank, Integer> confirmResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = initResult();
        lottos.stream()
            .map(winningLotto::compare)
            .forEach(rank -> result.put(rank, result.getOrDefault(rank, 0) + 1));
        return result;
    }

    private Map<Rank, Integer> initResult() {
        Map<Rank, Integer> result = new TreeMap<>(new Comparator<Rank>() {
            @Override
            public int compare(Rank rank1, Rank rank2) {
                return rank1.getPrize() - rank2.getPrize();
            }
        });
        Arrays.stream(Rank.values())
            .forEach(rank -> result.put(rank, 0));
        return result;
    }

}
