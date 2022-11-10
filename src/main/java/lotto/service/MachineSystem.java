package lotto.service;

import java.util.List;

import lotto.domain.Buyer;
import lotto.domain.WinningLotto;

public class MachineSystem {

	private final Buyer buyer;
	private final WinningLotto winningLotto;

	public MachineSystem(Buyer buyer, WinningLotto winningLotto) {
		this.buyer = buyer;
		this.winningLotto = winningLotto;
	}

	public int checkTotalReward() {
		return 0;
	}

	public int checkWinningNumber(List<Integer> lottoNumber) {
		return (int)lottoNumber.stream()
			.filter(winningLotto.getNumbers()::contains).count();
	}
}
