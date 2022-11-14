package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    private HashMap<Rank, Integer> result;

    public LottoResult() {
        this.resultInit();
    }

    private void resultInit() {
        result = new HashMap<>();
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.OTHER, 0);
    }

    public void addRankCount(Rank rank){
        result.put(rank, result.get(rank) + 1);
    }

    public HashMap<Rank, Integer> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "result=" + result +
                '}';
    }
}
