package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Constants.*;

public class CompareNumber {
	private final List<Integer> winningNumbers;
	private final int bonusBall;
	private final List<List<Integer>> ticket;
	public List<List<Integer>> result = new ArrayList<>();

	public CompareNumber(WinningNumber winningNumber, BonusBall bonusBall, LottoTicket lottoTicket) {
		this.winningNumbers = winningNumber.getWinningNumbers();
		this.bonusBall = bonusBall.getBonusBall();
		this.ticket = lottoTicket.getLottoTicket();
		initResult();
		compareNumber();
	}

	private void initResult() {
		result.add(Arrays.asList(3, FIFTH, 0));
		result.add(Arrays.asList(4, FOURTH, 0));
		result.add(Arrays.asList(5, THIRD, 0));
		result.add(Arrays.asList(5, SECOND, 0));
		result.add(Arrays.asList(6, FIRST, 0));
	}

	private void compareNumber() {
		int size;

		for (List<Integer> ticket : this.ticket) {
			size = matchNumbers(ticket);
			if (size >= MINIMUM_FOR_WIN) {
					updateResult(size - MINIMUM_FOR_WIN, ticket);
			}
		}
	}

	private void updateResult(int index, List<Integer> ticket) {
		if (index == 3) {
			index = 4;
		}
		if (index == 2 && ticket.contains(bonusBall)) {
			index = 3;
		}
		result.get(index).set(2, result.get(index).get(2) + 1);
	}

	private int matchNumbers(List<Integer> ticket) {
		int count = 0;

		for (int winningNumber : winningNumbers) {
			if (ticket.contains(winningNumber)) {
					count++;
			}
		}
		return count;
	}
}
