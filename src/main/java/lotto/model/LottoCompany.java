package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoCompany {

	private final List<Integer> winningNumber;
	private final int bonusNumber;

	public LottoCompany(String winningNumber, String bonusNumber) {
		Lotto validateNumber = new Lotto(stringToLotte(winningNumber));
		this.winningNumber = validateNumber.getNumbers();
		this.bonusNumber = Integer.parseInt(bonusNumber);
	}

	private List<Integer> stringToLotte(String winningNumber) {
		List<Integer> lotto = new ArrayList<>();
		for (String number : winningNumber.split(",")) {
			lotto.add(Integer.parseInt(number));
		}
		return lotto;
	}

	public List<Integer> getWinningNumber() {
		return winningNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
