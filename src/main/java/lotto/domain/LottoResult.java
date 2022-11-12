package lotto.domain;

import java.util.Map;
import java.util.Optional;

public class LottoResult {

    public int getTotalReward(Map<LottoRanking, Integer> rankingData) {
        Optional<Integer> result = rankingData.entrySet()
                .stream()
                .map((entry) -> entry.getKey().getReward() * entry.getValue())
                .reduce((x, y) -> x + y);
        return result.get();
    }

    public int getTotalTicket(Map<LottoRanking, Integer> rankingData) {
        Optional<Integer> totalTicket = rankingData.values()
                .stream()
                .reduce((x, y) -> x + y);
        return totalTicket.get();
    }
}
