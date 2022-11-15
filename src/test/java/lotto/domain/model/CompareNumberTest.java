package lotto.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareNumberTest {
	@Test
	void 채점_1점_3점() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		BonusBall bonusBall = new BonusBall("7", winningNumber.getWinningNumbers());
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(1, 12, 132, 13, 13, 13)); // 1개
		tickets.add(Arrays.asList(1, 2, 3, 7, 8, 9)); // 3점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(3, 5000, 1));
		answer.add(Arrays.asList(4, 50000, 0));
		answer.add(Arrays.asList(5, 1500000, 0));
		answer.add(Arrays.asList(5, 30000000, 0));
		answer.add(Arrays.asList(6, 2000000000, 0));

		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(answer, compareNumber.result);
	}

	@Test
	void 채점_5점_6점_7점() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		BonusBall bonusBall = new BonusBall("7", winningNumber.getWinningNumbers());
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 7)); // 7점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(3, 5000, 0));
		answer.add(Arrays.asList(4, 50000, 0));
		answer.add(Arrays.asList(5, 1500000, 1));
		answer.add(Arrays.asList(5, 30000000, 1));
		answer.add(Arrays.asList(6, 2000000000, 1));

		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(answer, compareNumber.result);
	}

	@Test
	void 채점_5점2개_6점_7점() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		BonusBall bonusBall = new BonusBall("7", winningNumber.getWinningNumbers());
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 33, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 7)); // 7점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(3, 5000, 0));
		answer.add(Arrays.asList(4, 50000, 0));
		answer.add(Arrays.asList(5, 1500000, 2));
		answer.add(Arrays.asList(5, 30000000, 1));
		answer.add(Arrays.asList(6, 2000000000, 1));

		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(answer, compareNumber.result);
	}
}