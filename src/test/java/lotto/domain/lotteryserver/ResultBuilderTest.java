package lotto.domain.lotteryserver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultBuilderTest {
	@Test void profitFormatterTest1() {
		String prizeMoney = ResultBuilder.getPrizeMoney(Rank.FIRST_RANK);
		String profit = ResultBuilder.getProfit("1000000000.0");

		Assertions.assertThat(prizeMoney).isEqualTo("(2,000,000,000원) - ");
		Assertions.assertThat(profit).isEqualTo("총 수익률은 1,000,000,000.0%입니다.");
	}
}
