package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoRank;
import lotto.domain.Money;

public class LottoRankTest {

	@DisplayName("일치한 숫자 갯수와 보너스 당첨 여부에 따라 등수를 부여한다")
	@Nested
	class Award{

		@DisplayName("일치한 숫자 5개, 보너스 당첨 안 됐을때")
		@Test
		void thirdPrize() {
			LottoRank award = LottoRank.award(5, false);
			assertThat(award).isEqualTo(LottoRank.THIRD_PRIZE);
		}

		@DisplayName("일치한 숫자 5개, 보너스 당첨 됐을때")
		@Test
		void secondPrize() {
			LottoRank award = LottoRank.award(5, true);
			assertThat(award).isEqualTo(LottoRank.SECOND_PRIZE);
		}
	}

}
