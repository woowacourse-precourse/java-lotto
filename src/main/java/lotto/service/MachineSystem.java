package lotto.service;

import java.util.List;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Stats;
import lotto.domain.WinningLotto;

public class MachineSystem {
	private static final int PERCENTAGE = 100;

	private final Buyer buyer;
	private final WinningLotto winningLotto;

	public MachineSystem(Buyer buyer, WinningLotto winningLotto) {
		this.buyer = buyer;
		this.winningLotto = winningLotto;
	}

	public Stats createStats() {
		Stats stats = Stats.initStats();
		for (Lotto lotto : buyer.getLotto()) {
			Rank rank = Rank.getRank(checkWinningNumber(lotto.getNumbers()), checkBonusNumber(lotto.getNumbers()));
			stats.add(rank);
		}
		return stats;
	}

	private boolean checkBonusNumber(List<Integer> lottoNumbers) {
		return lottoNumbers.contains(winningLotto.getBonusNumber());
	}

	private int checkWinningNumber(List<Integer> lottoNumber) {
		return (int)lottoNumber.stream()
			.filter(winningLotto.getNumbers()::contains).count();
	}

	public double yield(int totalReward) {
		return (double)totalReward / buyer.getAmount() * PERCENTAGE;
	}
}
