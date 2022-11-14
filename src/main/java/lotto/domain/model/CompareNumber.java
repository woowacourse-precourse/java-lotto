package lotto.domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompareNumber {
	final private List<Integer> winningNumbers;
	final private int bonusBall;
	final private List<List<Integer>> ticket;
	private final HashMap<Integer, Integer> result = new HashMap<>();


	public CompareNumber(WinningNumber winningNumber, BonusBall bonusBall, LottoTicket lottoTicket) {
		this.winningNumbers = winningNumber.getWinningNumbers();
		this.bonusBall = bonusBall.getBonusBall();
		this.ticket = lottoTicket.getLottoTicket();
		initMap();
		compareNumber();
	}

	private void initMap() {
		for (int i = 3; i < 8; i++) {
			result.put(i, 0);
		}
	}

	private void compareNumber() {
		int size;

		for (List<Integer> ticket : this.ticket) {
			size = matchNumbers(ticket);
			if (size > 2) {
				updateResult(size, ticket);
			}
		}
	}

	private void updateResult(int size, List<Integer> ticket) {
		int value;

		if (size == 5 && ticket.contains(bonusBall)) {
			size = 7;
		}
		value = result.get(size);
		result.replace(size, value + 1);
	}

	private int matchNumbers(List<Integer> ticket) {
		int count = 0;

		for (int winningNumber : winningNumbers) {
			if (ticket.contains(winningNumber))
				count++;
		}
		return count;
	}
}
