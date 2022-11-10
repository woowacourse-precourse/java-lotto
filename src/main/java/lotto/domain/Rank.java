package lotto.domain;

import lotto.entity.Place;

import java.util.*;

public class Rank {

    public Map<Place, Integer> winningRanks = new HashMap<>();
    public Rank() {
        for (Place rank : Place.values()) {
            winningRanks.put(rank, 0);
        }
    }


}
