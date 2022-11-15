package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareNumber {
	final private List<Integer> winningNumbers;
	final private int bonusBall;
	final private List<List<Integer>> ticket;

	public List<List<Integer>> result = new ArrayList<>();


	public CompareNumber(WinningNumber winningNumber, BonusBall bonusBall, LottoTicket lottoTicket) {
		this.winningNumbers = winningNumber.getWinningNumbers();
		this.bonusBall = bonusBall.getBonusBall();
		this.ticket = lottoTicket.getLottoTicket();
		initResult();
		compareNumber();
	}

	// todo 하드코딩..
	private void initResult() {
		result.add(Arrays.asList(3, 5000, 0));
		result.add(Arrays.asList(4, 50000, 0));
		result.add(Arrays.asList(5, 1500000, 0));
		result.add(Arrays.asList(5, 30000000, 0));
		result.add(Arrays.asList(6, 2000000000, 0));
	}

	private void compareNumber() {
		int size;

		for (List<Integer> ticket : this.ticket) {
			size = matchNumbers(ticket);
			if (size > 2) {
				updateResult(size - 3, ticket);
			}
		}
	}

	private void updateResult(int index, List<Integer> ticket) {
		int value;

		if (index == 2 && ticket.contains(bonusBall)) {
			index = 3;
		}
		else if (index == 3){
			index = 4;
		}
		result.get(index).set(2, result.get(index).get(2) + 1);
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
