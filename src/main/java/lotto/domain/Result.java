package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private final Map<Ranking, Integer> result;
    private final Money money;

    public Result(Map<Ranking, Integer> result, Money money) {
        this.result = result;
        this.money = money;
    }

    public double yield() {
        long reward = 0;
        for (Ranking ranking : result.keySet()) {
            int count = result.get(ranking);
            reward += ranking.reward(count);
        }
        return money.yield(reward);
    }

    @Override
    public String toString() {
        return rankings(result).stream()
                .map(ranking -> String.format("%s - %d개", ranking, result.get(ranking)))
                .collect(Collectors.joining("\n"));
    }

    private static List<Ranking> rankings(Map<Ranking, Integer> result) {
        return result.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
