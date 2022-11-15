package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
	@Test
	void 당첨금_리턴_테스트() {
		List<Prize> prizes = Arrays.asList(Prize.values());

		assertThat(prizes.get(0).getWinningPrice()).isEqualTo(2_000_000_000);
		assertThat(prizes.get(1).getWinningPrice()).isEqualTo(30_000_000);
		assertThat(prizes.get(2).getWinningPrice()).isEqualTo(1_500_000);
		assertThat(prizes.get(3).getWinningPrice()).isEqualTo(50_000);
		assertThat(prizes.get(4).getWinningPrice()).isEqualTo(5_000);
		assertThat(prizes.get(5).getWinningPrice()).isEqualTo(0);
	}

	@DisplayName("입력받은 당첨 번호 리스트와 보너스 번호 일치 여부에 따른 등수를 리턴한다.")
	@Test
	void valueOfTest() {
		//일치 번호가 0~2개일 때는 미당첨이다.
		assertThat(Prize.valueOf(0, false)).isEqualTo(Prize.NONE);
		assertThat(Prize.valueOf(1, false)).isEqualTo(Prize.NONE);
		assertThat(Prize.valueOf(2, false)).isEqualTo(Prize.NONE);

		assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.FIFTH);
		assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOURTH);

		//일치 번호가 5개일 때, 보너스 번호의 여부를 통해 등수를 리턴한다.
		assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
		assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);

		assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
	}

}
