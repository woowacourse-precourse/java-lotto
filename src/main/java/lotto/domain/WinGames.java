package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinGames {
	private List<Lotto> lottoTicket;
	private List<Integer> winningNumbers;
	private int bonusNumber;
	private Map<Grade, Integer> winGames = new EnumMap<>(Grade.class);

	public WinGames(List<Lotto> lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
		this.lottoTicket = lottoTicket;
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
		resetWinGames();
		checkLottoTicket();
	}

	private void resetWinGames() {
		Arrays.stream(Grade.values())
			.filter(grade -> grade != Grade.DEFAULT)
			.forEach(grade -> winGames.put(grade, 0));
	}

	private void checkLottoTicket() {
		lottoTicket.stream()
			.forEach(lotto -> checkLotto(lotto));
	}

	private void checkLotto(Lotto lotto) {
		int correctNumberCount = getCorrectNumberCount(lotto);
		boolean hasBonusNumber = hasBonusNumber(lotto);
		Grade grade = Grade.findGrade(correctNumberCount, hasBonusNumber);
		addWinGame(grade);
	}

	private int getCorrectNumberCount(Lotto lotto) {
		return (int) lotto.getNumbers().stream()
			.filter(number -> winningNumbers.contains(number))
			.count();
	}

	private boolean hasBonusNumber(Lotto lotto) {
		List<Integer> lottoNumbers = lotto.getNumbers();
		return lottoNumbers.contains(bonusNumber);
	}

	private void addWinGame(Grade grade) {
		if (grade != Grade.DEFAULT) {
			winGames.put(grade, winGames.get(grade) + 1);
		}
	}

	public Map<Grade, Integer> getWinGames() {
		return this.winGames;
	}

	public long getTotalCashPrize() {
		return winGames.entrySet().stream()
			.map(entry -> (long) (entry.getKey().getCashPrize() * entry.getValue()))
			.reduce((sumCashPrize1, sumCashPrize2) -> sumCashPrize1 + sumCashPrize2)
			.get();
	}
}
