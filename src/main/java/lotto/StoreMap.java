package lotto;

import java.util.SortedMap;
import java.util.TreeMap;

public class StoreMap {

	public SortedMap<Rank, Integer> StoreMap;

	public StoreMap() {
		StoreMap = new TreeMap<>();
		StoreMap.put(Rank.MISS, 0);
		StoreMap.put(Rank.FIRST, 0);
		StoreMap.put(Rank.SECOND, 0);
		StoreMap.put(Rank.THIRD, 0);
		StoreMap.put(Rank.FOURTH, 0);
		StoreMap.put(Rank.FIFTH, 0);
	}

	public void pushStoreMap(Rank rank) {
		StoreMap.put(rank, StoreMap.get(rank) + 1);
	}
}
