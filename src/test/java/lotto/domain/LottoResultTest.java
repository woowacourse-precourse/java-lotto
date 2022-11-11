package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	@DisplayName("결과가 잘 나오는지 확인")
	@Test
	void countPrizeTest() {
		int ticketNumber = 8;
		int bonusNumber = 7;
		List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
		List<List<Integer>> lottoTickets = new ArrayList<>();

		lottoTickets.add(List.of(8, 21, 23, 7, 1, 2));
		lottoTickets.add(List.of(1, 2, 4, 5, 6, 3));
		lottoTickets.add(List.of(4, 3, 2, 1, 7, 6));
		lottoTickets.add(List.of(8, 21, 23, 41, 42, 43));
		lottoTickets.add(List.of(8, 21, 32, 41, 42, 43));
		lottoTickets.add(List.of(8, 21, 23, 45, 42, 41));
		lottoTickets.add(List.of(8, 2, 1, 19, 39, 30));
		lottoTickets.add(List.of(4, 3, 13, 5, 23, 10));

		LottoResult lottoResult = new LottoResult(lottoTickets, winningNumber, bonusNumber);
		HashMap<String, Integer> result = lottoResult.countWin();

		HashMap <String, Integer> test = new HashMap<>();
		test.put("secondPrize", 1);
		test.put("firstPrize", 1);
		test.put("fifthPrize", 1);

		assertEquals(test, result);
	}
}
