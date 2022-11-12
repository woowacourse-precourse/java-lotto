package lotto.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

	private final Bonus bonus;
	private final Set<Integer> winningLottoNumber;

	public WinningLotto(Lotto lotto, int bonusNumber) {
		winningLottoNumber = new HashSet<>(lotto.getLottoNumber());
		this.bonus = new Bonus(bonusNumber, lotto);
	}

	public Rank compareTo(Lotto userLotto) {
		List<Integer> userLottoNumber = userLotto.getLottoNumber();

		int matchedNumberCount = countMatchedNumberOfUserLottoFromWinningLotto(userLottoNumber);

		Rank rank = Rank.getRankByMatchedNumberCount(matchedNumberCount);

		if (isSecondRank(userLottoNumber, rank)) {
			return Rank.SECOND;
		}

		return rank;
	}

	private boolean isSecondRank(List<Integer> userLottoNumber, Rank rank) {
		return rank == Rank.THIRD && bonus.isContained(userLottoNumber);
	}

	protected int countMatchedNumberOfUserLottoFromWinningLotto(List<Integer> userLotto) {
		return (int) userLotto.stream()
				.filter(winningLottoNumber::contains)
				.count();
	}
}
