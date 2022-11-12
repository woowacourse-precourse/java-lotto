package lotto.domain;

import java.util.Map;
import java.util.Optional;

public class LottoResult {

    public int getTotalTicket(Map<LottoRanking, Integer> rankingData) {
        Optional<Integer> totalTicket = rankingData.values()
                .stream()
                .reduce((x, y) -> x + y);
        return totalTicket.get();
    }
}
