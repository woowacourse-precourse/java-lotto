package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningLotto;

public class WinningLottoTest {
	HashMap<Integer, Integer> lottoResult = new HashMap<>();
	HashMap<String, Integer> expected = new HashMap<>();
	WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

	@DisplayName("당첨된 로또 개수 확인")
	@Test
	void countWinningLotto() {
		List<List<Integer>> LotteryTickets = List.of(
			List.of(1, 2, 3, 4, 5, 6),
			List.of(1, 2, 3, 4, 5, 7),
			List.of(1, 2, 3, 4, 5, 45),
			List.of(1, 2, 3, 4, 44, 45),
			List.of(1, 2, 3, 43, 44, 45),
			List.of(1, 2, 42, 43, 44, 45));

		lottoResult = WinningLotto.produceResult(LotteryTickets);

		expected.put("First", 1);
		expected.put("Second", 1);
		expected.put("Third", 1);
		expected.put("Fourth", 1);
		expected.put("Fifth", 1);
		assertEquals(expected, lottoResult);
	}
}
