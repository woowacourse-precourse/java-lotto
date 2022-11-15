package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Ranking, Integer> compare(WinningNumber winningNumber) {
        Map<Ranking, Integer> result = result();
        for (Lotto lotto : lottos) {
            Ranking ranking = winningNumber.compare(lotto);
            result.put(ranking, result.getOrDefault(ranking, 0) + 1);
        }
        return result;
    }

    public int count() {
        return lottos.size();
    }

    private Map<Ranking, Integer> result() {
        Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
        result.put(Ranking.FIRST, 0);
        result.put(Ranking.SECOND, 0);
        result.put(Ranking.THIRD, 0);
        result.put(Ranking.FOURTH, 0);
        result.put(Ranking.FIFTH, 0);
        result.put(Ranking.MISS, 0);
        return result;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
