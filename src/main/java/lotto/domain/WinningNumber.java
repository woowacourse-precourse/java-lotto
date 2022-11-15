package lotto.domain;

import java.util.List;

public class WinningNumber {
	private Lotto winningLotto;
	private int bounusNumber;

	public WinningNumber(List<Integer> winningNumbers, int bounusNumberInput) {
		validate(winningNumbers, bounusNumberInput);
		this.winningLotto = new Lotto(winningNumbers);
		this.bounusNumber = bounusNumberInput;
	}

	private void validate(List<Integer> winningNumbers, int bounusNumber) {
		if(bounusNumber < Lotto.MIN_LOTTO_NUMBER || bounusNumber > Lotto.MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + Lotto.MIN_LOTTO_NUMBER +"부터 " + Lotto.MAX_LOTTO_NUMBER + "사이의 숫자여야 합니다.");
		}

		if(winningNumbers.contains(bounusNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 중복 될 수 없습니다.");
		}
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public int getBounusNumber() {
		return bounusNumber;
	}
}
