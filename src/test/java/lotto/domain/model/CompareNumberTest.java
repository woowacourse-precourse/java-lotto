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
		BonusBall bonusBall = new BonusBall("7");
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(1, 12, 132, 13, 13, 13)); // 1개
		tickets.add(Arrays.asList(1, 2, 3, 7, 8, 9)); // 3점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(3, 1);
		for (int i = 4; i < 8; i++)
			map.put(i, 0);
		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(map, compareNumber.result);
	}

	@Test
	void 채점_5점_6점_7점() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		BonusBall bonusBall = new BonusBall("7");
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 7)); // 7점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6)); // 7점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 5; i < 8; i++)
			map.put(i, 1);
		for (int i = 3; i < 5; i++)
			map.put(i, 0);
		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(map, compareNumber.result);
	}

	@Test
	void 채점_5점2개_6점_7점() {
		WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
		BonusBall bonusBall = new BonusBall("7");
		List<List<Integer>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList(45, 2, 3, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 33, 4, 5, 6)); // 5점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 7)); // 7점
		tickets.add(Arrays.asList(1, 2, 3, 4, 5, 6)); // 7점
		LottoTicket lottoTicket = new LottoTicket(tickets);

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(5, 2);
		map.put(6, 1);
		map.put(7, 1);
		for (int i = 3; i < 5; i++)
			map.put(i, 0);
		CompareNumber compareNumber = new CompareNumber(winningNumber, bonusBall, lottoTicket);

		assertEquals(map, compareNumber.result);
	}
}