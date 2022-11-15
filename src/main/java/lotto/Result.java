package lotto;

import java.util.*;

public class Result {
    private List<Rank> winningHistory = new LinkedList<>();

    public void addWinningHistory(Rank rank) {
        if (Objects.nonNull(rank)) {
            winningHistory.add(rank);
        }
    }
}
