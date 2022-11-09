package lotto.domain;

import lotto.entity.Place;

import java.util.*;

public class Rank {

    public Map<Place, Integer> winRank = new HashMap<>();
    public Rank() {
        for (Place rank : Place.values()) {
            winRank.put(rank, 0);
        }
    }

    public void setWinRank(List<Integer> correctNumbers, boolean includeBonus) {
        List<Integer> winNumbers = correctNumbers;
        winNumbers.removeAll(List.of(0));
        for (Integer winNumber : winNumbers) {
            
        }
    }
}
