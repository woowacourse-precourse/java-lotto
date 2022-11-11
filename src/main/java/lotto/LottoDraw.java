package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoDraw {

    private int totalPrizeMoney;
    private Map<String, Integer> numberOfWins = new HashMap<>();

    public LottoDraw() {
        this.totalPrizeMoney = 0;
        for (int rank = 1; rank <= 5; rank++) {
            numberOfWins.put(String.valueOf(rank) + "등", 0);
        }
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public Map<String, Integer> getNumberOfWins() {
        return numberOfWins;
    }
}
