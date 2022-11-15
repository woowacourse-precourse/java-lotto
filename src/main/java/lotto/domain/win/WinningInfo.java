package lotto.domain.win;

import java.util.EnumMap;
import java.util.Map;

public class WinningInfo {

	private Map<Winning, Integer> winnings;

	WinningInfo() {
		winnings = new EnumMap<>(Winning.class);
		for (Winning winning : Winning.values()) {
			winnings.put(winning, 0);
		}
	}

	public void update(final Winning winning) {
		winnings.put(winning, winnings.get(winning) + 1);
	}

	public Map<Winning, Integer> getWinnings() {
		return winnings;
	}
}
