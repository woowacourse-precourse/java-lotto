package lotto.domain.lotteryserver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankInfoTest {
	@Test void RankInfoUpdateAndGetTest() {
		RankInfo info = new RankInfo();

		info.update(Rank.SECOND_RANK);
		info.update(Rank.SECOND_RANK);
		info.update(Rank.SECOND_RANK);
		info.update(Rank.FIRST_RANK);
		info.update(Rank.THIRD_RANK);
		info.update(Rank.THIRD_RANK);

		Assertions.assertThat(info.get(Rank.FIRST_RANK)).isEqualTo(1);
		Assertions.assertThat(info.get(Rank.SECOND_RANK)).isEqualTo(3);
		Assertions.assertThat(info.get(Rank.THIRD_RANK)).isEqualTo(2);
	}
}
