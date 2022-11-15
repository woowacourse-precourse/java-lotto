package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

	@ParameterizedTest
	@DisplayName("등수에 해당하지 않는 NO_RANK 반환 테스트")
	@CsvSource({
		"2, true",
		"1, false",
		"0, true"
	})
	void checkReturnRankTest(int sameCount, boolean bonusNumber) {
		Rank rank = Rank.getRank(sameCount, bonusNumber);
		assertThat(rank).isEqualByComparingTo(Rank.NO_RANK);
	}
}
