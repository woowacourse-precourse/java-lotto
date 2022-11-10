package lotto.domain;

import java.util.List;

public class Company {

	private List<Integer> winningLotto;
	private int bonus;

	public Company(List<Integer> winningLotto, int bonus) {
		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public List<Integer> getWinningLotto() {
		return winningLotto;
	}
}
