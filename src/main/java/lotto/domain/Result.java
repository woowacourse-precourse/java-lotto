package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Result {
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public Result(List<Rank> ranks) {
        Rank[] temp = Rank.values();
        for (int i = 0; i < temp.length; i++){
            result.put(temp[i], 0);
        }

        for(Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }
    public long winningAmount() {
        long totalAmount = 0;
        for (Rank rank : result.keySet()) {
            int winningCount = result.get(rank);
            totalAmount += (long) rank.getPrize() * winningCount;
        }
        return totalAmount;
    }
    public Map<Rank, Integer> getResult() {
        return result;
    }

    public Set<Entry<Rank, Integer>> entrySet(){
        return result.entrySet();
    }
}
