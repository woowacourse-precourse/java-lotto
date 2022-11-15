package lotto.service;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class MachineSystem {
	private final Buyer buyer;
	private final WinningLotto winningLotto;

	public MachineSystem(Buyer buyer, WinningLotto winningLotto) {
		this.buyer = buyer;
		this.winningLotto = winningLotto;
	}

	public List<Rank> matchLottos() {
		return buyer.getLotto()
			.stream()
			.map(this::matchLotto)
			.collect(Collectors.toList());
	}

	public Rank matchLotto(Lotto lotto) {
		return Rank.getRank(checkWinningNumber(lotto.getNumbers()), checkBonusNumber(lotto.getNumbers()));
	}

	private boolean checkBonusNumber(List<Integer> lottoNumbers) {
		return lottoNumbers.contains(winningLotto.getBonusNumber());
	}

	private int checkWinningNumber(List<Integer> lottoNumber) {
		return (int)lottoNumber.stream()
			.filter(winningLotto.getNumbers()::contains)
			.count();
	}
}
