package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {
    private final List<Lotto> ticket;

    public Ticket(List<Lotto> ticket){
        this.ticket=ticket;
    }



    private Map<Ranking, Integer> initializeRanking() {
        return new HashMap<>(Map.ofEntries(
                Map.entry(Ranking.FIRST, 0),
                Map.entry(Ranking.SECOND, 0),
                Map.entry(Ranking.THIRD, 0),
                Map.entry(Ranking.FOURTH, 0),
                Map.entry(Ranking.FIFTH, 0)
        ));
    }
}
