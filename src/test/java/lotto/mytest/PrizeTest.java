package lotto.mytest;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Prize;
import lotto.Rank;

public class PrizeTest {
	EnumMap<Rank, Integer> prizeResult = new EnumMap<>(Rank.class);
	Long totalPrize = 0L;

	@DisplayName("당첨금 계산 확인")
	@Test
	void prizeTest() {
		/*prizeResult.put(Rank.FIRST, 0);
		prizeResult.put(Rank.SECOND, 3);
		prizeResult.put(Rank.THIRD, 1);
		prizeResult.put(Rank.FOURTH, 0);
		prizeResult.put(Rank.FIFTH, 1);
		totalPrize = Prize.getTotalPrizeMoney(prizeResult);
		assertThat(totalPrize).isEqualTo(91505000);*/
	}
}
