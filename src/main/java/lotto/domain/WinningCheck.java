package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningCheck {
	public static List<Prize> getPrizes(List<Lotto> lotteries, WinningNumbersIncludingBonus winnings) {
		List<Prize> prizes = new ArrayList<>();
		for (Lotto lotto : lotteries) {
			int hitCount = getHitCount(lotto, winnings.getWinningNumbers());
			boolean bonusWinning = lotto.getNumbers().contains(winnings.getBonusNumber());
			prizes.add(Prize.valueOf(hitCount, bonusWinning));
		}

		return prizes;
	}

	public static String getReturnRatio(List<Prize> prizes, int purchasePrice) {
		int winningPrice = Collections.frequency(prizes, Prize.FIFTH) * Prize.FIFTH.getWinningPrice()
				+ Collections.frequency(prizes, Prize.FOURTH) * Prize.FOURTH.getWinningPrice()
				+ Collections.frequency(prizes, Prize.THIRD) * Prize.THIRD.getWinningPrice()
				+ Collections.frequency(prizes, Prize.SECOND) * Prize.SECOND.getWinningPrice()
				+ Collections.frequency(prizes, Prize.FIRST) * Prize.FIRST.getWinningPrice();

		double returnRatio = (double)winningPrice / purchasePrice * 100;

		String roundReturnRatio = String.format("%.1f", returnRatio);

		DecimalFormat decFormat = new DecimalFormat("###,###.#");
		String formattedRoundReturnRatio = decFormat.format(Double.parseDouble(roundReturnRatio));

		return formattedRoundReturnRatio;
	}

	private static int getHitCount(Lotto lotto, Lotto winningNumbers) {
		int count = 0;
		for (int number : lotto.getNumbers()) {
			if (winningNumbers.getNumbers().contains(number)) {
				count++;
			}
		}

		return count;
	}
}
