package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningLotto;
import lotto.service.Lotto;
import lotto.util.Rank;

public class WinningLottoTest {
	EnumMap<Rank, Integer> lottoResult = new EnumMap<>(Rank.class);
	EnumMap<Rank, Integer> expected = new EnumMap<>(Rank.class);
	WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
	List<Lotto> LotteryTickets = List.of(
		new Lotto(List.of(1, 2, 3, 4, 5, 6)),
		new Lotto(List.of(1, 2, 3, 4, 5, 7)),
		new Lotto(List.of(1, 2, 3, 4, 5, 45)),
		new Lotto(List.of(1, 2, 3, 4, 44, 45)),
		new Lotto(List.of(1, 2, 3, 43, 44, 45)));

	@DisplayName("당첨된 로또 개수 확인")
	@Test
	void countWinningLotto() {
		lottoResult = winningLotto.produceResult(LotteryTickets);
		expected.put(Rank.FIRST, 1);
		expected.put(Rank.SECOND, 1);
		expected.put(Rank.THIRD, 1);
		expected.put(Rank.FOURTH, 1);
		expected.put(Rank.FIFTH, 1);
		expected.put(Rank.NOTHING, 0);
		assertEquals(expected, lottoResult);
	}
}
