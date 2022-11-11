package lotto.domain;

import java.util.List;

public class Company {

	private List<Integer> winningLotto;
	private int bonus;

	public Company(List<Integer> winningLotto, int bonus) {
		checkException(winningLotto, bonus);

		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public List<Integer> getWinningLotto() {
		return winningLotto;
	}

	private void checkException(List<Integer> lotto, int bonus) {
		if (lotto.contains(bonus)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호와 다른 보너스 숫자를 입력해주세요.");
		}
	}
}
