package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.view.OutputView;

public class LottoReceipt {

	Map<LottoRank, Integer> results = new HashMap<>();

	public LottoReceipt(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
		compareTickets(lottoTickets, winningNumbers);
	}

	private void compareTickets(LottoTickets lottoTickets, WinningNumbers winningNumbers) {

		List<Integer> numbers = winningNumbers.getNumbers();
		int bonusNumber = winningNumbers.getBonusNumber();

		for (Lotto lotto : lottoTickets.getLottos()) {
			compareLotto(lotto, numbers, bonusNumber);
		}

	}

	private void compareLotto(Lotto lotto, List<Integer> numbers, int bonusNumber) {
		int numberCount = 0;
		boolean correctBonus = false;

		for (Integer number : lotto.getNumbers()) {
			numberCount += compareNumber(number, numbers);
		}

		if (numberCount == LottoRule.BONUS_CONDITION.getValue()) {
			correctBonus = compareBonus(lotto.getNumbers(), bonusNumber);
		}

		LottoRank rank = LottoRank.award(numberCount, correctBonus);
		results.put(rank, results.getOrDefault(rank, 0) + 1);
	}

	private boolean compareBonus(List<Integer> numbers, int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	private int compareNumber(Integer number, List<Integer> numbers) {
		if (numbers.contains(number)) {
			return 1;
		} else if (numbers.contains(number)) {
			return 0;
		}
		return 0;
	}

	public void print() {
		OutputView.printLottoResults(results);
	}
}
