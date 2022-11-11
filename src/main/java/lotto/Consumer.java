package lotto;

import java.util.List;
import java.util.Map;

public class Consumer {
    private Integer cost;
    private List<List<Integer>> lottos;
    private Map<Integer, Integer> statistics;

    public Consumer(Integer cost, List<List<Integer>> lottos, Map<Integer, Integer> statistics) {
        this.cost = cost;
        this.lottos = lottos;
        this.statistics = statistics;
    }

    public Integer getCost() {
        return cost;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public Map<Integer, Integer> getStatistics() {
        return statistics;
    }
}
